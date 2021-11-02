package com.yurensan.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

// https://stackoverflow.com/questions/24471109/recyclerview-onclick/26196831#26196831
class RecyclerViewAdapter(private val data: Array<String>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(data[position], position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var textView: TextView? = null
        private var pos = -1

        //用于显示数据
        fun setData(data: String?, position: Int) {
            textView!!.text = data
            this.pos = position
        }

        init {
            textView = itemView.findViewById(R.id.tv)
            itemView.setOnClickListener { Toast.makeText(itemView.context, data[pos] + " is clicked!", Toast.LENGTH_SHORT).show() }
        }
    }
}