package com.example.pagging3.retrofit

import com.example.pagging3.model.PassengerModel
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {

    @GET("/passenger")
    suspend fun getPassenger(@Query("page") page: Int, @Query("size") size: Int): PassengerModel
}