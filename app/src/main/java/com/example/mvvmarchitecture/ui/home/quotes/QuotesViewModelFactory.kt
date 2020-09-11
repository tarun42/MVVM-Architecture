package com.example.mvvmarchitecture.ui.home.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmarchitecture.data.reposistries.QuoteRepository
import com.example.mvvmarchitecture.data.reposistries.UserReposotory

@Suppress("UNCHECKED_CAST")
class QuotesViewModelFactory(
    private val repository : QuoteRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModelFactory(repository) as T
    }
}