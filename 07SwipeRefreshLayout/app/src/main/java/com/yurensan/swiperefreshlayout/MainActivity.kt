package com.yurensan.swiperefreshlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val srl = findViewById<SwipeRefreshLayout>(R.id.srl)
        val tv = findViewById<TextView>(R.id.tv)
        srl.setColorSchemeColors(ContextCompat.getColor(this, android.R.color.holo_red_dark),
                ContextCompat.getColor(this, android.R.color.holo_orange_dark),
                ContextCompat.getColor(this, android.R.color.holo_blue_dark))
        srl.setOnRefreshListener {
            srl.postDelayed({
                srl.isRefreshing = false
                tv.text = "刷新成功"
            }, 3000)
        }
    }
}