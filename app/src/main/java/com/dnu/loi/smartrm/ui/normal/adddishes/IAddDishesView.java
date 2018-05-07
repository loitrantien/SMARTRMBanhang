package com.dnu.loi.smartrm.ui.normal.adddishes;

import com.dnu.loi.smartrm.entity.Dishes;
import com.dnu.loi.smartrm.entity.DishesType;
import com.dnu.loi.smartrm.ui.base.MVPView;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 25/04/2018.
 */

public interface IAddDishesView extends MVPView {

    void setDishesTypeList(List<DishesType> typeList);

    void showDishesTypeList();

    Dishes getDishes();

    void onSaveDishesSuccess();

    interface onSaveDishesSuccess {
        void onSuccess(Dishes dishes);
    }
}
