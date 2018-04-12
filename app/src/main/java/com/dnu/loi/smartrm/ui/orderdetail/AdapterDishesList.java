package com.dnu.loi.smartrm.ui.orderdetail;

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

    @Override
    protected int getLayoutResourceItem() {
        return R.layout.item_order_detail;
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

        Glide.
                with(context)
                .load("http://anhnendep.net/wp-content/uploads/2016/02/vit-boi-roi-Psyduck.jpg")
                .into(holder.ivDishesImage);

        holder.ivDishesImage.setOnClickListener((view) -> {
            holder.llDishesSelected.setVisibility(View.VISIBLE);
            holder.tvAmount.setText("1");
            dishes.setSelected(true);
        });

        holder.ivDishesSelected.setOnClickListener((view) -> {
            holder.llDishesSelected.setVisibility(View.GONE);
            holder.tvAmount.setText("1");
            dishes.setSelected(false);
        });

        holder.llDishesSelected.setOnClickListener((view) -> {
            holder.tvAmount.setText(String.valueOf(dishes.getAmount() + 1));
        });

        holder.ivMinus.setOnClickListener((view) -> {
            if (dishes.getAmount() > 0)
                holder.tvAmount.setText(String.valueOf(dishes.getAmount() - 1));
            else
                holder.ivDishesSelected.performClick();
        });

        holder.ivPlus.setOnClickListener((view) -> {
            holder.tvAmount.setText(String.valueOf(dishes.getAmount() + 1));
        });
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
