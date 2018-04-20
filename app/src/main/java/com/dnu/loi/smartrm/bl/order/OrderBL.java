package com.dnu.loi.smartrm.bl.order;

import com.dnu.loi.smartrm.common.ConstHelper;
import com.dnu.loi.smartrm.dl.order.IOrderDL;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.ui.base.IBaseBL;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class OrderBL implements IOrderBL {

    private IOrderDL dl;

    public OrderBL(IOrderDL dl) {
        this.dl = dl;
    }


    @Override
    public void initDishesList(onDataLoaded<List<Dishes>> listener) {
        List<Dishes> dishesList = null;
        try {
            dishesList = dl.getDishesList();
            if (dishesList == null)
                listener.onFailed();
            else listener.onResponse(dishesList);
        } catch (Exception e) {
            listener.onException(e);
        }
    }

    @Override
    public void saveOrder(Order order, onDataLoaded<Order> listener) {
        try {
            int result = dl.saveOrder(order);
            if (result == ConstHelper.ERROR_VALUE)
                listener.onFailed();
            else
                listener.onResponse(order);
        } catch (Exception e) {
            listener.onException(e);
        }
    }
}
