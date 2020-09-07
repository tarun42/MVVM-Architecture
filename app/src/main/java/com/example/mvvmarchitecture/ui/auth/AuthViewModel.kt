package com.example.mvvmarchitecture.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmarchitecture.data.reposistries.UserReposotory
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
            val response=UserReposotory().userlogin(email!!,password!!)
            if(response.isSuccessful)
            {
                authListener?.onsuccess(response.body()?.user!!)
            }
            else
            {
                authListener?.onfaliure("error code : $(reponse.code)")
            }
        }

//        val loginresponse =UserReposotory().userlogin(email!!, password!!)
//        authListener?.onsuccess(loginresponse)
    }
}