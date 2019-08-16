package com.example.samplerecyclerview.ui.recycler.customrecycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.samplerecyclerview.R

class CustomRecyclerAdapter(list: List<ItemData>, private val onClickListener: (ItemData) -> Unit) : RecyclerView.Adapter<CustomRecyclerViewHolder>() {

    // Itemリストを動的に変更するためMutableListとして保持しておく
    private val itemList: MutableList<ItemData> = list.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomRecyclerViewHolder {
        // onCreateViewHolderでItemレイアウトを指定してViewHolderを生成する
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_custom_recycler, parent, false)
        return CustomRecyclerViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: CustomRecyclerViewHolder, position: Int) {
        holder.titleTextView.text = itemList[position].title
        holder.contentsTextView.text = itemList[position].contents

        val item = itemList[position]
        holder.cardView.setOnClickListener { onClickListener(item) }
    }

    // 動的にItemを移動するためのメソッド
    fun move(from: Int, to: Int) {
        val item = itemList.removeAt(from)
        itemList.add(to, item)
        notifyItemMoved(from, to)
    }

    // 動的に削除するためのメソッド
    fun removeAt(index: Int): ItemData {
        val item = itemList.removeAt(index)
        notifyItemRemoved(index)
        return item
    }

    // 動的に追加するためのメソッド
    fun add(index: Int, item: ItemData) {
        itemList.add(index, item)
        notifyItemInserted(index)
    }

    // 動的に末尾に追加するためのメソッド
    fun add(item: ItemData) {
        itemList.add(item)
        notifyItemInserted(itemCount)
    }
}