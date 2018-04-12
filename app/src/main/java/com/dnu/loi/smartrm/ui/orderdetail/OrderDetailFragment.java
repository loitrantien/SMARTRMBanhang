package com.dnu.loi.smartrm.ui.orderdetail;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;


public class OrderDetailFragment extends BaseFragment {
    private RecyclerView mRecyclerView;

    private AdapterDishesList mAdapter;

    @Override
    protected int getLayoutInflate() {
        return R.layout.fragment_order_detail;
    }

    @Override
    protected void mappingView(View view) {
        mRecyclerView = view.findViewById(R.id.rcvDishesList);
    }

    @Override
    protected void onBindView() {


        List<Dishes> dishesList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Dishes dishes = new Dishes();
            dishes.setName("Sườn xào chua ngọt");
            dishes.setPrice("89000");
            dishesList.add(dishes);
        }

        mAdapter = new AdapterDishesList(dishesList, getContext());

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
