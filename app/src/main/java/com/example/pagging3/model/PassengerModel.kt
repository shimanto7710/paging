package com.example.pagging3.model


import com.google.gson.annotations.SerializedName

data class PassengerModel(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("totalPages")
    val totalPages: Int,
    @SerializedName("totalPassengers")
    val totalPassengers: Int
) {
    data class Data(
        @SerializedName("airline")
        val airline: List<Airline>,
        @SerializedName("_id")
        val id: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("trips")
        val trips: Int,
        @SerializedName("__v")
        val v: Int
    ) {
        data class Airline(
            @SerializedName("country")
            val country: String,
            @SerializedName("established")
            val established: String,
            @SerializedName("head_quaters")
            val headQuaters: String,
            @SerializedName("_id")
            val _id: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("logo")
            val logo: String,
            @SerializedName("name")
            val name: String,
            @SerializedName("slogan")
            val slogan: String,
            @SerializedName("__v")
            val v: Int,
            @SerializedName("website")
            val website: String
        )
    }
}