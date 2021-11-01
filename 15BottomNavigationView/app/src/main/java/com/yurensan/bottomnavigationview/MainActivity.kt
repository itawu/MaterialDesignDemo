package com.yurensan.bottomnavigationview

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val FRAGMENT_PAGE1 = 0
    private val FRAGMENT_PAGE2 = 1
    private val FRAGMENT_PAGE3 = 2
    private val FRAGMENT_PAGE4 = 3
    private val FRAGMENT_PAGE5 = 4

    private var mFragmentPage1: Fragment? = null
    private var mFragmentPage2: Fragment? = null
    private var mFragmentPage3: Fragment? = null
    private var mFragmentPage4: Fragment? = null
    private var mFragmentPage5: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.page_1 -> {
                    Toast.makeText(this@MainActivity, "page_1 click", Toast.LENGTH_SHORT).show()
                    showFragment(FRAGMENT_PAGE1)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_2 -> {
                    Toast.makeText(this@MainActivity, "page_2 click", Toast.LENGTH_SHORT).show()
                    showFragment(FRAGMENT_PAGE2)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_3 -> {
                    Toast.makeText(this@MainActivity, "page_3 click", Toast.LENGTH_SHORT).show()
                    showFragment(FRAGMENT_PAGE3)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_4 -> {
                    Toast.makeText(this@MainActivity, "page_4 click", Toast.LENGTH_SHORT).show()
                    showFragment(FRAGMENT_PAGE4)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_5 -> {
                    Toast.makeText(this@MainActivity, "page_5 click", Toast.LENGTH_SHORT).show()
                    showFragment(FRAGMENT_PAGE5)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
        //默认显示HomeFragment
        showFragment(FRAGMENT_PAGE1)
        val menuItemId = bottomNavigationView.menu.getItem(2).itemId
        val badge = bottomNavigationView.getOrCreateBadge(menuItemId)
        badge.isVisible = true
        //badge.number = 99
    }

    private fun showFragment(index: Int) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        hideFragment(transaction)
        when (index) {
            FRAGMENT_PAGE1 -> if (mFragmentPage1 == null) {
                mFragmentPage1 = Page1Fragment()
                transaction.add(R.id.content, mFragmentPage1!!)
            } else {
                transaction.show(mFragmentPage1!!)
            }
            FRAGMENT_PAGE2 -> if (mFragmentPage2 == null) {
                mFragmentPage2 = Page2Fragment()
                transaction.add(R.id.content, mFragmentPage2!!)
            } else {
                transaction.show(mFragmentPage2!!)
            }
            FRAGMENT_PAGE3 -> if (mFragmentPage3 == null) {
                mFragmentPage3 = Page3Fragment()
                transaction.add(R.id.content, mFragmentPage3!!)
            } else {
                transaction.show(mFragmentPage3!!)
            }
            FRAGMENT_PAGE4 -> if (mFragmentPage4 == null) {
                mFragmentPage4 = Page4Fragment()
                transaction.add(R.id.content, mFragmentPage4!!)
            } else {
                transaction.show(mFragmentPage4!!)
            }
            FRAGMENT_PAGE5 -> if (mFragmentPage5 == null) {
                mFragmentPage5 = Page5Fragment()
                transaction.add(R.id.content, mFragmentPage5!!)
            } else {
                transaction.show(mFragmentPage5!!)
            }
        }
        transaction.commit()
    }

    private fun hideFragment(transaction: FragmentTransaction) {
        if (mFragmentPage1 != null) {
            transaction.hide(mFragmentPage1!!)
        }
        if (mFragmentPage2 != null) {
            transaction.hide(mFragmentPage2!!)
        }
        if (mFragmentPage3 != null) {
            transaction.hide(mFragmentPage3!!)
        }
        if (mFragmentPage4 != null) {
            transaction.hide(mFragmentPage4!!)
        }
        if (mFragmentPage5 != null) {
            transaction.hide(mFragmentPage5!!)
        }
    }
}