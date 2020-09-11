package com.example.mvvmarchitecture.data.network.Responses

import com.example.mvvmarchitecture.data.db.entity.User

data class AuthResponse (
    val isSuccessfull : Boolean?,
    val message : String?,
    val user : User?
)
{

}