package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

import android.os.Bundle
import android.util.Log

import java.util.ArrayList
import android.view.Menu
import android.view.MenuItem


class MainActivity : AppCompatActivity() {

    private lateinit var myViewPager2: ViewPager2
    private lateinit var MyAdapter: MyAdapter
    private val arrayList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewPager2 = findViewById(R.id.view_pager)

        arrayList.add("Item 1")
        arrayList.add("Item 2")
        arrayList.add("Item 3")
        arrayList.add("Item 4")
        arrayList.add("Item 5")

        MyAdapter = MyAdapter(this, arrayList)

        //        myViewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        myViewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        myViewPager2.adapter = MyAdapter

        myViewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                Log.e("Selected_Page", position.toString())
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })
    }

    // create an action bar button
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // handle button activities
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.btn1) {
            // Add new item to ViewPager2
            arrayList.add("New ITEM ADDED")
            MyAdapter.notifyDataSetChanged()
        }
        else if (id == R.id.btn2) {
            // Remove item from ViewPager at some index
            arrayList.removeAt(3)
            MyAdapter.notifyItemRemoved(3)
        }
        else if (id == R.id.btn3) {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}
