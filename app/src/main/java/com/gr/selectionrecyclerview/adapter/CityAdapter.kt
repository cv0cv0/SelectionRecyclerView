package com.gr.selectionrecyclerview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.gr.selectionrecyclerview.R
import com.gr.selectionrecyclerview.entity.City

/**
 * Created by gr on 2017/6/17.
 */
class CityAdapter(val context: Context, val datas: ArrayList<City>) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CityViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_city, parent, false)
        return CityViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.textView.text = datas[position].name
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById(R.id.text) as TextView
    }
}