package com.dnu.loi.smartrm.dl.order;

import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.Order;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface IOrderDL {
    List<Dishes> getDishesList();

    int saveOrder(Order order);
}
