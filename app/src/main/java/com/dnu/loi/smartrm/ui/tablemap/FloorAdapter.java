package com.dnu.loi.smartrm.ui.tablemap;

import android.view.View;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.obj.Floor;
import com.dnu.loi.smartrm.ui.base.BaseRecyclerViewAdapter;
import com.dnu.loi.smartrm.ui.dialog.SimpleListDialog;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 26/04/2018.
 */

public class FloorAdapter extends BaseRecyclerViewAdapter<Floor,SimpleListDialog.ViewHolder> {
    public FloorAdapter(List<Floor> mMainList, int currentItem) {
        super(mMainList);
        super.currentItemPosition = currentItem;
    }

    @Override
    protected int getLayoutResourceItem() {
        return R.layout.item_simple_list;
    }

    @Override
    protected int getSize() {
        return getCollection().size();
    }

    @Override
    protected SimpleListDialog.ViewHolder getViewHolder(View view) {
        return new SimpleListDialog.ViewHolder(view);
    }

    @Override
    protected void onBind(SimpleListDialog.ViewHolder holder, int position) {
        Floor floor = getCollection().get(position);

        holder.tvContent.setText(floor.getName());
        holder.ivCheckBox.setVisibility(position == currentItemPosition ? View.VISIBLE : View.INVISIBLE);

        holder.llContainer.setOnClickListener(v -> {
            currentItemPosition = position;
            notifyDataSetChanged();
        });
    }
}
