package com.example.myapplication

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2

import java.util.ArrayList

class FragmentActivity : AppCompatActivity() {
    private lateinit var myViewPager2: ViewPager2
    private lateinit var myAdapter: ViewPagerFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewPager2 = findViewById(R.id.view_pager)

        myAdapter = ViewPagerFragmentAdapter(supportFragmentManager, lifecycle)

        myAdapter.addFragment(BlankFragment())
        myAdapter.addFragment(BlankFragment())
        myAdapter.addFragment(BlankFragment())

        // set Orientation in your ViewPager2
        myViewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        myViewPager2.adapter = myAdapter
    }
}