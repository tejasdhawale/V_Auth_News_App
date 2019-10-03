package com.tejas.v_authmachinetest.main.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;


import com.tejas.v_authmachinetest.BR;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;


public abstract class DataBindingRecyclerViewAdapter extends RecyclerView.Adapter<DataBindingRecyclerViewHolder> {

    private List<ViewModel> mViewModels;

    public DataBindingRecyclerViewAdapter(List<ViewModel> viewModels) {
        try {
            this.mViewModels = viewModels;
            onViewModelListChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NotNull
    @Override
    public DataBindingRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);

        return new DataBindingRecyclerViewHolder<>(DataBindingUtil.bind(v));
    }

    @Override
    public void onBindViewHolder(DataBindingRecyclerViewHolder holder, int position) {
        holder.getBinding().setVariable(com.tejas.v_authmachinetest.BR.vm, mViewModels.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemViewType(int position) {
        return getViewModelLayoutMap().get(mViewModels.get(position).getClass());
    }

    @Override
    public int getItemCount() {
        return mViewModels == null ? 0 : mViewModels.size();
    }

    public abstract Map<Class, Integer> getViewModelLayoutMap();

    public void onViewModelListChanged() {
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}