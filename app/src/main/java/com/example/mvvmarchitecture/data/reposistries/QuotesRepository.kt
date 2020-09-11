package com.example.mvvmarchitecture.data.reposistries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmarchitecture.data.db.AppDatabase

import com.example.mvvmarchitecture.data.db.entity.Quote
import com.example.mvvmarchitecture.data.network.MyApi
import com.example.mvvmarchitecture.data.network.SaveApiRequest
import com.example.mvvmarchitecture.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class QuoteRepository(
    private val api : MyApi,
    private val db : AppDatabase
): SaveApiRequest(){
    private val quotes = MutableLiveData<List<Quote>>()

    init{
        quotes.observeForever{
            saveQuotres(it)
        }
    }
    private suspend fun fetchQuotes(){
        if(isFetchNeeded())
        {
            val response =apiRequest { api.getQuotes() }
            quotes.postValue(response.quotes)
        }
    }

    suspend fun getQuotes() : LiveData<List<Quote>>{
        return withContext(Dispatchers.IO){
            fetchQuotes()
            db.getQuoteDao().getQuotes()
        }
    }
    private fun isFetchNeeded() : Boolean{
        return true
    }
    private fun saveQuotres(quotes : List<Quote>)
    {
        Coroutines.io {
            db.getQuoteDao().saveAllQuotes(quotes)

        }
    }

}