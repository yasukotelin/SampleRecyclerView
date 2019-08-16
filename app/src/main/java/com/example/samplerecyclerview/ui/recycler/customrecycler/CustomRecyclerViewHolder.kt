package com.example.samplerecyclerview.ui.recycler.customrecycler

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.samplerecyclerview.R

// Adapterが適切にキャッシュしながら各ViewにアクセスするためのViewHolder
class CustomRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // RecyclerViewを操作するのに必要なView要素はここで保持しておく必要がある
    val cardView: CardView = itemView.findViewById(R.id.cardView)
    val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    val contentsTextView: TextView = itemView.findViewById(R.id.contentsTextView)
}