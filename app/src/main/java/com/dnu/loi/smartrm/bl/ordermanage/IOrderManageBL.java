package com.dnu.loi.smartrm.bl.ordermanage;

import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.ui.base.IBaseBL;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface IOrderManageBL extends IBaseBL{
    void initOrderList(onDataLoaded<List<Order>> listener);
}
