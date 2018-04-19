package com.dnu.loi.smartrm.ui.tablemap;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.tablemap.TableMapBL;
import com.dnu.loi.smartrm.custom.EditTextClearAble;
import com.dnu.loi.smartrm.dl.tablemap.TableMapDL;
import com.dnu.loi.smartrm.obj.Floor;
import com.dnu.loi.smartrm.obj.Table;
import com.dnu.loi.smartrm.ui.base.BaseFragment;
import com.dnu.loi.smartrm.utils.UIHelper;

import java.util.ArrayList;
import java.util.List;

public class TableMapFragment extends BaseFragment implements ITableMapView {

    private TextView tvFloorFilter;

    private RecyclerView rcvTableMap;

    private EditTextClearAble etTableSearch;

    private AdapterTableListRecyclerViewAdapter mAdapter;

    private ITableMapPresenter mPresenter;

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
        mAdapter = new AdapterTableListRecyclerViewAdapter();
        mAdapter.setOnItemClickedListener((view, table) -> {
            try {
                goToNewOrder(table);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        rcvTableMap.setLayoutManager(manager);
        rcvTableMap.setAdapter(mAdapter);
        mPresenter.initTableMap();
    }

    @Override
    protected void setViewEvent() {
        etTableSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                searchTableByName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        tvFloorFilter.setOnClickListener((view) -> showListFloor());
    }

    @Override
    protected void onViewAttach() {
        mPresenter = new TableMapPresenter(new TableMapBL(new TableMapDL()));
        mPresenter.onViewAttach(this);
    }

    @Override
    protected void onViewDestroy() {
        mPresenter.onViewDestroy();
        mPresenter = null;
    }


    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void showNetworkError() {
        UIHelper.ToastShort(getString(R.string.network_error));
    }

    @Override
    public void showError(String message) {
        UIHelper.ToastShort(message);
    }


    @Override
    public void setListTable(List<Table> tables) {
        mAdapter.refresh(tables);
    }

    @Override
    public void setListFloor(List<Floor> floors) {
        //todo
    }

    @Override
    public void searchTableByName(String name) {
        mAdapter.searchTable(name);
    }

    @Override
    public void goToNewOrder(Table table) {

    }

    @Override
    public void showListFloor() {

    }
}
