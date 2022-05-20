package com.example.todolist.presenter

import com.example.todolist.contract.CountryDetailInterface
import com.example.todolist.model.Country
import com.example.todolist.model.CountryDetailModel

class CountryDetailPresenter(_view: CountryDetailInterface.ViewInterface, countryId: Int) : CountryDetailInterface.PresenterInterface {
    private var view: CountryDetailInterface.ViewInterface = _view
    private var model: CountryDetailModel = CountryDetailModel(countryId)
    private var country: Country? = null

    init {
        view.initView()
        model.initData(this)
    }

    override fun toggleStatus() {
        model.toggleStatus()
    }

    override fun getUpdatedData(country: Country) {
        this.country = country
        view.getDataFromPresenter(country)
    }
}