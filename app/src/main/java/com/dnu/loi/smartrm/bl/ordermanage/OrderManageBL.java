package com.dnu.loi.smartrm.bl.ordermanage;

import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.dl.ordermanage.IOrderManageDL;
import com.dnu.loi.smartrm.obj.Order;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class OrderManageBL implements IOrderManageBL {
    private IOrderManageDL dl;

    public OrderManageBL(IOrderManageDL dl) {
        this.dl = dl;
    }

    @Override
    public void initOrderList(onDataLoaded<List<Order>> listener) {
        new Thread(() -> {
            try {
                List<Order> orders = dl.getAllOrder();
                if (orders == null) {
                    listener.onFailed();
                } else listener.onResponse(orders);
            } catch (DalException e) {
                listener.onException(e);
            }
        }).start();
    }
}
