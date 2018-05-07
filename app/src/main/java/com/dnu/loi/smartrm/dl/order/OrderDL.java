package com.dnu.loi.smartrm.dl.order;

import com.dnu.loi.smartrm.common.ConstHelper;
import com.dnu.loi.smartrm.database.Dal;
import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.entity.Dishes;
import com.dnu.loi.smartrm.entity.DishesType;
import com.dnu.loi.smartrm.entity.Order;
import com.dnu.loi.smartrm.entity.OrderDetail;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class OrderDL implements IOrderDL {


    @Override
    public int saveOrder(Order order) throws DalException {
        long result;
            result = Dal.getInstance().saveWithOnConflict(order, Order.class);

        for (OrderDetail detail : order.getDetails()) {
            result += Dal.getInstance().saveWithOnConflict(detail, OrderDetail.class);
        }


        return (int) result;
    }

    @Override
    public List<DishesType> getAllDishesType() throws DalException {
        return Dal.getInstance().getAll(DishesType.class);
    }

    @Override
    public List<Dishes> getDishesListByType(DishesType dishesType) throws DalException {
        if (dishesType.getId().equals(ConstHelper.GET_ALL_VALUE)) {
            return Dal.getInstance().getAll(Dishes.class);
        } else
            return Dal.getInstance().query("select * from 'tbl_dishes' where type_id = '" + dishesType.getId() + "'", Dishes.class);
    }
}
