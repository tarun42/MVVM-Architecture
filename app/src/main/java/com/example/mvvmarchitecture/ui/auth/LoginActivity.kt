package com.example.mvvmarchitecture.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.databinding.ActivityLoginBinding
import com.example.mvvmarchitecture.util.hide
import com.example.mvvmarchitecture.util.show
import com.example.mvvmarchitecture.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.viewmodel =viewModel
        viewModel.authListener=this
    }

    override fun onstarted() {
        toast("Login Strated")
        progress_bar.show()
    }

    override fun onsuccess(loginresponse: LiveData<String>) {

        loginresponse.observe(this, Observer {
            progress_bar.hide()
            toast(it)
        })
    }

    override fun onfaliure(message: String) {
        progress_bar.hide()
        toast(message)
    }
}