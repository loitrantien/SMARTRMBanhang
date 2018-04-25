package com.dnu.loi.smartrm.ui.order;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.OrderDetail;
import com.dnu.loi.smartrm.ui.base.BaseRecyclerViewAdapter;
import com.dnu.loi.smartrm.ui.dialog.InputNumberDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 12/04/2018.
 */

public class AdapterDishesList extends BaseRecyclerViewAdapter<Dishes, AdapterDishesList.ViewHolder> {
    private Context context;

    private List<Dishes> mSearchList = new ArrayList<>();

    private boolean isSearch;
    private FragmentManager fragmentManager;

    public AdapterDishesList(Context context, FragmentManager manager) {
        super(new ArrayList<>());
        this.context = context;
        fragmentManager = manager;
    }


    @Override
    protected int getLayoutResourceItem() {
        return R.layout.item_dishes_list;
    }

    @Override
    protected int getSize() {
        if (isSearch) {
            return mSearchList != null ? mSearchList.size() : 0;
        }
        return getCollection() != null ? getCollection().size() : 0;
    }

    @Override
    protected ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBind(ViewHolder holder, int position) {
        Dishes dishes = getCollection().get(position);

        holder.tvDishesName.setText(dishes.getName());

        holder.tvPrice.setText(String.valueOf(dishes.getPrice()));

        holder.llDishesSelected.setVisibility(dishes.isSelected() ? View.VISIBLE : View.GONE);

        holder.tvAmount.setText(String.valueOf(dishes.getAmount()));

        Glide.with(context)
                .load(dishes.getImage())
                .into(holder.ivDishesImage);

        holder.ivDishesImage.setOnClickListener((view) -> {
            holder.llDishesSelected.setVisibility(View.VISIBLE);
            dishes.setAmount(1);
            holder.tvAmount.setText(String.valueOf(dishes.getAmount()));
            dishes.setSelected(true);
            mListener.onClick(holder.ivDishesImage, dishes);
        });

        holder.ivDishesSelected.setOnClickListener((view) -> {
            holder.llDishesSelected.setVisibility(View.GONE);
            holder.tvAmount.setText("1");
            dishes.setSelected(false);
            dishes.setAmount(0);
            mListener.onClick(holder.ivDishesSelected, dishes);
        });

        holder.llDishesSelected.setOnClickListener((view) -> {
            int newAmount = dishes.getAmount() + 1;
            dishes.setAmount(newAmount);
            holder.tvAmount.setText(String.valueOf(newAmount));
            mListener.onClick(holder.llDishesSelected, dishes);
        });

        holder.ivMinus.setOnClickListener((view) -> {
            if (dishes.getAmount() > 1) {
                int newAmount = dishes.getAmount() - 1;
                dishes.setAmount(newAmount);
                holder.tvAmount.setText(String.valueOf(newAmount));
            } else
                holder.ivDishesSelected.performClick();
            mListener.onClick(holder.ivMinus, dishes);
        });

        holder.ivPlus.setOnClickListener((view) -> {
            int newAmount = dishes.getAmount() + 1;
            dishes.setAmount(newAmount);
            holder.tvAmount.setText(String.valueOf(newAmount));
            mListener.onClick(holder.ivPlus, dishes);
        });

        holder.tvAmount.setOnClickListener(v -> {
            InputNumberDialog.newInstance("Nhập số lượng", "Số lượng", aDouble -> {
                holder.tvAmount.setText(String.valueOf(aDouble.intValue()));
            }).show(fragmentManager, null);
        });
    }

    public List<Dishes> getDishesSelected() {
        List<Dishes> dishesList = new ArrayList<>();

        for (Dishes dishes : getCollection()) {
            if (dishes.isSelected())
                dishesList.add(dishes);
        }
        return dishesList;
    }

    @Override
    public void refresh(List<Dishes> dishesList) {
        super.refresh(getDishesSelected());
        addAll(dishesList);
    }

    @Override
    public void addAll(List<Dishes> dishesList) {
        List<Dishes> temp = new ArrayList<>();
        if (dishesList != null) {
            for (Dishes item : dishesList) {
                if (!getCollection().contains(item))
                    temp.add(item);
            }
        }

        super.addAll(temp);
    }

    public void setDishesSelected(List<OrderDetail> dishesSelected) {
        //nếu có dữ liệu (edit mode)
        if (dishesSelected != null) {
            for (OrderDetail item : dishesSelected) {
                for (Dishes dishes : getCollection()) {
                    if (item.getDishesId() == dishes.getId()) {
                        dishes.setAmount(item.getAmount());
                        dishes.setSelected(true);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public String getTotalPrice() {

        long total = 0;

        for (Dishes dishes : getCollection()) {
            total += dishes.getPrice() * dishes.getAmount();
        }

        return String.valueOf(total);
    }

    public void searchDishes(String dishesName) {
        mSearchList.clear();//xóa search list cũ
        isSearch = !dishesName.isEmpty();
        if (isSearch)
            for (Dishes dishes : getCollection()) {
                if (dishes.getName().toLowerCase().trim().contains(dishesName.toLowerCase().trim()))
                    mSearchList.add(dishes);
            }
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDishesName, tvPrice, tvAmount;
        ImageView ivDishesImage, ivPlus, ivMinus, ivDishesSelected;
        LinearLayout llDishesSelected;

        ViewHolder(View itemView) {
            super(itemView);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            tvPrice = itemView.findViewById(R.id.tvDishesPrice);
            tvDishesName = itemView.findViewById(R.id.tvDishesName);
            ivDishesImage = itemView.findViewById(R.id.ivDishesImage);
            ivDishesSelected = itemView.findViewById(R.id.ivDishesSelect);
            ivMinus = itemView.findViewById(R.id.ivMinus);
            ivPlus = itemView.findViewById(R.id.ivPlus);
            llDishesSelected = itemView.findViewById(R.id.llDishesSelect);
        }
    }
}
