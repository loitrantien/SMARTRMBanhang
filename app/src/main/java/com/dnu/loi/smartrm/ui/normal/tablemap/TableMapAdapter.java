package com.dnu.loi.smartrm.ui.normal.tablemap;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.entity.Table;
import com.dnu.loi.smartrm.ui.base.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Mô tả: Adapter recyclerView {@link TableMapFragment}
 * <p>
 * Created by loi on 07/04/2018.
 */

public class TableMapAdapter extends BaseRecyclerViewAdapter<Table, TableMapAdapter.ViewHolder> {

    private List<Table> mSearchList = new ArrayList<>();

    private boolean isSearch;

    public TableMapAdapter() {
        super(new ArrayList<>());
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
        holder.TableNum.setText(String.valueOf(table.getName()));
        holder.root.setOnClickListener(view -> mListener.onClick(view, table));
    }

    public void searchTable(String tableNum) {
        mSearchList.clear();//xóa search list cũ
        isSearch = !tableNum.isEmpty();

        if (isSearch)
            for (Table table : getCollection()) {
                if (String.valueOf(table.getName().toLowerCase()).contains(tableNum.toLowerCase())) {
                    mSearchList.add(table);
                }
            }

        notifyDataSetChanged();
    }

    public void setTablesSelected(List<Table> tables) {
        for (Table table : tables) {
            for (Table item : getCollection()) {
                if (item.getId().equals( table.getId())) {
                    item.setSelected(true);
                }
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
