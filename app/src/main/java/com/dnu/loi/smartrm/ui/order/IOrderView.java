package com.dnu.loi.smartrm.ui.order;

import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.ui.base.MVPView;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface IOrderView extends MVPView {

    void setDishesList(List<Dishes> dishesList);

    void setDishesSelected(List<Dishes> dishesList);

    void saveOrder();

    void showSaveOrderSuccess();

    void gotoBill(List<Dishes> dishesList);

}
