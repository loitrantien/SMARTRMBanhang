package com.dnu.loi.smartrm.bl.adddishes;

import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.dl.adddishes.IAddDishesDL;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.DishesType;

import java.util.List;

import static com.dnu.loi.smartrm.common.ConstHelper.ERROR_VALUE;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class AddDishesBL implements IAddDishesBL {

    private IAddDishesDL dl;

    public AddDishesBL(IAddDishesDL dl) {
        this.dl = dl;
    }

    @Override
    public void saveDishes(Dishes dishes, onDataLoaded<Dishes> listener) {
        try {
            long result = dl.saveDishes(dishes);
            if (result == ERROR_VALUE)
                listener.onFailed();
            else listener.onResponse(dishes);
        } catch (DalException e) {
            listener.onException(e);
        }
    }

    @Override
    public void initDishesTypeList(onDataLoaded<List<DishesType>> listener) {
        try {
            List<DishesType> dishesTypes = dl.getAllDishesType();
            if (dishesTypes == null) {
                listener.onFailed();
            } else
                listener.onResponse(dishesTypes);
        } catch (DalException e) {
            listener.onException(e);
        }
    }
}
