package com.yurensan.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = SimpleFragmentPagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)!!.select()
    }

    private inner class SimpleFragmentPagerAdapter constructor(fm: FragmentManager):
            FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        private val titles = arrayOf("Tab1", "Tab3", "Tab3")
        private val fragments = arrayOf(Fragment1(), Fragment1(), Fragment1())

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }
    }
}