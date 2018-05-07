package com.dnu.loi.smartrm.ui.normal.bill;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.bill.InvoiceBL;
import com.dnu.loi.smartrm.database.Dal;
import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.dl.bill.InvoiceDL;
import com.dnu.loi.smartrm.entity.Invoice;
import com.dnu.loi.smartrm.entity.InvoiceDetail;
import com.dnu.loi.smartrm.entity.Order;
import com.dnu.loi.smartrm.entity.OrderDetail;
import com.dnu.loi.smartrm.ui.base.BaseFragment;
import com.dnu.loi.smartrm.utils.DateTimeHelper;
import com.dnu.loi.smartrm.utils.MoneyHelper;
import com.dnu.loi.smartrm.utils.UIHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * màn hình chi tiết order
 * <p>
 * Created by TTLoi on 14/04/2018.
 */

public class InvoiceFragment extends BaseFragment implements IInvoiceView {
    private TextView tvBillNum, tvTableNum, tvDate, tvTotal, btnDone;

    private RecyclerView mRecyclerView;

    private AdapterBillDetailList mAdapter;

    private IPayPresenter mPresenter;

    private Order order;

    private PayActivity.onDoneListener listener;

    public static Fragment newInstance(Order order, PayActivity.onDoneListener listener) {
        InvoiceFragment billFragment = new InvoiceFragment();
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
        btnDone = view.findViewById(R.id.btnDone);
        mRecyclerView = view.findViewById(R.id.rcvDishesList);
    }

    @Override
    protected void onBindView() {
        mAdapter = new AdapterBillDetailList(order.getDetails());
        tvTableNum.setText(tvTableNum.getText() + order.getTable().getName());
        tvDate.setText(tvDate.getText() + DateTimeHelper.getCurrentDateTime());
        tvBillNum.setText(tvBillNum.getText() + DateTimeHelper.getBillNum());
        tvTotal.setText(MoneyHelper.getMoneyFromDouble(mAdapter.getTotalPrice()));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void setViewEvent() {
        btnDone.setOnClickListener((view) -> mPresenter.saveInvoice(getInvoice()));
    }

    private Invoice getInvoice() {
        Invoice bill = new Invoice();
        bill.setId(UUID.randomUUID().toString());
        bill.setCode(tvBillNum.getText().toString());
        bill.setDate(DateTimeHelper.getCurrentDate());
        bill.setTable(order.getTable());
        bill.setTableId(order.getTableId());
        bill.setTotal(mAdapter.getTotalPrice());
        bill.setTimeIn(order.getCreateDate());
        bill.setTimeOut(DateTimeHelper.getCurrentDateTime());
        List<InvoiceDetail> billDetails = new ArrayList<>();

        for (OrderDetail detail : order.getDetails()) {
            InvoiceDetail billDetail = new InvoiceDetail();
            billDetail.setInvoiceId(bill.getId());
            billDetail.setName(detail.getName());
            billDetail.setAmount(detail.getAmount());
            billDetail.setPrice(detail.getPrice());
        }

        bill.setDetails(billDetails);
        return bill;
    }

    @Override
    protected void onViewAttach() {
        mPresenter = new PayPresenter(new InvoiceBL(new InvoiceDL()));
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

    }


    @Override
    public void showError(String message) {
        UIHelper.ToastShort(message);
    }

    @Override
    public void showSaveBillSuccess() {
        try {
            Dal.getInstance().delete(order,Order.class);
        } catch (DalException e) {
            e.printStackTrace();
        }
        getActivity().finish();
        listener.onDone();
    }
}
