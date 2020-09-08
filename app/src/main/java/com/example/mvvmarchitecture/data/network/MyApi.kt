package com.example.mvvmarchitecture.data.network

import com.example.mvvmarchitecture.data.network.Responses.AuthResponse
import com.google.android.material.shape.ShapeAppearanceModel.builder
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {
    @FormUrlEncoded
    @POST("login")
    suspend fun userlogin(
        @Field("email") email : String,
        @Field("Password") password :String
    ) : Response<AuthResponse>

    companion object{
        operator fun invoke() : MyApi{
            return Retrofit.Builder()
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }

    }

}