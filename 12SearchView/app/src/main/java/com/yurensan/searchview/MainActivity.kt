package com.yurensan.searchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    var searchTv: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        searchTv = findViewById(R.id.searchTv)
        toolbar.contentInsetStartWithNavigation = 0
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        //引用menu文件
        menuInflater.inflate(R.menu.menu_search, menu)

        //找到SearchView并配置相关参数
        val searchItem = menu.findItem(R.id.action_search)
        val mSearchView = searchItem.actionView as SearchView

        //搜索图标是否显示在搜索框内
        mSearchView.setIconifiedByDefault(true)
        //设置搜索框展开时是否显示提交按钮，可不显示
        mSearchView.isSubmitButtonEnabled = true
        //让键盘的回车键设置成搜索
        mSearchView.imeOptions = EditorInfo.IME_ACTION_SEARCH
        //搜索框是否展开，false表示展开
        mSearchView.isIconified = true
        //获取焦点
        mSearchView.isFocusable = true
        mSearchView.requestFocusFromTouch()
        //设置提示词
        mSearchView.queryHint = "请输入关键字"
        //设置输入框文字颜色
        val editText = mSearchView.findViewById<EditText>(R.id.search_src_text)
        editText.setHintTextColor(ContextCompat.getColor(this, R.color.purple_200))
        editText.setTextColor(ContextCompat.getColor(this, R.color.white))

        // 设置搜索文本监听
        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            // 当内容不为空，点击搜索按钮时触发该方法
            override fun onQueryTextSubmit(query: String): Boolean {
                Snackbar.make(mSearchView, "搜索内容===$query", Snackbar.LENGTH_SHORT).show()
                searchTv?.visibility = View.VISIBLE

                //清除焦点，收软键盘
                //mSearchView.clearFocus();
                return false
            }

            // 当搜索内容改变时触发该方法
            override fun onQueryTextChange(newText: String): Boolean {
                //do something
                //当没有输入任何内容的时候清除结果，看实际需求
                if (TextUtils.isEmpty(newText))
                    searchTv?.visibility = View.INVISIBLE
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}