package com.dnu.loi.smartrm.ui.ordermanage;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.obj.OrderDetail;
import com.dnu.loi.smartrm.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderManageFragment extends BaseFragment {

    private RecyclerView mRecyclerView;

    private AdapterOrderList mAdapter;


    @Override
    protected int getLayoutInflate() {
        return R.layout.fragment_order_manage;
    }

    @Override
    protected void mappingView(View view) {
        mRecyclerView = view.findViewById(R.id.rcvListOrder);
    }

    @Override
    protected void onBindView() {
        List<Order> orderList = new ArrayList<>();

        List<OrderDetail> detailList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            OrderDetail detail = new OrderDetail();
            detail.setDishesName("Bánh" + i);
            detail.setAmount(i+1);
            detailList.add(detail);
        }

        for (int i = 0; i < 10; i++) {
            Order order =new Order();
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

    }

    @Override
    protected void onViewAttach() {

    }

    @Override
    protected void onViewDestroy() {

    }
}
