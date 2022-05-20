package com.example.todolist.model

import android.util.Log
import com.example.todolist.api.CountryClient
import com.example.todolist.contract.CountryListInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryListModel : CountryListInterface.ModelInterface {
    var countryList: ArrayList<Country>? = null

    var presenter: CountryListInterface.PresenterInterface? = null

    override fun addValue() {
        // todoList.add()
    }

    override fun getValue() {
        CountryClient.getTodos().enqueue(object : Callback<ArrayList<Country>> {
            override fun onResponse(
                call: Call<ArrayList<Country>>,
                response: Response<ArrayList<Country>>
            ) {
                Log.e(Country::class.java.simpleName, response.toString())
                countryList = response.body()
                updateList()
            }

            override fun onFailure(call: Call<ArrayList<Country>>, t: Throwable) {
                Log.e(Country::class.java.simpleName, "error on get value", t)
            }
        })
    }

    override fun removeData() {
        countryList!!.clear()
        updateList()
    }

    override fun removeDataFromList(position: Int) {
        countryList!!.removeAt(position)
        updateList()
    }

    override fun updateList() {
        presenter!!.getUpdatedData(countryList!!)
    }

    fun initData(presenter: CountryListInterface.PresenterInterface) {
        this.presenter = presenter
        getValue()
    }
}