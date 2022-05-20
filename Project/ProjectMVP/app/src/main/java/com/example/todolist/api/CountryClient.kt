package com.example.todolist.api

import com.example.todolist.model.Country
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CountryClient {
    private var BASE_URL: String = "https://api.covid19api.com/"
    private var apiService: ApiService

    init {
        val retrofit:Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        apiService = retrofit.create(ApiService::class.java)
    }

    fun getCountries(): Call<ArrayList<Country>> {
        return apiService.getCountries()
    }

    fun getCountryById(countryId: Int): Call<Country> {
        return apiService.getCountryById(countryId)
    }
}