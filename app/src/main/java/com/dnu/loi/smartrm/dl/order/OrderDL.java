package com.dnu.loi.smartrm.dl.order;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.common.ConstHelper;
import com.dnu.loi.smartrm.common.OrderMode;
import com.dnu.loi.smartrm.database.Dal;
import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.database.entity.OrderDb;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.DishesType;
import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.obj.OrderDetail;
import com.dnu.loi.smartrm.ui.order.OrderActivity;
import com.dnu.loi.smartrm.utils.UIHelper;

import java.util.ArrayList;
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
        if (OrderActivity.MODE == OrderMode.ADD_MODE)
            result = Dal.getInstance().save(order.getDbObject(), OrderDb.class);
        else
            result = Dal.getInstance().update(order.getDbObject(), OrderDb.class);

        for (OrderDetail detail : order.getDetailList()) {
            result += Dal.getInstance().save(detail, OrderDetail.class);
        }


        return (int) result;
    }

    @Override
    public List<DishesType> getAllDishesType() throws DalException {
        return Dal.getInstance().getAll(DishesType.class);
    }

    @Override
    public List<Dishes> getDishesListByType(DishesType dishesType) throws DalException {
        if (dishesType.getId() == ConstHelper.GET_ALL_VALUE) {
            return Dal.getInstance().getAll(Dishes.class);
        }
        return Dal.getInstance().query("select * from products where id_type = '" + dishesType.getId() + "'", Dishes.class);
    }
}
