package com.dnu.loi.smartrm.ui.order;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.ui.base.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 12/04/2018.
 */

public class AdapterDishesList extends BaseRecyclerViewAdapter<Dishes, AdapterDishesList.ViewHolder> {
    private Context context;

    public AdapterDishesList(List<Dishes> mMainList, Context context) {
        super(mMainList);
        this.context = context;
    }
    public AdapterDishesList(Context context) {
        super(new ArrayList<>());
        this.context = context;
    }

    @Override
    protected int getLayoutResourceItem() {
        return R.layout.item_dishes_list;
    }

    @Override
    protected int getSize() {
        return getCollection().size();
    }

    @Override
    protected ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBind(ViewHolder holder, int position) {
        Dishes dishes = getCollection().get(position);

        holder.tvDishesName.setText(dishes.getName());

        holder.tvPrice.setText(dishes.getPrice());

        holder.llDishesSelected.setVisibility(dishes.isSelected() ? View.VISIBLE : View.GONE);

        Glide.with(context)
                .load(dishes.getImage())
                .into(holder.ivDishesImage);

        holder.ivDishesImage.setOnClickListener((view) -> {
            holder.llDishesSelected.setVisibility(View.VISIBLE);
            dishes.setAmount(1);
            holder.tvAmount.setText(String.valueOf(dishes.getAmount()));
            dishes.setSelected(true);
        });

        holder.ivDishesSelected.setOnClickListener((view) -> {
            holder.llDishesSelected.setVisibility(View.GONE);
            holder.tvAmount.setText("1");
            dishes.setSelected(false);
            dishes.setAmount(0);
        });

        holder.llDishesSelected.setOnClickListener((view) -> {
            int newAmount = dishes.getAmount() + 1;
            dishes.setAmount(newAmount);
            holder.tvAmount.setText(String.valueOf(newAmount));
        });

        holder.ivMinus.setOnClickListener((view) -> {
            if (dishes.getAmount() > 1) {
                int newAmount = dishes.getAmount() - 1;
                dishes.setAmount(newAmount);
                holder.tvAmount.setText(String.valueOf(newAmount));
            } else
                holder.ivDishesSelected.performClick();
        });

        holder.ivPlus.setOnClickListener((view) -> {
            int newAmount = dishes.getAmount() + 1;
            dishes.setAmount(newAmount);
            holder.tvAmount.setText(String.valueOf(newAmount));
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
