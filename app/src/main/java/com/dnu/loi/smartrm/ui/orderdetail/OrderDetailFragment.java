package com.dnu.loi.smartrm.ui.orderdetail;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.ui.base.BaseFragment;

/**
 * Created by tranloi247 on 14/04/2018.
 */

public class OrderDetailFragment extends BaseFragment {
    private TextView tvBillNum, tvTableNum, tvDate, tvTotal, tvMoneyPay, tvMoneyReturn;

    private RecyclerView mRecyclerView;


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
        mRecyclerView = view.findViewById(R.id.rcvDishesList);
    }

    @Override
    protected void onBindView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
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
