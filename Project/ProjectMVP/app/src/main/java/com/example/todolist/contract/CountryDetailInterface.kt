package com.example.todolist.contract

import com.example.todolist.model.Country

interface CountryDetailInterface {

    interface ViewInterface {
        fun initView()
        fun getDataFromPresenter(value: Country)
    }

    interface PresenterInterface {
        fun toggleStatus()
        fun getUpdatedData(value: Country)
    }

    interface ModelInterface {
        fun toggleStatus()
        fun getValue()
        fun updateValue()
    }
}