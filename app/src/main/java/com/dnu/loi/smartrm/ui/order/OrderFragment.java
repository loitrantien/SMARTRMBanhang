package com.dnu.loi.smartrm.ui.order;

import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.ui.base.FragmentBase;
import com.dnu.loi.smartrm.ui.orderdetail.OrderDetailFragment;
import com.dnu.loi.smartrm.ui.ordermanage.OrderManageFragment;


public class OrderFragment extends FragmentBase implements View.OnClickListener {

    private TextView tvOrderManage, tvOrderDetail;

    private FloatingActionButton fabAddOrder;

    @Override
    protected int getLayoutInflate() {
        return R.layout.fragment_order;
    }

    @Override
    protected void mappingView(View view) {
        tvOrderDetail = view.findViewById(R.id.tvOrder);
        tvOrderManage = view.findViewById(R.id.tvOrderManage);
        fabAddOrder = view.findViewById(R.id.fabAddOrder);
    }

    @Override
    protected void onBindView() {
        tvOrderManage.setSelected(true);
        switchContent(new OrderManageFragment());
    }

    @Override
    protected void setViewEvent() {
        tvOrderManage.setOnClickListener(this);
        tvOrderDetail.setOnClickListener(this);
        fabAddOrder.setOnClickListener(this);
    }

    @Override
    protected void onViewAttach() {

    }

    @Override
    protected void onViewDestroy() {

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            //todo
            case R.id.fabAddOrder:
                break;
            case R.id.tvOrderManage:
                switchState(true);
                break;
            case R.id.tvOrder:
                switchState(false);
                break;
        }
    }

    private void switchState(boolean isOrderManage) {
        tvOrderManage.setSelected(isOrderManage);
        tvOrderManage.setTypeface(isOrderManage ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        tvOrderDetail.setSelected(!isOrderManage);
        tvOrderDetail.setTypeface(isOrderManage ? Typeface.DEFAULT : Typeface.DEFAULT_BOLD);
        Fragment fragment;
        if (isOrderManage) {
            fragment = new OrderManageFragment();
        } else {
            fragment = new OrderDetailFragment();
        }
        switchContent(fragment);
    }

    private void switchContent(Fragment fragment) {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.frOrderContent, fragment, fragment.getTag())
                .commit();
    }
}
