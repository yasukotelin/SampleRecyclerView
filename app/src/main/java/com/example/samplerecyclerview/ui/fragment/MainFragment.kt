package com.example.samplerecyclerview.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.samplerecyclerview.CustomRecyclerActivity

import com.example.samplerecyclerview.R
import com.example.samplerecyclerview.SimpleRecyclerActivity
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        simpleRecyclerCardView.setOnClickListener {
            startActivity(Intent(context, SimpleRecyclerActivity::class.java))
        }
        customRecyclerCardView.setOnClickListener {
            startActivity(Intent(context, CustomRecyclerActivity::class.java))
        }
    }
}
