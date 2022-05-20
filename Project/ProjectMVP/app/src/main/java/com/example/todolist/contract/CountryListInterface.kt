package com.example.todolist.contract

import com.example.todolist.model.Country

interface CountryListInterface {

    interface ViewInterface {
        fun initView()
        fun getDataFromPresenter(value: ArrayList<Country>)
    }

//    interface PresenterInterface {
//        fun addValue()
//        fun removeData()
//        fun removeDateFromList(position: Int)
//        fun getUpdatedData(value: ArrayList<Country>)
//    }

    interface ModelInterface {
        fun addValue()
        fun getValue()
        fun removeData()
        fun removeDataFromList(position: Int)
        fun updateList()
    }

    interface SelectListenInterface {
        fun getArrayPosition(position: Int)
    }
}