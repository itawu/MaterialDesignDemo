package com.yurensan.snackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener { view ->
            Snackbar.make(view, "Snackbar测试", Snackbar.LENGTH_LONG)
                    .setAction("点击") { Toast.makeText(this, "Toast", Toast.LENGTH_SHORT).show() }
                    .show()
        }
    }
}