package com.example.todolist.api

import com.example.todolist.model.Country
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("countries/")
    fun getCountries(): Call<ArrayList<Country>>

    @GET("country/{slug}/")
    fun getCountryById(@Path("countryId") todoId: Int): Call<Country>
}