package com.yurensan.navigationview

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private var mDrawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        mDrawerToggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close)
        mDrawerToggle!!.syncState()
        drawerLayout.addDrawerListener(mDrawerToggle!!)

        val navigationView = findViewById<View>(R.id.navigation_view) as NavigationView
        navigationView.getHeaderView(0).setOnClickListener {
            drawerLayout.closeDrawer(navigationView)
            Toast.makeText(this@MainActivity, "Header View is clicked!", Toast.LENGTH_SHORT).show()
        }
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> Toast.makeText(this@MainActivity, "Home is clicked!", Toast.LENGTH_SHORT).show()
                R.id.menu_settings -> Toast.makeText(this@MainActivity, "Settings is clicked!", Toast.LENGTH_SHORT).show()
                R.id.menu_share -> Toast.makeText(this@MainActivity, "Share is clicked!", Toast.LENGTH_SHORT).show()
                R.id.menu_about -> Toast.makeText(this@MainActivity, "About is clicked!", Toast.LENGTH_SHORT).show()
            }
            drawerLayout.closeDrawer(navigationView)
            false
        }
    }
}