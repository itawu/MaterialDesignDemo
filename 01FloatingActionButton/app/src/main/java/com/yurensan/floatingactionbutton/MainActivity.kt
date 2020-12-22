package com.yurensan.floatingactionbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { v: View ->
            Snackbar.make(v, "I am Snackbar", Snackbar.LENGTH_LONG)
                .setAction("retry") {
                    Toast.makeText(this, "click me", Toast.LENGTH_LONG).show()
                }.show()
        }
    }
}