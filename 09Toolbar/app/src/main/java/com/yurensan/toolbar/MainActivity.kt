package com.yurensan.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitle(R.string.title)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "主页", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_share -> {
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_settings -> {
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_more -> {
                Toast.makeText(this, "更多", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return false
    }
}