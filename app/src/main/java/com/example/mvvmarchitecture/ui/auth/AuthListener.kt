package com.example.mvvmarchitecture.ui.auth

import androidx.lifecycle.LiveData
import com.example.mvvmarchitecture.data.db.User

interface AuthListener {
    fun onstarted()
    fun onsuccess(user : User)
    fun onfaliure(message : String)

}