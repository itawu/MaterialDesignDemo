package com.yurensan.bottomsheet

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openBottomSheetDialogFragment(view: View?) {
        val dialogFragment = MyBottomSheetDialogFragment()
        dialogFragment.show(supportFragmentManager, "MyBottomSheetDialogFragment")
    }
}