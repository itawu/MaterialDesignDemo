package com.yurensan.a04bottomsheet

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var btnExpand: AppCompatButton? = null
    private var btnCollapsed: AppCompatButton? = null
    private var btnHide: AppCompatButton? = null
    private var btnBottomsheetDialog: AppCompatButton? = null
    private var btnBottomsheetDialogFragment: AppCompatButton? = null
    private var llContentBottomSheet: LinearLayout? = null

    private var bottomSheetBehavior: BottomSheetBehavior<*>? = null
    private var dialog: BottomSheetDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        btnExpand = findViewById<View>(R.id.btn_expand) as AppCompatButton
        btnCollapsed = findViewById<View>(R.id.btn_collapsed) as AppCompatButton
        btnHide = findViewById<View>(R.id.btn_hide) as AppCompatButton
        btnBottomsheetDialog =
            findViewById<View>(R.id.btn_bottomsheet_dialog) as AppCompatButton
        btnBottomsheetDialogFragment =
            findViewById<View>(R.id.btn_bottomsheet_dialog_fragment) as AppCompatButton
        llContentBottomSheet =
            findViewById<View>(R.id.ll_content_bottom_sheet) as LinearLayout
        btnExpand!!.setOnClickListener(this)
        btnCollapsed!!.setOnClickListener(this)
        btnHide!!.setOnClickListener(this)
        btnBottomsheetDialogFragment!!.setOnClickListener(this)
        btnBottomsheetDialog!!.setOnClickListener(this)
        bottomSheetBehavior = BottomSheetBehavior.from<LinearLayout?>(llContentBottomSheet!!)
        (bottomSheetBehavior as BottomSheetBehavior<*>).setBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> Log.e(
                        "Bottom Sheet Behaviour",
                        "STATE_COLLAPSED"
                    )
                    BottomSheetBehavior.STATE_DRAGGING -> Log.e(
                        "Bottom Sheet Behaviour",
                        "STATE_DRAGGING"
                    )
                    BottomSheetBehavior.STATE_EXPANDED -> Log.e(
                        "Bottom Sheet Behaviour",
                        "STATE_EXPANDED"
                    )
                    BottomSheetBehavior.STATE_HIDDEN -> Log.e(
                        "Bottom Sheet Behaviour",
                        "STATE_HIDDEN"
                    )
                    BottomSheetBehavior.STATE_SETTLING -> Log.e(
                        "Bottom Sheet Behaviour",
                        "STATE_SETTLING"
                    )
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_expand -> bottomSheetBehavior!!.setState(BottomSheetBehavior.STATE_EXPANDED)
            R.id.btn_collapsed -> bottomSheetBehavior!!.setState(BottomSheetBehavior.STATE_COLLAPSED)
            R.id.btn_hide -> bottomSheetBehavior!!.setState(BottomSheetBehavior.STATE_HIDDEN)
            R.id.btn_bottomsheet_dialog -> {
                if (dialog == null) {
                    dialog = BottomSheetDialog(this)
                }
                dialog!!.setCancelable(false)
                dialog!!.setCanceledOnTouchOutside(true)
                val view: View = LayoutInflater.from(this@MainActivity)
                    .inflate(R.layout.content_bottom_sheet_dialog, null)
                val tvWechat: TextView = view.findViewById(R.id.tv_wechat)
                tvWechat.setOnClickListener {
                    Toast.makeText(this@MainActivity, "微信", Toast.LENGTH_SHORT).show()
                    dialog!!.dismiss()
                }
                dialog!!.setContentView(view)
                dialog!!.show()
            }
            R.id.btn_bottomsheet_dialog_fragment -> {
                val fragmentDialog = CustomFragmentDialog()
                fragmentDialog.show(getSupportFragmentManager(),"CustomFragmentDialog");
                // val fullSheetDialogFragment = FullSheetDialogFragment()
                // fullSheetDialogFragment.show(supportFragmentManager, "FullSheetDialogFragment")
            }
        }
    }
}