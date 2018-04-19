package com.dnu.loi.smartrm.ui.bill;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.ui.base.BaseActivity;

import java.util.List;

public class BillActivity extends BaseActivity {

    private static String tableNum;
    private static List<Dishes> dishesList;
    private static onDoneListener listener;

    public static void setData(String tableNum, List<Dishes> dishesList, onDoneListener listener) {
        BillActivity.tableNum = tableNum;
        BillActivity.dishesList = dishesList;
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
                .replace(R.id.frContainer, BillFragment.newInstance(dishesList, tableNum))
                .commit();
    }

    @Override
    protected void setViewEvent() {

    }

    @Override
    protected void onActivityDestroy() {
        dishesList = null;
        tableNum = null;
        listener = null;
    }

    @Override
    public void finish() {
        super.finish();
        listener.onDone();
    }

    public interface onDoneListener {
        void onDone();
    }

}
