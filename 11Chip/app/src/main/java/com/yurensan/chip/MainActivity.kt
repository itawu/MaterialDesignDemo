package com.yurensan.chip

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chipGroup = findViewById<ChipGroup>(R.id.chip_group)
        chipGroup.setOnCheckedChangeListener { chipGroup1: ChipGroup, i: Int ->
            val chip: Chip = chipGroup1.findViewById(i)
            Toast.makeText(this@MainActivity, chip.text, Toast.LENGTH_SHORT).show()
        }

        val chipClose = findViewById<Chip>(R.id.chip_close)
        chipClose.setOnCloseIconClickListener { view: View? -> chipGroup.removeView(view) }
    }
}