package com.example.mvvmarchitecture.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmarchitecture.data.reposistries.UserReposotory

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
//        authListener?.onsuccess(loginresponse)

        val loginresponse =UserReposotory().userlogin(email!!, password!!)
        authListener?.onsuccess(loginresponse)
    }
}