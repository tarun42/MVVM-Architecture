package com.example.mvvmarchitecture.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmarchitecture.data.reposistries.UserReposotory
import com.example.mvvmarchitecture.util.ApiException
import com.example.mvvmarchitecture.util.Coroutines

class AuthViewModel(
    private val repository : UserReposotory
) : ViewModel() {
    var email: String? =null
    var password: String?=null

    var authListener :AuthListener? = null
    fun getLoggedInUser()=repository.getUser()

    fun onLoginButtonClick(view : View){

        if(email.isNullOrEmpty() || password.isNullOrEmpty())
        {
            authListener?.onfaliure("Invalid Credentials")
            return
        }


        Coroutines.main {
            try {
                val authresponse =repository.userlogin(email!!,password!!)
                authresponse.user?.let {
                    authListener?.onsuccess(it)
                    repository.saveUser(it)
                    return@main
                }
                authListener?.onfaliure(authresponse.message!!)

            }catch (e : ApiException)

            {
                authListener?.onfaliure(e.message!!)
            }


        }

//        val loginresponse =UserReposotory().userlogin(email!!, password!!)
//        authListener?.onsuccess(loginresponse)
    }
}