package com.dnu.loi.smartrm.ui.tablemap;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.tablemap.TableMapBL;
import com.dnu.loi.smartrm.common.OrderMode;
import com.dnu.loi.smartrm.custom.EditTextClearAble;
import com.dnu.loi.smartrm.dl.tablemap.TableMapDL;
import com.dnu.loi.smartrm.obj.DishesType;
import com.dnu.loi.smartrm.obj.Floor;
import com.dnu.loi.smartrm.obj.Table;
import com.dnu.loi.smartrm.ui.base.BaseFragment;
import com.dnu.loi.smartrm.ui.dialog.SimpleListDialog;
import com.dnu.loi.smartrm.ui.order.OrderActivity;
import com.dnu.loi.smartrm.utils.UIHelper;

import java.util.List;

public class TableMapFragment extends BaseFragment implements ITableMapView {

    private TextView tvFloorFilter;

    private RecyclerView rcvTableMap;

    private EditTextClearAble etTableSearch;

    private TableMapAdapter mapAdapter;

    private FloorAdapter floorAdapter;

    private ITableMapPresenter mPresenter;
    private int itemPos;

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
        mapAdapter = new TableMapAdapter();
        mapAdapter.setOnItemClickedListener((view, table) -> {
            try {
                goToNewOrder(table);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        rcvTableMap.setLayoutManager(manager);
        rcvTableMap.setAdapter(mapAdapter);
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
        runOnUiThread(() -> {

        });
    }

    @Override
    public void showNetworkError() {
        UIHelper.ToastShort(getString(R.string.network_error));
    }

    @Override
    public void showError(String message) {
        runOnUiThread(() -> UIHelper.ToastShort(message));
    }


    @Override
    public void setListTable(List<Table> tables) {
        runOnUiThread(() -> mapAdapter.refresh(tables));
    }

    @Override
    public void setListFloor(List<Floor> floors) {
        runOnUiThread(() -> {
            floorAdapter = new FloorAdapter(floors, 0);
            tvFloorFilter.setText(floors.get(0).getName());
        });
    }

    @Override
    public void searchTableByName(String name) {
        mapAdapter.searchTable(name);
    }

    @Override
    public void goToNewOrder(Table table) {
        Intent intent = new Intent(getContext(), OrderActivity.class);
        OrderActivity.MODE = OrderMode.ADD_MODE;
        OrderActivity.setInstance(table);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.initTableMap();
    }

    @Override
    public void showListFloor() {
        SimpleListDialog<Floor> dialog = new SimpleListDialog<>();
        dialog.setTitle(getString(R.string.floor));
        floorAdapter.setCurrentItemPosition(itemPos);
        dialog.setInstance(floorAdapter, floor -> {
            tvFloorFilter.setText(floor.getName());
            itemPos = floorAdapter.getCurrentItemPosition();
            mPresenter.loadTablesByFloor(floor);
        });
        dialog.show(getFragmentManager(), null);
    }

    @Override
    public void setTablesSelected(List<Table> tables) {
        runOnUiThread(() -> mapAdapter.setTablesSelected(tables));
    }
}
