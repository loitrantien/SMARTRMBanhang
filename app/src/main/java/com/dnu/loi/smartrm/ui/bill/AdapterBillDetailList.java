package com.dnu.loi.smartrm.ui.bill;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.ui.base.BaseRecyclerViewAdapter;

import java.util.List;

/**
 * summary: adapter rcv hóa đơn
 * <p>
 * Created by TTLoi on 15/04/2018.
 */

public class AdapterBillDetailList extends BaseRecyclerViewAdapter<Dishes, AdapterBillDetailList.ViewHolder> {
    public AdapterBillDetailList(List<Dishes> mMainList) {
        super(mMainList);
    }

    @Override
    protected int getLayoutResourceItem() {
        return R.layout.item_order_detail_list;
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
        holder.tvAmount.setText(String.valueOf(dishes.getAmount()));
        holder.tvPrice.setText(dishes.getPrice());
        holder.tvTotalPrice.setText(String.valueOf(
                Long.parseLong(
                        dishes.getPrice()) * dishes.getAmount()));
    }

    public String getTotalPrice() {

        long total = 0;

        for (Dishes dishes : getCollection()) {
            total += Long.parseLong(
                    dishes.getPrice()) * dishes.getAmount();
        }

        return String.valueOf(total);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDishesName, tvAmount, tvPrice, tvTotalPrice;

        ViewHolder(View itemView) {
            super(itemView);
            tvDishesName = itemView.findViewById(R.id.tvDishesName);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvTotalPrice = itemView.findViewById(R.id.tvTotalPrice);
        }
    }
}
