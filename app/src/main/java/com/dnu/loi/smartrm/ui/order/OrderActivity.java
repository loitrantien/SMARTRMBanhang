package com.dnu.loi.smartrm.ui.order;

import android.content.Intent;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.common.OrderMode;
import com.dnu.loi.smartrm.ui.base.BaseActivity;

import java.util.List;

import static com.dnu.loi.smartrm.common.ConstHelper.ERROR_VALUE;
import static com.dnu.loi.smartrm.common.ConstHelper.ORDER_MODE;
import static com.dnu.loi.smartrm.common.OrderMode.ADD_MODE;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class OrderActivity extends BaseActivity {

    public static OrderMode MODE;

    private static String orderID;

    private static List<String> dishesIDList;

    public static void setData(List<String> dishesIDList, String orderID) {
        OrderActivity.orderID = orderID;
        OrderActivity.dishesIDList = dishesIDList;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_order;
    }

    @Override
    protected void mappingView() {
        getOrderMode();
    }

    @Override
    protected void onBindView() {

        if (MODE == ADD_MODE)
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frContainer, new OrderFragment())
                    .commit();
        else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frContainer, OrderFragment.newInstance(dishesIDList, orderID))
                    .commit();
        }
    }

    @Override
    protected void setViewEvent() {

    }

    @Override
    protected void onActivityDestroy() {
        MODE = null;
        orderID = null;
        dishesIDList = null;
    }

    private void getOrderMode() {
        Intent intent = getIntent();
        int mode = intent.getIntExtra(ORDER_MODE, ERROR_VALUE);
        MODE = OrderMode.getMode(mode);
    }
}
