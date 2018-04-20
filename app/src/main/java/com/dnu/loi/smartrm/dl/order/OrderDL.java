package com.dnu.loi.smartrm.dl.order;

import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class OrderDL implements IOrderDL {
    @Override
    public List<Dishes> getDishesList() {
        List<Dishes> dishesList = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            Dishes dishes = new Dishes();
            dishes.setName("Sườn xào chua ngọt");
            dishes.setPrice("89000");
            dishesList.add(dishes);
        }
        return dishesList;
    }

    @Override
    public int saveOrder(Order order) {
        return 0;
    }
}
