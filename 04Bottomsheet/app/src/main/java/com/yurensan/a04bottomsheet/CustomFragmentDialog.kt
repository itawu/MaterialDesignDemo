package com.yurensan.a04bottomsheet

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wangshuai.androidui.R
import java.util.*

/**
 * Created by Administrator on 2018/6/20.
 */
class CustomFragmentDialog : BottomSheetDialogFragment() {
    private val list = ArrayList<String>()

    @Nullable
    fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View {
        val view: View =
            inflater.inflate(R.layout.content_bottom_sheet_fragment_dialog, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        for (i in 0..99) {
            list.add("条目$i")
        }
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_item)
        recyclerView.setLayoutManager(LinearLayoutManager(getContext()))
        val adapter = RecyclerViewAdapter(list)
        recyclerView.setAdapter(adapter)
    }
}