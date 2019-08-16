package com.example.samplerecyclerview.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.samplerecyclerview.R
import com.example.samplerecyclerview.ui.recycler.customrecycler.CustomRecyclerAdapter
import com.example.samplerecyclerview.ui.recycler.customrecycler.ItemData
import kotlinx.android.synthetic.main.fragment_custom_recycler.*

class CustomRecyclerFragment : Fragment() {

    companion object {
        fun newInstance() = CustomRecyclerFragment()
    }

    private val customRecyclerAdapter: CustomRecyclerAdapter?
        get() {
            if (recyclerView.adapter == null) return null
            return recyclerView.adapter as CustomRecyclerAdapter
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom_recycler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        addButton.setOnClickListener { onAddButton() }
    }

     private fun initRecyclerView() {
        val list = listOf(
            ItemData(title = "Card1", contents = "card1 contents!"),
            ItemData(title = "Card2", contents = "card2 contents!"),
            ItemData(title = "Card3", contents = "card3 contents!"),
            ItemData(title = "Card4", contents = "card4 contents!"),
            ItemData(title = "Card5", contents = "card5 contents!"),
            ItemData(title = "Card6", contents = "card6 contents!"),
            ItemData(title = "Card7", contents = "card7 contents!"),
            ItemData(title = "Card8", contents = "card8 contents!"),
            ItemData(title = "Card9", contents = "card9 contents!"),
            ItemData(title = "Card10", contents = "card10 contents!"),
            ItemData(title = "Card11", contents = "card11 contents!"),
            ItemData(title = "Card12", contents = "card12 contents!")
        )
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CustomRecyclerAdapter(list, ::onClickCardViewListener)

         itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun onClickCardViewListener(itemData: ItemData) {
        Toast.makeText(context, "Clicked ${itemData.title}", Toast.LENGTH_SHORT).show()
    }

    private fun onAddButton() {
        customRecyclerAdapter?.add(ItemData(title = "NewCard", contents = "NewCard contents!"))
    }

    // ItemTouchHelperでドラッグ移動とスワイプの定義をする
    // SimpleCallbackの第一引数にはドラッグ可能な方向を指定する。
    // 第二引数にはスワイプ可能な方向を指定する
    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, ItemTouchHelper.LEFT) {

        override fun onMove(recyclerView: RecyclerView, fromViewHolder: RecyclerView.ViewHolder, toViewHolder: RecyclerView.ViewHolder): Boolean {
            val fromPosition = fromViewHolder.adapterPosition
            val toPosition = toViewHolder.adapterPosition

            // Move対象の入れ替え処理
            customRecyclerAdapter?.move(fromPosition, toPosition)

            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            // directionはスワイプ方向判定に使える
            when (direction) {
                ItemTouchHelper.LEFT -> Toast.makeText(context, "Swiped LEFT!", Toast.LENGTH_SHORT).show()
            }

            // スワイプ対象の削除処理
            val position = viewHolder.adapterPosition
            customRecyclerAdapter?.removeAt(position)
        }
    })
}
