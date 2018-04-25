package com.dnu.loi.smartrm.bl.adddishes;

import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.DishesType;
import com.dnu.loi.smartrm.ui.base.IBaseBL;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface IAddDishesBL extends IBaseBL {
    void saveDishes(Dishes dishes, onDataLoaded<Dishes> listener);

    void initDishesTypeList(onDataLoaded<List<DishesType>> listener);
}
