package com.example.mvvmarchitecture.ui.home.quotes

import androidx.lifecycle.ViewModel
import com.example.mvvmarchitecture.data.reposistries.QuoteRepository
import com.example.mvvmarchitecture.util.lazyDeferred

class QuotesViewModel(
    repository: QuoteRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }

}