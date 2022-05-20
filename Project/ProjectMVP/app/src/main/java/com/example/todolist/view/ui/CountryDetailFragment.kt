package com.example.todolist.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todolist.R
import com.example.todolist.contract.CountryDetailInterface
import com.example.todolist.model.Country
import com.example.todolist.presenter.CountryDetailPresenter
import kotlinx.android.synthetic.main.card_layout.*
import kotlinx.android.synthetic.main.fragment_country_detail.*


class CountryDetailFragment : Fragment(), CountryDetailInterface.ViewInterface {
    private lateinit var presenter: CountryDetailPresenter
    private lateinit var country: Country

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_country_detail,
            container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val todoId = arguments?.getInt("todoId", -1)
        presenter = CountryDetailPresenter(this, todoId!!)
    }

    private fun displayTodo(country: Country) {
        country_id.text = country.country
        country_slug.text = country.slug
        country_is02.text = country.is02
    }

    override fun initView() {
//        todo_status.setOnClickListener {
//            presenter.toggleStatus()
//            displayTodo(country)
//        }
    }

    override fun getDataFromPresenter(value: Country) {
        country = value
        displayTodo(country)
    }
}