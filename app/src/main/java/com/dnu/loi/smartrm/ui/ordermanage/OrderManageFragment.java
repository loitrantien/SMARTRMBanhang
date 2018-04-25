package com.dnu.loi.smartrm.ui.ordermanage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.ordermanage.OrderManageBL;
import com.dnu.loi.smartrm.common.OrderMode;
import com.dnu.loi.smartrm.dl.ordermanage.OrderManageDL;
import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.obj.OrderDetail;
import com.dnu.loi.smartrm.obj.Table;
import com.dnu.loi.smartrm.ui.base.BaseFragment;
import com.dnu.loi.smartrm.ui.order.OrderActivity;
import com.dnu.loi.smartrm.utils.UIHelper;

import java.util.ArrayList;
import java.util.List;

public class OrderManageFragment extends BaseFragment implements IOrderManageView {

    private RecyclerView mRecyclerView;

    private AdapterOrderList mAdapter;

    private IOrderManagePresenter mPresenter;

    private FloatingActionButton fabAddOrder;

    private OnFabNewOrderClick callback;

    public static OrderManageFragment newInstance(OnFabNewOrderClick callback) {


        OrderManageFragment fragment = new OrderManageFragment();
        fragment.callback = callback;
        return fragment;
    }

    @Override
    protected int getLayoutInflate() {
        return R.layout.fragment_order_manage;
    }

    @Override
    protected void mappingView(View view) {
        mRecyclerView = view.findViewById(R.id.rcvListOrder);
        fabAddOrder = view.findViewById(R.id.fabAddOrder);
    }

    @Override
    protected void onBindView() {

        mAdapter = new AdapterOrderList(getContext());


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void setViewEvent() {
        fabAddOrder.setOnClickListener((view) -> newOrder());
        mAdapter.setOnItemClickedListener((view, order) -> {
            int id = view.getId();
            switch (id){
                case R.id.cslEditOrder:
                    Intent intent = new Intent(getContext(), OrderActivity.class);
                    OrderActivity.MODE = OrderMode.EDIT_MODE;
                    OrderActivity.setInstance(order);
                    startActivity(intent);
                    break;
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.initOrderList();
    }

    @Override
    protected void onViewAttach() {
        mPresenter = new OrderManagePresenter(new OrderManageBL(new OrderManageDL()));
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
        runOnUiThread(()->{

        });
    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showError(String message) {
        runOnUiThread(() -> UIHelper.ToastShort(message));

    }


    @Override
    public void newOrder() {
        runOnUiThread(()->callback.onCreateNewOrder());
    }

    @Override
    public void setOrderList(List<Order> orderList) {
        runOnUiThread(()-> mAdapter.refresh(orderList));
    }

    @Override
    public void setMerge(List<Order> orderList) {
        runOnUiThread(()->{

        });
    }

    @Override
    public void splitOrder(Order order) {
        runOnUiThread(()->{

        });
    }

    public interface OnFabNewOrderClick {
        void onCreateNewOrder();
    }
}
