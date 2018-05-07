package com.dnu.loi.smartrm.ui.normal.ordermanage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.entity.Order;
import com.dnu.loi.smartrm.ui.base.BaseRecyclerViewAdapter;
import com.dnu.loi.smartrm.utils.ExceptionHelper;
import com.dnu.loi.smartrm.utils.MoneyHelper;

import java.util.ArrayList;

/**
 * Mô tả:
 * <p>
 * Created by loi on 07/04/2018.
 */

public class AdapterOrderList extends BaseRecyclerViewAdapter<Order, AdapterOrderList.ViewHolder> {

    private Context context;

    public AdapterOrderList(Context context) {
        super(new ArrayList<>());
        this.context = context;

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

    @SuppressLint("RestrictedApi")
    @Override
    protected void onBind(ViewHolder holder, int position) {
        try {
            Order order = getCollection().get(position);

            holder.tvTableNum.setText(order.getTable().getName());
            holder.tvOrderPrice.setText(MoneyHelper.getMoneyFromDouble(order.getTotal()));
            holder.tvDescription.setText(Html.fromHtml(order.getDetailListString()));
            holder.tvTablePeople.setText(String.valueOf(order.getPeople()));
            holder.cslEditOrder.setOnClickListener((v) -> mListener.onClick(v,order));
            holder.ivExpand.setOnClickListener(v -> {
                PopupMenu popup = new PopupMenu(context, holder.ivExpand);

                popup.getMenuInflater().inflate(R.menu.popup_menu_order_manage, popup.getMenu());

                popup.setOnMenuItemClickListener(item -> {
                    int id = item.getItemId();

                    switch (id){

                    }

                    return true;
                });

                MenuPopupHelper popupHelper= new MenuPopupHelper(context, (MenuBuilder) popup.getMenu(),holder.ivExpand);
                popupHelper.setForceShowIcon(true);
                popupHelper.show();
            });
        }catch (Exception e){
            ExceptionHelper.handlerException("AdapterOrderList#onBind",e);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTableNum, tvTablePeople, tvDescription, tvOrderPrice;
        ImageView ivExpand;
        Button btnRemoveOrder, btnTakeMoney;
        ConstraintLayout cslEditOrder;

        ViewHolder(View itemView) {
            super(itemView);
            cslEditOrder = itemView.findViewById(R.id.cslEditOrder);
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
