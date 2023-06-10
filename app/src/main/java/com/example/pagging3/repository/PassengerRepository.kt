package com.example.pagging3.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.pagging3.paging.PassengerPagingSource
import com.example.pagging3.retrofit.RetrofitAPI
import javax.inject.Inject

class PassengerRepository @Inject constructor(private val passengerApi: RetrofitAPI) {

    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = { PassengerPagingSource(passengerApi) }
    ).liveData
}