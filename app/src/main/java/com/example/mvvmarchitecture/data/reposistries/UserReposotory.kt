package com.example.mvvmarchitecture.data.reposistries

import com.example.mvvmarchitecture.data.db.AppDatabase
import com.example.mvvmarchitecture.data.db.entity.User
import com.example.mvvmarchitecture.data.network.MyApi
import com.example.mvvmarchitecture.data.network.Responses.AuthResponse
import com.example.mvvmarchitecture.data.network.SaveApiRequest

class UserReposotory(
    private val api : MyApi,
    private val db : AppDatabase
) : SaveApiRequest(){
    suspend fun userlogin(email:String ,password :String) : AuthResponse
    {

        return apiRequest { api.userlogin(email,password)  }



//        val loginResponse =MutableLiveData<String>()
//        MyApi().userlogin(email,password)
//            .enqueue(object : Callback<ResponseBody>{
//                override fun onResponse(
//                    call: Call<ResponseBody>,
//                    response: Response<ResponseBody>
//                ) {
//                    if(response.isSuccessful)
//                    {
//                        loginResponse.value=response.body()?.string()
//                    }else
//                    {
//                        loginResponse.value= response.errorBody()?.string()
//                    }
//                }
//
//                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                    loginResponse.value=t.message
//                }
//
//            })
//        return loginResponse
    }

    suspend fun userSignup(
        name : String,
        email: String,
        password: String
    ): AuthResponse{
        return apiRequest {
            api.userSignup(name,email,password)
        }
    }
    suspend fun saveUser(user : User)
    {
        db.getUserDao().upsert(user)
    }
    fun getUser() =db.getUserDao().getUser()


}