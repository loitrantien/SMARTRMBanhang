package com.dnu.loi.smartrm.ui.bill;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.bill.BillBL;
import com.dnu.loi.smartrm.dl.bill.BillDL;
import com.dnu.loi.smartrm.obj.Bill;
import com.dnu.loi.smartrm.obj.BillDetail;
import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.obj.OrderDetail;
import com.dnu.loi.smartrm.ui.base.BaseFragment;
import com.dnu.loi.smartrm.utils.DataBaseHelper;
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

    private Order order;

    private BillActivity.onDoneListener listener;

    public static Fragment newInstance(Order order, BillActivity.onDoneListener listener) {
        BillFragment billFragment = new BillFragment();
        billFragment.order = order;
        billFragment.listener = listener;
        return billFragment;
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
        mAdapter = new AdapterBillDetailList(order.getDetailList());
        tvTableNum.setText(tvTableNum.getText() + order.getTable().getTableNum());
        tvDate.setText(tvDate.getText() + DateTimeHelper.getCurrentDateTime());
        tvBillNum.setText(tvBillNum.getText() + "10200" + order.getId());
        tvTotal.setText(mAdapter.getTotalPrice());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void setViewEvent() {
        btnDone.setOnClickListener((view) -> mPresenter.saveBill(getBill()));
    }

    private Bill getBill() {
        Bill bill = new Bill();
        bill.setId(DataBaseHelper.getNewBillId());
        bill.setName("10200" + bill.getId());
        bill.setDate(DateTimeHelper.getCurrentDateTime());
        bill.setTable(order.getTable());
        bill.setOrder(order);
        bill.setTotal(mAdapter.getTotalPrice());
        List<BillDetail> billDetails = new ArrayList<>();

        for (OrderDetail detail : order.getDetailList()) {
            BillDetail billDetail = new BillDetail();
            billDetail.setIdBill(bill.getId());
            billDetail.setIdDishes(detail.getDishesId());
            billDetail.setQuantity(detail.getAmount());
            billDetail.setUnitPrice(detail.getPrice());
        }

        bill.setBillDetails(billDetails);
        return bill;
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
    public void showSaveBillSuccess() {
        getActivity().finish();
        listener.onDone();
    }
}
