package com.dnu.loi.smartrm.ui.order;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.order.OrderBL;
import com.dnu.loi.smartrm.dl.order.OrderDL;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.ui.base.BaseFragment;
import com.dnu.loi.smartrm.ui.bill.BillActivity;
import com.dnu.loi.smartrm.utils.UIHelper;
import java.util.List;


public class OrderFragment extends BaseFragment implements IOrderView {
    private RecyclerView mRecyclerView;

    private AdapterDishesList mAdapter;

    private FloatingActionButton fabDone;

    private List<String> dishesIDList;

    private String orderID;

    private IOrderPresenter mPresenter;

    public static OrderFragment newInstance(List<String> dishesIDList, String orderID) {
        OrderFragment fragment = new OrderFragment();
        fragment.dishesIDList = dishesIDList;
        fragment.orderID = orderID;
        return fragment;
    }

    @Override
    protected int getLayoutInflate() {
        return R.layout.fragment_order;
    }

    @Override
    protected void mappingView(View view) {

        fabDone = view.findViewById(R.id.fabDone);
        mRecyclerView = view.findViewById(R.id.rcvDishesList);
    }

    @Override
    protected void onBindView() {
        mAdapter = new AdapterDishesList(getContext());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mPresenter.initDishesList();

    }

    @Override
    protected void setViewEvent() {
        fabDone.setOnClickListener((v) -> gotoBill(mAdapter.getDishesSelected()));
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
        UIHelper.ToastShort(message);
    }

    @Override
    public void showSaveOrderSuccess() {
        UIHelper.ToastShort(UIHelper.getString(R.string.save_order_success));
    }

    @Override
    public void setDishesList(List<Dishes> dishesList) {
        mAdapter.refresh(dishesList);
    }

    @Override
    public void setDishesSelected(List<Dishes> dishesList) {

    }

    @Override
    public void saveOrder() {

    }

    @Override
    public void gotoBill(List<Dishes> dishesList) {
        Intent intent = new Intent(getContext(), BillActivity.class);
        BillActivity.setData("12", dishesList,()-> getActivity().finish());
        startActivity(intent);
    }
}
