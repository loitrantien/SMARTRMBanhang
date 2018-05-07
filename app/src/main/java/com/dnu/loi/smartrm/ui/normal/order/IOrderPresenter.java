package com.dnu.loi.smartrm.ui.normal.order;

import com.dnu.loi.smartrm.entity.DishesType;
import com.dnu.loi.smartrm.entity.Order;
import com.dnu.loi.smartrm.ui.base.IBasePresenter;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface IOrderPresenter extends IBasePresenter<IOrderView> {
    void initData();

    void getDishesListByType(DishesType dishesType);

    void saveOrder(Order order);
}
