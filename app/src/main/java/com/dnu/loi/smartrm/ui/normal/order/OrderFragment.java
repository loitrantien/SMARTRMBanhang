package com.dnu.loi.smartrm.ui.normal.order;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.order.OrderBL;
import com.dnu.loi.smartrm.common.OrderMode;
import com.dnu.loi.smartrm.common.OrderState;
import com.dnu.loi.smartrm.custom.EditTextClearAble;
import com.dnu.loi.smartrm.dl.order.OrderDL;
import com.dnu.loi.smartrm.entity.Dishes;
import com.dnu.loi.smartrm.entity.DishesType;
import com.dnu.loi.smartrm.entity.Order;
import com.dnu.loi.smartrm.entity.OrderDetail;
import com.dnu.loi.smartrm.entity.Table;
import com.dnu.loi.smartrm.ui.normal.adddishes.AddDishesDialog;
import com.dnu.loi.smartrm.ui.normal.adddishes.DishesTypeAdapter;
import com.dnu.loi.smartrm.ui.base.BaseFragment;
import com.dnu.loi.smartrm.ui.normal.bill.PayActivity;
import com.dnu.loi.smartrm.ui.normal.bill.InvoiceFragment;
import com.dnu.loi.smartrm.ui.normal.dialog.ISimpleCallBack;
import com.dnu.loi.smartrm.ui.normal.dialog.InputNumberDialog;
import com.dnu.loi.smartrm.ui.normal.dialog.SimpleListDialog;
import com.dnu.loi.smartrm.utils.DateTimeHelper;
import com.dnu.loi.smartrm.utils.MoneyHelper;
import com.dnu.loi.smartrm.utils.UIHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class OrderFragment extends BaseFragment implements IOrderView {
    private RecyclerView mRecyclerView;

    private TextView tvSave, tvTakeMoney, tvFilter, tvTotal, tvPeopleCount, tvTableNum;

    private ImageView ivBack, ivAddDishes, ivCancel;

    private EditTextClearAble etSearch;

    private AdapterDishesList mAdapter;

    private IOrderPresenter mPresenter;

    private Order order;

    private String node = "";

    private DishesTypeAdapter adapter;

    public static OrderMode MODE;

    private int itemPos;

    /**
     * khởi tạo fragment theo chức năng tạo mới order
     *
     * @param table table
     */
    public static OrderFragment newInstance(Table table) {
        OrderFragment fragment = new OrderFragment();
        fragment.order = new Order();
        fragment.order.setTable(table);
        fragment.order.setTableId(table.getId());
        fragment.order.setPeople(0);
        fragment.order.setId(UUID.randomUUID().toString());
        fragment.order.setCreateDate(DateTimeHelper.getCurrentDateTime());
        MODE = OrderMode.ADD_MODE;
        return fragment;
    }

    /**
     * Khởi tạo fragment theo chức năng chỉnh sử order
     *
     * @param order order
     */
    public static OrderFragment newInstance(Order order) {
        OrderFragment fragment = new OrderFragment();
        fragment.order = order;
        MODE = OrderMode.EDIT_MODE;
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
        ivCancel = view.findViewById(R.id.ivCancel);
    }

    @Override
    protected void onBindView() {
        mAdapter = new AdapterDishesList(getContext(), getFragmentManager());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        tvTableNum.setText(order.getTable().getName());
        tvPeopleCount.setText(String.valueOf(order.getPeople()));
        mPresenter.initData();
    }

    @Override
    protected void setViewEvent() {
        try {
            mAdapter.setOnItemClickedListener((view, dishes) -> tvTotal.setText(MoneyHelper.getMoneyFromDouble(mAdapter.getTotalPrice())));
            tvTakeMoney.setOnClickListener((v) -> gotoPay());
            tvSave.setOnClickListener(v -> saveOrder(getOrder()));
            ivBack.setOnClickListener((v) -> getActivity().finish());
            ivAddDishes.setOnClickListener(v -> showAddDishes());
            tvFilter.setOnClickListener(v -> showDishesTypeList());
            tvTableNum.setOnClickListener(v -> showDialogInput(getString(R.string.input_table_num), getString(R.string.table_num), aDouble -> tvTableNum.setText(String.valueOf(aDouble.intValue()))));
            tvPeopleCount.setOnClickListener(v -> showDialogInput(getString(R.string.input_people_count), getString(R.string.people_count), aDouble -> tvPeopleCount.setText(String.valueOf(aDouble.intValue()))));
            ivCancel.setOnClickListener(v -> getActivity().finish());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Order getOrder() {
        order.setPeople(Integer.parseInt(tvPeopleCount.getText().toString()));
        order.setDetails(dishesListToDetailList(mAdapter.getDishesSelected()));
        order.setTotal(mAdapter.getTotalPrice());
        if (order.getState() == null) {
            order.setState(OrderState.NEW.getState());
        }
        order.setNote(node);
        order.setUpdateDate(DateTimeHelper.getCurrentDateTime());
        return order;

    }

    private List<OrderDetail> dishesListToDetailList(List<Dishes> dishesList) {
        List<OrderDetail> orderDetails = null;
        try {
            orderDetails = new ArrayList<>();
            for (Dishes dishes : dishesList) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setName(dishes.getName());
                orderDetail.setAmount(dishes.getAmount());
                orderDetail.setPrice(dishes.getPrice());
                orderDetail.setOrderId(order.getId());
                orderDetails.add(orderDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderDetails;
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
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

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
            if (MODE == OrderMode.EDIT_MODE) {
                setDishesSelected(order.getDetails());
                tvTotal.setText(MoneyHelper.getMoneyFromDouble(mAdapter.getTotalPrice()));
            }
        });
    }

    @Override
    public void setDishesSelected(List<OrderDetail> dishesList) {
        mAdapter.setDishesSelected(dishesList);
    }

    @Override
    public void saveOrder(Order order) {
        if (UIHelper.isConnected(getContext()))
            mPresenter.saveOrder(order);
        else
            showNetworkError();
    }

    @Override
    public void searchDishesList(String s) {

    }

    @Override
    public void setDishesTypeList(List<DishesType> typeList) {
        runOnUiThread(() -> {
            adapter = new DishesTypeAdapter(typeList, 0);
            tvFilter.setText(typeList.get(0).getName());
            //gọi khởi tạo danh sách đồ ăn
            mPresenter.getDishesListByType(typeList.get(0));
        });
    }

    @Override
    public void showDishesTypeList() {
        SimpleListDialog<DishesType> dialog = new SimpleListDialog<>();
        dialog.setTitle(getString(R.string.dishes_type));
        adapter.setCurrentItemPosition(itemPos);
        adapter.setOnItemClickedListener((view, dishesType) -> {
            tvFilter.setText(dishesType.getName());
            itemPos = adapter.getCurrentItemPosition();
            mPresenter.getDishesListByType(dishesType);
            dialog.dismiss();
        });
        dialog.setInstance(adapter);
        dialog.show(getFragmentManager(), null);
    }

    @Override
    public void gotoPay() {
        runOnUiThread(() -> {
            Intent intent = new Intent(getContext(), PayActivity.class);
            PayActivity.setFrament(InvoiceFragment.newInstance(getOrder(), () -> getActivity().finish()));
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
