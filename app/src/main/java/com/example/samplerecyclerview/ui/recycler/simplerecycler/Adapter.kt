package com.example.samplerecyclerview.ui.recycler.simplerecycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.samplerecyclerview.R

class Adapter(private val list: List<ItemData>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // onCreateViewHolderでItemレイアウトを指定してViewHolderを生成する
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_simple_recycler, parent, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView.text = list[position].title
        holder.contentsTextView.text = list[position].contents
    }
}