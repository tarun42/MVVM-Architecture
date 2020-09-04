package com.example.mvvmarchitecture.ui.auth

interface AuthListener {
    fun onstarted()
    fun onsuccess()
    fun onfaliure(message : String)

}