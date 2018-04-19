package com.dnu.loi.smartrm.ui.ordermanage;

import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.ui.base.MVPView;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface IOrderManageView extends MVPView {

    void newOrder();

    void setOrderList(List<Order> orderList);

    void setMerge(List<Order> orderList);

    void splitOrder(Order order);

}
