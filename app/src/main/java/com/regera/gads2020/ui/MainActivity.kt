package com.regera.gads2020.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.regera.gads2020.PageAdapter
import com.regera.gads2020.R
import com.regera.gads2020.SubmitActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.home_page_toolbar.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()


        viewPager.adapter =  PageAdapter(this)

//
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            viewPager.setCurrentItem(tab.position, true)

            when(position){
                0 -> tab.text = "Learning Leaders"
                1 -> tab.text = "Skill IQ Leaders"
            }
        }.attach()


        submit_button.setOnClickListener {
            val intent = Intent(this@MainActivity, SubmitActivity::class.java)
            startActivity(intent)
        }



    }

}