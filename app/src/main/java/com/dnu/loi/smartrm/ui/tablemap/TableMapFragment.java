package com.dnu.loi.smartrm.ui.tablemap;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.custom.EditTextClearAble;
import com.dnu.loi.smartrm.obj.Table;
import com.dnu.loi.smartrm.ui.base.BaseFragment;
import com.dnu.loi.smartrm.utils.UIHelper;

import java.util.ArrayList;
import java.util.List;

public class TableMapFragment extends BaseFragment implements ITableView {

    private TextView tvFloorFilter;

    private RecyclerView rcvTableMap;

    private EditTextClearAble etTableSearch;

    private AdapterTableListRecyclerViewAdapter mAdapter;

    @Override
    protected int getLayoutInflate() {
        return R.layout.fragment_table_map;
    }

    @Override
    protected void mappingView(View view) {
        tvFloorFilter = view.findViewById(R.id.tvFloorFilter);
        rcvTableMap = view.findViewById(R.id.rcvTableMap);
        etTableSearch = view.findViewById(R.id.etTableSearch);
        etTableSearch.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    @Override
    protected void onBindView() {
        List<Table> tables = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {

            Table table1 = new Table();
            table1.setTableId("axcc");
            table1.setTableNum(i);

            if (i % 2 == 0) {
                table1.setSelected(true);
                table1.setTableType(Integer.parseInt("2" + i));
            } else {
                table1.setTableType(Integer.parseInt("2" + (i + 1)));
            }
            tables.add(table1);
        }
        for (int i = 1; i <= 12; i++) {

            Table table1 = new Table();
            table1.setTableId("axcc");
            table1.setTableNum(i);

            if (i % 2 == 0) {
                table1.setTableType(Integer.parseInt("1" + i));
            } else {
                table1.setSelected(true);
                table1.setTableType(Integer.parseInt("1" + (i + 1)));
            }
            tables.add(table1);
        }


        mAdapter = new AdapterTableListRecyclerViewAdapter(tables);
        mAdapter.setOnItemClickedListener((view, table) -> {
            try {
                //todo
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        rcvTableMap.setLayoutManager(manager);
        rcvTableMap.setAdapter(mAdapter);
    }

    @Override
    protected void setViewEvent() {
        etTableSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mAdapter.searchTable(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        tvFloorFilter.setOnClickListener((view) -> showFloorFilter());
    }

    @Override
    protected void onViewAttach() {

    }

    @Override
    protected void onViewDestroy() {

    }

    @Override
    public void showFloorFilter() {
        try {
            //todo
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void showNetworkError() {
        UIHelper.ToastShort(getContext(), getString(R.string.network_error));
    }
}
