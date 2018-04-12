package com.dnu.loi.smartrm.ui.tablemap;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.obj.Table;
import com.dnu.loi.smartrm.ui.base.RecyclerViewAdapterBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Mô tả: Adapter recyclerView {@link TableMapFragment}
 * <p>
 * Created by loi on 07/04/2018.
 */

public class AdapterTableList extends RecyclerViewAdapterBase<Table, AdapterTableList.ViewHolder> {

    private List<Table> mSearchList = new ArrayList<>();

    private boolean isSearch;

    public AdapterTableList(List<Table> mList) {
        super(mList);
    }

    @Override
    protected int getLayoutResourceItem() {
        return R.layout.item_table_list;
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
        Table table = isSearch ? mSearchList.get(position) : getCollection().get(position);
        holder.TableImage.setImageResource(table.getTableImageResource());
        holder.TableImage.setSelected(table.isSelected());
        holder.TableNum.setText(String.valueOf(table.getTableNum()));
        holder.root.setOnClickListener(view -> mListener.onClick(view, table));
    }

    public void searchTable(String tableNum) {
        mSearchList.clear();//xóa search list cũ
        isSearch = !tableNum.isEmpty();

        if (isSearch)
            for (Table table : getCollection()) {
                if (String.valueOf(table.getTableNum()).equals(tableNum)) {
                    mSearchList.add(table);
                }
            }

        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView TableImage;
        TextView TableNum;
        ConstraintLayout root;

        ViewHolder(View itemView) {
            super(itemView);
            TableImage = itemView.findViewById(R.id.ivTableImage);
            TableNum = itemView.findViewById(R.id.tvTableNum);
            root = itemView.findViewById(R.id.cslTableItem);
        }
    }

}
