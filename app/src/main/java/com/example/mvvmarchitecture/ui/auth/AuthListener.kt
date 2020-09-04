package com.example.mvvmarchitecture.ui.auth

import androidx.lifecycle.LiveData

interface AuthListener {
    fun onstarted()
    fun onsuccess(loginresponse: LiveData<String>)
    fun onfaliure(message : String)

}