package com.dnu.loi.smartrm.ui.ordermanage;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.ui.base.RecyclerViewAdapterBase;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 07/04/2018.
 */

public class AdapterOrderList extends RecyclerViewAdapterBase<Order, AdapterOrderList.ViewHolder> {

    public AdapterOrderList(List<Order> mMainList) {
        super(mMainList);
    }

    @Override
    protected int getLayoutResourceItem() {
        return R.layout.item_order_list;
    }

    @Override
    protected int getSize() {
        return getCollection() != null ? getCollection().size() : 0;
    }

    @Override
    protected ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBind(ViewHolder holder, int position) {
        Order order = getCollection().get(position);

        holder.tvTableNum.setText(order.getTableNum());
        holder.tvTablePeople.setText(order.getPeopleCount());
        holder.tvOrderPrice.setText(order.getOrderPrice());
        holder.tvDescription.setText(Html.fromHtml(order.getDetailListString()));
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTableNum, tvTablePeople, tvDescription, tvOrderPrice;
        ImageView ivExpand;
        Button btnRemoveOrder, btnTakeMoney;

        ViewHolder(View itemView) {
            super(itemView);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvOrderPrice = itemView.findViewById(R.id.tvOrderPrice);
            tvTableNum = itemView.findViewById(R.id.tvTableNum);
            tvTablePeople = itemView.findViewById(R.id.tvPeopleNum);
            ivExpand = itemView.findViewById(R.id.ivExpand);
            btnRemoveOrder = itemView.findViewById(R.id.btnRemoveOrder);
            btnTakeMoney = itemView.findViewById(R.id.btnTakeMoney);
        }
    }
}
