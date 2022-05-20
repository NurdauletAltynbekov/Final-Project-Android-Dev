package com.example.todolist.presenter

import com.example.todolist.contract.CountryListInterface
import com.example.todolist.model.Country
import com.example.todolist.model.CountryListModel

class CountryListPresenter(_view: CountryListInterface.ViewInterface) : CountryListInterface.PresenterInterface {
    private var view: CountryListInterface.ViewInterface = _view
    private var model: CountryListModel = CountryListModel()
    private var countryList: ArrayList<Country>? = null

    init {
        view.initView()
        model.initData(this)
    }

    override fun addValue() {
//        model.addValue()
    }

    override fun removeData() {
//        model.removeData()
    }

    override fun removeDateFromList(position: Int) {
//        model.removeDataFromList(position)
    }

    override fun getUpdatedData(value: ArrayList<Country>) {
        countryList = value
        view.getDataFromPresenter(countryList!!)
    }
}