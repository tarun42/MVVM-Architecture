package com.example.mvvmarchitecture.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.data.db.AppDatabase
import com.example.mvvmarchitecture.data.db.User
import com.example.mvvmarchitecture.data.network.MyApi
import com.example.mvvmarchitecture.data.network.NetworkConnectionInterceptor
import com.example.mvvmarchitecture.data.reposistries.UserReposotory
import com.example.mvvmarchitecture.databinding.ActivityLoginBinding
import com.example.mvvmarchitecture.ui.home.HomeActivity
import com.example.mvvmarchitecture.util.hide
import com.example.mvvmarchitecture.util.show
import com.example.mvvmarchitecture.util.snackbar
import com.example.mvvmarchitecture.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val networkConnectionInterceptor = NetworkConnectionInterceptor(this)
        val api =MyApi(networkConnectionInterceptor)
        val db =AppDatabase(this)
        val repository =UserReposotory(api,db)
        val factory =AuthViewModelFactory( repository)

        setContentView(R.layout.activity_login)
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this,factory).get(AuthViewModel::class.java)

        binding.viewmodel =viewModel
        viewModel.authListener=this
        viewModel.getLoggedInUser().observe(this, Observer {
            user ->
            if(user != null)
            {
                Intent(this,HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }

        })

    }

    override fun onstarted() {
//        toast("Login Strated")
        progress_bar.show()
    }

    override fun onsuccess(user : User) {
        progress_bar.hide()
//        toast("$(user.name) is logged in")
    root_layout.snackbar("$(user.name) is logged in")
    }


    override fun onfaliure(message: String) {
        progress_bar.hide()
//        toast(message)
        root_layout.snackbar(message)
    }
}