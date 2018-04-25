package com.dnu.loi.smartrm.ui.adddishes;

import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.ui.base.IBasePresenter;

/**
 * Mô tả:
 * <p>
 * Created by loi on 25/04/2018.
 */

public interface IAddDishesPresenter extends IBasePresenter<IAddDishesView> {
    void initDishesTypeList();

    void saveDishes(Dishes dishes);
}
