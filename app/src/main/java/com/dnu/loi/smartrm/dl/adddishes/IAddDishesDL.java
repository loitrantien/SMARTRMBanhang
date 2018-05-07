package com.dnu.loi.smartrm.dl.adddishes;

import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.entity.Dishes;
import com.dnu.loi.smartrm.entity.DishesType;
import com.dnu.loi.smartrm.ui.base.IBaseBL;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface IAddDishesDL extends IBaseBL {
    long saveDishes(Dishes dishes) throws DalException;

    List<DishesType> getAllDishesType() throws DalException;
}
