package com.example.samplerecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.samplerecyclerview.ui.fragment.SimpleRecyclerFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.frameLayout, SimpleRecyclerFragment.newInstance()).commit()
        }
    }
}
