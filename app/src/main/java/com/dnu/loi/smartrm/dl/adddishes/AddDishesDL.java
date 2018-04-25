package com.dnu.loi.smartrm.dl.adddishes;

import com.dnu.loi.smartrm.database.Dal;
import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.DishesType;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class AddDishesDL implements IAddDishesDL {

    @Override
    public long saveDishes(Dishes dishes) throws DalException {
        return Dal.getInstance().save(dishes,Dishes.class);
    }

    @Override
    public List<DishesType> getAllDishesType() throws DalException {
        return Dal.getInstance().getAll(DishesType.class);
    }
}
