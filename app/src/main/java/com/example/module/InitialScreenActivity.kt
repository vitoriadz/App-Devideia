package com.example.module

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class InitialScreenActivity : AppCompatActivity() {
    private lateinit var viewPager: VerticalViewPager
    private lateinit var pagerAdapter: VPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.initial_screen)

        val list: MutableList<Fragment> = ArrayList()
        list.add(PageFragment1())
        list.add(PageFragment2())
        list.add(PageFragment3())

        viewPager = findViewById(R.id.pager)
        pagerAdapter = VPagerAdapter(supportFragmentManager, list)

        viewPager.adapter = pagerAdapter
    }
}
