package com.example.mvvmarchitecture.data.network

import com.example.mvvmarchitecture.util.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.StringBuilder

abstract class SaveApiRequest {

    suspend fun<T : Any> apiRequest(call : suspend () -> Response<T>) : T{

        val response=call.invoke()
        if(response.isSuccessful){
            return response.body()!!
        }else
        {
            val error =response.errorBody()?.string()
            val message =StringBuilder()
            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                }catch (e : JSONException){
                    message.append("\n")
                }
            }
            message.append("Eror Code ${response.code()}")
            throw ApiException(message.toString())
        }
    }
}