package com.dnu.loi.smartrm.dl.order;

import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.entity.Dishes;
import com.dnu.loi.smartrm.entity.DishesType;
import com.dnu.loi.smartrm.entity.Order;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface IOrderDL {

    int saveOrder(Order order) throws DalException;

    List<DishesType> getAllDishesType() throws DalException;

    List<Dishes> getDishesListByType(DishesType dishesType) throws DalException;
}
