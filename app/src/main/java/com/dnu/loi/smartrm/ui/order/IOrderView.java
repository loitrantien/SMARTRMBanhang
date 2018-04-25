package com.dnu.loi.smartrm.ui.order;

import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.DishesType;
import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.obj.OrderDetail;
import com.dnu.loi.smartrm.ui.base.MVPView;
import com.dnu.loi.smartrm.ui.dialog.ISimpleCallBack;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface IOrderView extends MVPView {

    void setDishesList(List<Dishes> dishesList);

    void setDishesSelected(List<OrderDetail> dishesList);

    void saveOrder(Order order);

    void searchDishesList(String s);

    void setDishesTypeList(List<DishesType> typeList);

    void showDishesTypeList();

    void showSaveOrderSuccess();

    void gotoBill(List<Dishes> dishesList);

    void showAddDishes();

    void showDialogInput(String title, String field, ISimpleCallBack<Double> callBack);

}
