package com.example.mvvmarchitecture.data.network

import android.content.Context
import android.net.ConnectivityManager
import com.example.mvvmarchitecture.util.NoInternetExceptiom
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor(
    context : Context
) : Interceptor {
    private val applicationContext =context.applicationContext
    override fun intercept(chain: Interceptor.Chain): Response {
        if(!isInternetAvailable())
        {
            throw NoInternetExceptiom("No internet connection")
        }
        return chain.proceed(chain.request())

    }
    private fun isInternetAvailable() : Boolean{
        val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.activeNetwork.also {
            return it !=null
        }
    }
}