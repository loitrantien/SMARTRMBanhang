package com.dnu.loi.smartrm.ui.bill;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.ui.base.BaseActivity;

import java.util.List;

public class BillActivity extends BaseActivity {

    private static Order order;
    private static onDoneListener listener;



    public static void setData(Order order, onDoneListener listener) {
        BillActivity.order = order;
        BillActivity.listener = listener;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_bill;
    }

    @Override
    protected void mappingView() {

    }

    @Override
    protected void onBindView() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frContainer, BillFragment.newInstance(order,listener))
                .commit();
    }

    @Override
    protected void setViewEvent() {

    }

    @Override
    protected void onActivityDestroy() {
        listener = null;
    }

    public interface onDoneListener {
        void onDone();
    }

}
