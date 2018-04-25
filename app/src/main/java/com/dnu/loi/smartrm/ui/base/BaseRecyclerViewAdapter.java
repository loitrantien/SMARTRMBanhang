package com.dnu.loi.smartrm.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 29/03/2018.
 */

public abstract class BaseRecyclerViewAdapter<Item, ViewHolder extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<ViewHolder> {

    private List<Item> mMainList;

    protected int currentItemPosition;

    protected OnItemClickedListener<Item> mListener = (view, item) -> {
    };

    public BaseRecyclerViewAdapter(List<Item> mMainList) {
        this.mMainList = mMainList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(getLayoutResourceItem(), parent, false);

        return getViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        onBind(holder, position);
    }

    @Override
    public int getItemCount() {
        return getSize();
    }

    protected abstract int getLayoutResourceItem();

    protected abstract int getSize();

    public int getCurrentItemPosition() {
        return currentItemPosition;
    }

    public void setCurrentItemPosition(int currentItemPosition) {
        this.currentItemPosition = currentItemPosition;
    }

    public void refresh(List<Item> items) {
        mMainList = items;
        notifyDataSetChanged();
    }

    public void add(Item item) {
        mMainList.add(item);
        notifyDataSetChanged();
    }

    public void remove(Item item) {
        mMainList.remove(item);
        notifyDataSetChanged();
    }

    public void clear() {
        mMainList.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Item> items) {
        mMainList.addAll(items);
        notifyDataSetChanged();
    }

    protected List<Item> getCollection() {
        return mMainList;
    }

    public void setOnItemClickedListener(OnItemClickedListener<Item> mListener) {
        this.mListener = mListener;
    }

    protected abstract ViewHolder getViewHolder(View view);

    protected abstract void onBind(ViewHolder holder, int position);

    public Item getItemSelected() {
        return mMainList.get(currentItemPosition);
    }

    public interface OnItemClickedListener<Item> {
        void onClick(View view, Item item);
    }

}
