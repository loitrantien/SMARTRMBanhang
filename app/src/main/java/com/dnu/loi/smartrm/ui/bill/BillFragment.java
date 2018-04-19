package com.dnu.loi.smartrm.ui.bill;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.bill.BillBL;
import com.dnu.loi.smartrm.dl.bill.BillDL;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.ui.base.BaseFragment;
import com.dnu.loi.smartrm.utils.DateTimeHelper;
import com.dnu.loi.smartrm.utils.UIHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * màn hình chi tiết order
 * <p>
 * Created by TTLoi on 14/04/2018.
 */

public class BillFragment extends BaseFragment implements IBillView {
    private TextView tvBillNum, tvTableNum, tvDate, tvTotal, tvMoneyPay, tvMoneyReturn, btnDone;

    private RecyclerView mRecyclerView;

    private AdapterBillDetailList mAdapter;

    private IBillPresenter mPresenter;

    private List<Dishes> dishesList = new ArrayList<>();

    private String tableNum;

    public static BillFragment newInstance(List<Dishes> dishesList, String tableNum) {
        BillFragment fragment = new BillFragment();
        fragment.dishesList = dishesList;
        fragment.tableNum = tableNum;

        return fragment;
    }


    @Override
    protected int getLayoutInflate() {
        return R.layout.fragment_order_detail;
    }

    @Override
    protected void mappingView(View view) {
        tvBillNum = view.findViewById(R.id.tvBillNum);
        tvDate = view.findViewById(R.id.tvBillDate);
        tvTableNum = view.findViewById(R.id.tvTableNum);
        tvTotal = view.findViewById(R.id.tvTotal);
        tvMoneyPay = view.findViewById(R.id.tvMoneyPay);
        tvMoneyReturn = view.findViewById(R.id.tvMoneyReturn);
        btnDone = view.findViewById(R.id.btnDone);
        mRecyclerView = view.findViewById(R.id.rcvDishesList);
    }

    @Override
    protected void onBindView() {
        mAdapter = new AdapterBillDetailList(dishesList);
        tvTableNum.setText(tvTableNum.getText() + tableNum);
        tvDate.setText(tvDate.getText() + DateTimeHelper.getCurrentDateTime());
        tvBillNum.setText(tvBillNum.getText() + "1020072");
        tvTotal.setText(mAdapter.getTotalPrice());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void setViewEvent() {
        btnDone.setOnClickListener((view) -> getActivity().finish());
    }

    @Override
    protected void onViewAttach() {
        mPresenter = new BillPresenter(new BillBL(new BillDL()));
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
    public void finish() {
        getActivity().finish();
    }
}
