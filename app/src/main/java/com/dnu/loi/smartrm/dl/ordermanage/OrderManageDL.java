package com.dnu.loi.smartrm.dl.ordermanage;

import com.dnu.loi.smartrm.database.Dal;
import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.entity.Order;
import com.dnu.loi.smartrm.entity.OrderDetail;
import com.dnu.loi.smartrm.entity.Table;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class OrderManageDL implements IOrderManageDL {
    @Override
    public List<Order> getAllOrder() throws DalException {
        return Dal.getInstance().getAll((data, mClass) -> {

            if (mClass == Table.class) {
                return Dal.getInstance().query("select * from 'tbl_table' where id ='" + data.toString() + "'", Table.class).get(0);
            }

            if (mClass == OrderDetail.class) {
                return Dal.getInstance().query(
                        "select * from 'tbl_orderDetail' where order_id ='" + data.toString() + "'",
                        OrderDetail.class);
            }

            return null;
        }, Order.class);
    }
}
