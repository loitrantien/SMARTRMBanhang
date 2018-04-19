package com.dnu.loi.smartrm.bl.order;

import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.ui.base.IBaseBL;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface IOrderBL extends IBaseBL {
    void initDishesList(onDataLoaded<List<Dishes>> listener);

    void saveOrder(Order order, onDataLoaded<Order> listener);
}
