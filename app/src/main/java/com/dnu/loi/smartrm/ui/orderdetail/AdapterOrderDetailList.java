package com.dnu.loi.smartrm.ui.orderdetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.ui.base.BaseRecyclerViewAdapter;

import java.util.List;

/**
 * summary:
 * <p>
 * Created by TTLoi on 15/04/2018.
 */

public class AdapterOrderDetailList extends BaseRecyclerViewAdapter<Dishes,AdapterOrderDetailList.ViewHolder> {
    public AdapterOrderDetailList(List<Dishes> mMainList) {
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

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
