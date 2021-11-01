package com.yurensan.a04bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.*

/**
 * Created by Administrator on 2018/6/20.
 */
class CustomFragmentDialog : BottomSheetDialogFragment() {
    private val list = ArrayList<String>()

    @Nullable
    override fun onCreateView(
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