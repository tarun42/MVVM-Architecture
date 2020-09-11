package com.example.mvvmarchitecture.data.network.Responses

import com.example.mvvmarchitecture.data.db.entity.Quote

class QuotesResponse(
    val isSuccessful : Boolean,
    val quotes : List<Quote>
) {

}