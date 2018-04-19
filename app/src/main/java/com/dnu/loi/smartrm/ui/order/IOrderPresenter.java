package com.dnu.loi.smartrm.ui.order;

import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.ui.base.IBasePresenter;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface IOrderPresenter extends IBasePresenter<IOrderView> {
    void initDishesList();

    void saveOrder(Order order);
}
