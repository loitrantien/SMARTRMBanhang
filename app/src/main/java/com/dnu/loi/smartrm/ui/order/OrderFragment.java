package com.dnu.loi.smartrm.ui.order;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.order.OrderBL;
import com.dnu.loi.smartrm.common.OrderMode;
import com.dnu.loi.smartrm.custom.EditTextClearAble;
import com.dnu.loi.smartrm.dl.order.OrderDL;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.DishesType;
import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.obj.OrderDetail;
import com.dnu.loi.smartrm.obj.Table;
import com.dnu.loi.smartrm.ui.adddishes.AddDishesDialog;
import com.dnu.loi.smartrm.ui.adddishes.DishesTypeAdapter;
import com.dnu.loi.smartrm.ui.base.BaseFragment;
import com.dnu.loi.smartrm.ui.bill.BillActivity;
import com.dnu.loi.smartrm.ui.dialog.ISimpleCallBack;
import com.dnu.loi.smartrm.ui.dialog.InputNumberDialog;
import com.dnu.loi.smartrm.ui.dialog.SimpleListDialog;
import com.dnu.loi.smartrm.utils.DataBaseHelper;
import com.dnu.loi.smartrm.utils.UIHelper;

import java.util.ArrayList;
import java.util.List;


public class OrderFragment extends BaseFragment implements IOrderView {
    private RecyclerView mRecyclerView;

    private TextView tvSave, tvTakeMoney, tvFilter, tvTotal, tvPeopleCount, tvTableNum;

    private ImageView ivBack, ivAddDishes;

    private EditTextClearAble etSearch;

    private AdapterDishesList mAdapter;

    private IOrderPresenter mPresenter;

    private Order order;

    private DishesTypeAdapter adapter;

    private int itemPos;


    public static OrderFragment newInstance(Table table) {
        OrderFragment fragment = new OrderFragment();
        fragment.order = new Order();
        fragment.order.setTable(table);
        fragment.order.setPeopleCount(0);
        return fragment;
    }

    public static OrderFragment newInstance(Order order) {
        OrderFragment fragment = new OrderFragment();
        fragment.order = order;
        return fragment;
    }

    @Override
    protected int getLayoutInflate() {
        return R.layout.fragment_order;
    }

    @Override
    protected void mappingView(View view) {
        tvSave = view.findViewById(R.id.tvSave);
        tvTakeMoney = view.findViewById(R.id.tvTakeMoney);
        mRecyclerView = view.findViewById(R.id.rcvDishesList);
        etSearch = view.findViewById(R.id.etDishesSearch);
        tvFilter = view.findViewById(R.id.tvDishesFilter);
        tvPeopleCount = view.findViewById(R.id.tvPeopleNum);
        tvTableNum = view.findViewById(R.id.tvTableNum);
        tvTotal = view.findViewById(R.id.tvTotal);
        ivBack = view.findViewById(R.id.ivBack);
        ivAddDishes = view.findViewById(R.id.ivAddDishes);
    }

    @Override
    protected void onBindView() {
        mAdapter = new AdapterDishesList(getContext(), getFragmentManager());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        tvTableNum.setText(order.getTable().getTableNum());
        tvPeopleCount.setText(order.getPeopleCount());

        mPresenter.initData();

    }

    @Override
    protected void setViewEvent() {
        try {
            mAdapter.setOnItemClickedListener((view, dishes) -> tvTotal.setText(mAdapter.getTotalPrice()));
            tvTakeMoney.setOnClickListener((v) -> gotoBill(mAdapter.getDishesSelected()));
            tvSave.setOnClickListener(v -> saveOrder(getOrder()));
            etSearch.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    searchDishesList(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            ivBack.setOnClickListener((v) -> getActivity().finish());
            ivAddDishes.setOnClickListener(v -> showAddDishes());
            tvFilter.setOnClickListener(v -> showDishesTypeList());
            tvTableNum.setOnClickListener(v -> {
                showDialogInput(getString(R.string.input_table_num), getString(R.string.table_num), aDouble -> {
                    tvTableNum.setText(String.valueOf(aDouble.intValue()));
                });
            });
            tvPeopleCount.setOnClickListener(v -> showDialogInput(getString(R.string.input_people_count), getString(R.string.people_count), aDouble -> {
                tvPeopleCount.setText(String.valueOf(aDouble.intValue()));
                order.setPeopleCount(aDouble.intValue());
            }));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Order getOrder() {

        if (OrderActivity.MODE == OrderMode.EDIT_MODE) {
            order.setState(1);
            order.setDetailList(dishesListToDetailList(mAdapter.getDishesSelected()));
            order.setOrderPrice(Double.valueOf(mAdapter.getTotalPrice()));
            return order;
        } else {
            order.setId(DataBaseHelper.getNewOrderId());
            order.setState(1);
            order.setDetailList(dishesListToDetailList(mAdapter.getDishesSelected()));
            order.setOrderPrice(Double.valueOf(mAdapter.getTotalPrice()));
        }

        return order;
    }

    private List<OrderDetail> dishesListToDetailList(List<Dishes> dishes) {
        List<OrderDetail> detailList = new ArrayList<>();
        for (Dishes item : dishes) {
            OrderDetail detail = new OrderDetail();
            detail.setOrderId(order.getId());
            detail.setDishesName(item.getName());
            detail.setAmount(item.getAmount());
            detail.setDishesId(item.getId());
            detail.setPrice(item.getPrice());
            if (order.getDetailList() == null) {
                detailList.add(detail);
            } else if (!order.getDetailList().contains(detail))
                detailList.add(detail);
        }
        return detailList;
    }

    @Override
    protected void onViewAttach() {
        mPresenter = new OrderPresenter(new OrderBL(new OrderDL()));
        mPresenter.onViewAttach(this);
    }

    @Override
    protected void onViewDestroy() {
        mPresenter.onViewDestroy();
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showError(String message) {
        runOnUiThread(() -> UIHelper.ToastShort(message));
    }

    @Override
    public void showSaveOrderSuccess() {
        runOnUiThread(() -> {
            UIHelper.ToastShort(UIHelper.getString(R.string.save_order_success));
            getActivity().finish();
        });
    }

    @Override
    public void setDishesList(List<Dishes> dishesList) {
        runOnUiThread(() -> {
            mAdapter.refresh(dishesList);
            if (OrderActivity.MODE == OrderMode.EDIT_MODE) {
                setDishesSelected(order.getDetailList());
                tvTotal.setText(mAdapter.getTotalPrice());
            }
        });
    }

    @Override
    public void setDishesSelected(List<OrderDetail> dishesList) {
        mAdapter.setDishesSelected(dishesList);
    }

    @Override
    public void saveOrder(Order order) {
        mPresenter.saveOrder(order);
    }

    @Override
    public void searchDishesList(String s) {
        mAdapter.searchDishes(s);
    }

    @Override
    public void setDishesTypeList(List<DishesType> typeList) {
        runOnUiThread(() -> {
            adapter = new DishesTypeAdapter(typeList, 0);
            tvFilter.setText(typeList.get(0).getName());
        });
    }

    @Override
    public void showDishesTypeList() {
        SimpleListDialog<DishesType> dialog = new SimpleListDialog<>();
        dialog.setTitle(getString(R.string.dishes_type));
        adapter.setCurrentItemPosition(itemPos);
        dialog.setInstance(adapter, dishesType -> {
            tvFilter.setText(dishesType.getName());
            itemPos = adapter.getCurrentItemPosition();
            mPresenter.getDishesListByType(dishesType);
        });
        dialog.show(getFragmentManager(), null);
    }

    @Override
    public void gotoBill(List<Dishes> dishesList) {
        runOnUiThread(() -> {
            Intent intent = new Intent(getContext(), BillActivity.class);
            BillActivity.setData(getOrder(), () -> getActivity().finish());
            startActivity(intent);
        });
    }

    @Override
    public void showAddDishes() {
        AddDishesDialog addDishesDialog = AddDishesDialog.newInstance(dishes -> mAdapter.add(dishes));
        addDishesDialog.show(getFragmentManager(), null);
    }

    @Override
    public void showDialogInput(String title, String field, ISimpleCallBack<Double> callBack) {
        InputNumberDialog dialog = InputNumberDialog.newInstance(title, field, callBack);
        dialog.show(getFragmentManager(), null);

    }
}
