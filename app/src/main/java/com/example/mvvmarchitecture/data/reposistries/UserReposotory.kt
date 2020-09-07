package com.example.mvvmarchitecture.data.reposistries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmarchitecture.data.network.MyApi
import com.example.mvvmarchitecture.data.network.Responses.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserReposotory {
    suspend fun userlogin(email:String ,password :String) : Response<AuthResponse>
    {

        return MyApi().userlogin(email,password)


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
}