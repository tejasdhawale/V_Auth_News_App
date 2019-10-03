package com.tejas.v_authmachinetest.main.dashboard

import androidx.lifecycle.ViewModel
import com.tejas.v_authmachinetest.R
import com.tejas.v_authmachinetest.main.adapter.DataBindingRecyclerViewAdapter
import com.tejas.v_authmachinetest.main.adapter.DataBindingRecyclerViewHolder

class ArticleListAdapter(vmList: List<ViewModel>) : DataBindingRecyclerViewAdapter(vmList) {

    private var viewModelMap: MutableMap<Class<*>, Int> = HashMap()

    init {
        viewModelMap[RowArticleViewModel::class.java] = R.layout.item_row
    }

    override fun getViewModelLayoutMap(): Map<Class<*>, Int> {
        return viewModelMap
    }

    override fun onBindViewHolder(holder: DataBindingRecyclerViewHolder<*>, position: Int) {
        super.onBindViewHolder(holder, position)
    }


}