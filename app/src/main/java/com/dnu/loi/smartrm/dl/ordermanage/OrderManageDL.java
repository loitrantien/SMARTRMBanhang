package com.dnu.loi.smartrm.dl.ordermanage;

import com.dnu.loi.smartrm.database.Dal;
import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.obj.OrderDetail;
import com.dnu.loi.smartrm.obj.Table;

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
                return Dal.getInstance().query("select * from 'table' where id ='" + data.toString() + "'", Table.class).get(0);
            }

            if (mClass == OrderDetail.class) {
                return Dal.getInstance().query(
                        "select *, products.name as name_product from 'order_detail' inner join products on products.id = order_detail.id_product where id_order ='" + data.toString() + "'",
                        OrderDetail.class);
            }

            return null;
        }, Order.class);
    }
}
