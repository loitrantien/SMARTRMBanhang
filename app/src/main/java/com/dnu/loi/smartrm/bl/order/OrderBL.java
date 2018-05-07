package com.dnu.loi.smartrm.bl.order;

import com.dnu.loi.smartrm.common.ConstHelper;
import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.dl.order.IOrderDL;
import com.dnu.loi.smartrm.entity.Dishes;
import com.dnu.loi.smartrm.entity.DishesType;
import com.dnu.loi.smartrm.entity.Order;

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
    public void getDishesListByType(DishesType dishesType, onDataLoaded<List<Dishes>> listener) {
        new Thread(() -> {
            List<Dishes> dishesList;
            try {
                dishesList = dl.getDishesListByType(dishesType);
                if (dishesList == null)
                    listener.onFailed();
                else listener.onResponse(dishesList);
            } catch (Exception e) {
                listener.onException(e);
            }
        }).start();
    }

    @Override
    public void initDishesTypeList(onDataLoaded<List<DishesType>> listener) {
        new Thread(() -> {
            try {
                List<DishesType> temp = dl.getAllDishesType();
                if (temp == null) {
                    listener.onFailed();
                } else {
                    listener.onResponse(temp);
                }
            } catch (DalException e) {
                listener.onException(e);
            }
        }).start();
    }

    @Override
    public void saveOrder(Order order, onDataLoaded<Order> listener) {
        new Thread(() -> {
            try {
                int result = dl.saveOrder(order);
                if (result == ConstHelper.ERROR_VALUE)
                    listener.onFailed();
                else
                    listener.onResponse(order);
            } catch (Exception e) {
                listener.onException(e);
            }
        }).start();
    }
}
