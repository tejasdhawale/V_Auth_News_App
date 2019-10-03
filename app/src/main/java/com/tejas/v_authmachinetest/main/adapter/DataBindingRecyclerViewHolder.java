package com.tejas.v_authmachinetest.main.adapter;


import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class DataBindingRecyclerViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private T mBinding;

    public DataBindingRecyclerViewHolder(T binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public T getBinding() {
        return mBinding;
    }
}