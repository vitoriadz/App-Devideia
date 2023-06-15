package com.example.module

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: VerticalViewPager
    private lateinit var pagerAdapter: VPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list: MutableList<Fragment> = ArrayList()
        list.add(PageFragment())
        list.add(PageFragment2())
        list.add(PageFragment3())

        viewPager = findViewById(R.id.pager)
        pagerAdapter = VPagerAdapter(supportFragmentManager, list)

        viewPager.setAdapter(pagerAdapter)
    }
}
