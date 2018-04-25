package com.dnu.loi.smartrm.ui.order;

import android.content.Intent;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.common.OrderMode;
import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.obj.Table;
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

    private static Table table;

    private static Order order;


    public static void setInstance(Table tableNum) {
        OrderActivity.table = tableNum;
    }
    public static void setInstance(Order order) {
        OrderActivity.order = order;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_order;
    }

    @Override
    protected void mappingView() {
    }

    @Override
    protected void onBindView() {

        if (MODE == ADD_MODE)
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frContainer, OrderFragment.newInstance(table))
                    .commit();
        else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frContainer, OrderFragment.newInstance(order))
                    .commit();
        }
    }

    @Override
    protected void setViewEvent() {

    }

    @Override
    protected void onActivityDestroy() {
        MODE = null;
        table = null;
        order = null;
    }


}
