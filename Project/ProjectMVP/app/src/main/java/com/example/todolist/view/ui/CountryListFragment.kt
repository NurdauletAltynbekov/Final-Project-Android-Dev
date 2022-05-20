package com.example.todolist.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.R
import com.example.todolist.contract.CountryListInterface
import com.example.todolist.model.Country
import com.example.todolist.presenter.CountryListPresenter
import com.example.todolist.view.adapter.CountryListAdapter
import kotlinx.android.synthetic.main.fragment_country_list.*
import kotlinx.android.synthetic.main.fragment_country_list.*


class CountryListFragment : Fragment(), CountryListInterface.ViewInterface,
    CountryListInterface.SelectListenInterface {
    private lateinit var presenter: CountryListPresenter
    private lateinit var countryList: ArrayList<Country>
    private lateinit var adapter: CountryListAdapter
    private var neededItem = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_country_list,
            container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = CountryListPresenter(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initView() {
        recycler_view.layoutManager = LinearLayoutManager(context)
        view_details_button.setOnClickListener {
            var todo = countryList[neededItem]
            val bundle = bundleOf("countryId" to countryList)
            findNavController().navigate(R.id.action_todoListFragment_to_todoDetailFragment, bundle)
        }
    }

    override fun getDataFromPresenter(value: ArrayList<Country>) {
        countryList = value
        adapter = CountryListAdapter(countryList!!, this)
        recycler_view.adapter = adapter
    }

    override fun getArrayPosition(position: Int) {
        Toast.makeText(context, "" + countryList[position].country, Toast.LENGTH_SHORT).show()
        neededItem = position
    }
}