package com.example.todolist.model

import android.util.Log
import com.example.todolist.api.CountryClient
import com.example.todolist.contract.CountryDetailInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryDetailModel(var countryId: Int) : CountryDetailInterface.ModelInterface {
    var country: Country? = null

    var presenter: CountryDetailInterface.PresenterInterface? = null

    override fun getValue() {
        CountryClient.getTodoById(countryId).enqueue(object : Callback<Country> {
            override fun onResponse(
                call: Call<Country>,
                response: Response<Country>
            ) {
                Log.e(Country::class.java.simpleName, response.toString())
                country = response.body()
                updateValue()
            }

            override fun onFailure(call: Call<Country>, t: Throwable) {
                Log.e(Country::class.java.simpleName, "error on get value", t)
            }
        })
    }

    override fun toggleStatus() {
//        country!!.completed = !country!!.completed!!
//        updateValue()
    }

    override fun updateValue() {
        presenter!!.getUpdatedData(country!!)
    }

    fun initData(presenter: CountryDetailInterface.PresenterInterface) {
        this.presenter = presenter
        getValue()
    }
}
