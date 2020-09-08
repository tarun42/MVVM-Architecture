package com.example.mvvmarchitecture.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmarchitecture.data.reposistries.UserReposotory
import com.example.mvvmarchitecture.util.ApiException
import com.example.mvvmarchitecture.util.Coroutines

class AuthViewModel : ViewModel() {
    var email: String? =null
    var password: String?=null

    var authListener :AuthListener? = null
    fun onLoginButtonClick(view : View){
        authListener?.onstarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty())
        {
            authListener?.onfaliure("Invalid Credentials")
            return
        }


        Coroutines.main {
            try {
                val authresponse =UserReposotory().userlogin(email!!,password!!)
//                authListener?.onsuccess(authresponse.user!!)
                authresponse.user?.let {
                    authListener?.onsuccess(it)
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