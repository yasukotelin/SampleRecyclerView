package com.example.samplerecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.samplerecyclerview.ui.fragment.CustomRecyclerFragment

class CustomRecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_recycler)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frameLayout, CustomRecyclerFragment.newInstance())
                .commit()
        }
    }
}
