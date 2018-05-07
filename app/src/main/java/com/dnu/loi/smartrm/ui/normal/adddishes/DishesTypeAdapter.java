package com.dnu.loi.smartrm.ui.normal.adddishes;

import android.view.View;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.common.ConstHelper;
import com.dnu.loi.smartrm.entity.DishesType;
import com.dnu.loi.smartrm.ui.base.BaseRecyclerViewAdapter;
import com.dnu.loi.smartrm.ui.normal.dialog.SimpleListDialog;
import com.dnu.loi.smartrm.utils.UIHelper;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 25/04/2018.
 */

public class DishesTypeAdapter extends BaseRecyclerViewAdapter<DishesType, SimpleListDialog.ViewHolder> {
    public DishesTypeAdapter(List<DishesType> mMainList, int currentItem) {
        super(mMainList);

        for (DishesType dishesType : mMainList) {
            if (dishesType.getId().equals(ConstHelper.IGNORE_VALUE)) {
                mMainList.remove(dishesType);
                break;
            }
        }

        mMainList.add(0, new DishesType(ConstHelper.GET_ALL_VALUE, UIHelper.getString(R.string.all)));
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
        DishesType dishesType = getCollection().get(position);

        holder.tvContent.setText(dishesType.getName());
        holder.ivCheckBox.setVisibility(position == currentItemPosition ? View.VISIBLE : View.INVISIBLE);

        holder.llContainer.setOnClickListener(v -> {
            currentItemPosition = position;
            notifyDataSetChanged();
            mListener.onClick(v, dishesType);
        });
    }


}
