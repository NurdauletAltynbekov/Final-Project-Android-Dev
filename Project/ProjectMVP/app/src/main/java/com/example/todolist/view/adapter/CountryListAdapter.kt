package com.example.todolist.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.contract.CountryListInterface
import com.example.todolist.model.Country

class CountryListAdapter(
    private var countryList: ArrayList<Country>,
    private var selectListen1: CountryListInterface.SelectListenInterface
) :
    RecyclerView.Adapter<CountryListAdapter.MyViewHolder>() {
    private var selectListen: CountryListInterface.SelectListenInterface? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        initialization(holder, position)

        selectItem(holder, position)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    class MyViewHolder(todoView: View) : RecyclerView.ViewHolder(todoView) {
        var countryId: TextView = todoView.findViewById(R.id.country_id)
        var slug: TextView = todoView.findViewById(R.id.country_slug)
        var is02: TextView = todoView.findViewById(R.id.country_is02)
    }

    private fun initialization(holder: MyViewHolder, position: Int) {
        countryList[position].apply {
            holder.countryId.text = this.country.toString()
            holder.slug.text = this.slug.toString()
            holder.is02.text = this.is02.toString()
        }
    }

    private fun selectItem(holder: MyViewHolder, position: Int) {
        selectListen = selectListen1
        holder.itemView.setOnClickListener {
            selectListen?.getArrayPosition(position)
        }
    }
}

