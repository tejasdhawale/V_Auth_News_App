package com.tejas.v_authmachinetest.main.utils;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tejas.v_authmachinetest.main.adapter.DataBindingRecyclerViewAdapter;


public class RecyclerViewBindingUtils {

    public final static String ADAPTER = "recyclerViewAdapter";
    public final static String ORIENTATION = "orientation";
    public final static String DIVIDER = "divider";
    public static final String SET_TOUCH_LISTENER = "touchListener";
    public final static String ENDLESS_SCROLL_LISTENER = "endlessScrollListener";

//    @BindingAdapter({ADAPTER})
//    public static void bindRecyclerViewAdapter(RecyclerView view, RecyclerView.Adapter adapter) {
//        view.setAdapter(adapter);
//    }



    @BindingAdapter({ADAPTER})
    public static void bindRecyclerAdapter(RecyclerView recyclerView, DataBindingRecyclerViewAdapter recyclerViewAdapter) {
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
    }


    @BindingAdapter({SET_TOUCH_LISTENER})
    public static void bindRecyclerTouchListener(RecyclerView recyclerView, RecyclerView.OnItemTouchListener itemTouchListener) {
        recyclerView.addOnItemTouchListener(itemTouchListener);
    }


}
