package com.dnu.loi.smartrm.ui.ordermanage;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.common.ConstHelper;
import com.dnu.loi.smartrm.common.OrderMode;
import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.obj.OrderDetail;
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
        List<Order> orderList = new ArrayList<>();

        List<OrderDetail> detailList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            OrderDetail detail = new OrderDetail();
            detail.setDishesName("Bánh" + i);
            detail.setAmount(i + 1);
            detailList.add(detail);
        }

        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setDetailList(detailList);
            order.setTableNum(i);
            order.setPeopleCount(4);
            order.setOrderPrice(89000);
            orderList.add(order);
        }


        mAdapter = new AdapterOrderList(orderList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void setViewEvent() {
        fabAddOrder.setOnClickListener((view) -> newOrder());
        mAdapter.setOnItemClickedListener((view, order) -> {
            newOrder();
        });
    }

    @Override
    protected void onViewAttach() {
        mPresenter = new OrderManagePresenter();
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

    }

    @Override
    public void showError(String message) {
        UIHelper.ToastShort(message);
    }


    @Override
    public void newOrder() {
        Intent intent = new Intent(getContext(), OrderActivity.class);
        intent.putExtra(ConstHelper.ORDER_MODE, OrderMode.ADD_MODE.getValues());
        startActivity(intent);
    }

    @Override
    public void setOrderList(List<Order> orderList) {

    }

    @Override
    public void setMerge(List<Order> orderList) {

    }

    @Override
    public void splitOrder(Order order) {

    }
}
