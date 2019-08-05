package com.example.samplerecyclerview.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.samplerecyclerview.R
import com.example.samplerecyclerview.ui.recycler.simplerecycler.Adapter
import com.example.samplerecyclerview.ui.recycler.simplerecycler.ItemData
import kotlinx.android.synthetic.main.fragment_simple_recycler.*

class SimpleRecyclerFragment : Fragment() {

    companion object {
        fun newInstance() = SimpleRecyclerFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple_recycler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
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
        recyclerView.adapter = Adapter(list)
    }
}
