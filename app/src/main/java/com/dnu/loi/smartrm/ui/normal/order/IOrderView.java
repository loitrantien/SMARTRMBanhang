package com.dnu.loi.smartrm.ui.normal.order;

import com.dnu.loi.smartrm.entity.Dishes;
import com.dnu.loi.smartrm.entity.DishesType;
import com.dnu.loi.smartrm.entity.Order;
import com.dnu.loi.smartrm.entity.OrderDetail;
import com.dnu.loi.smartrm.ui.base.MVPView;
import com.dnu.loi.smartrm.ui.normal.dialog.ISimpleCallBack;

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

    void gotoPay();

    void showAddDishes();

    void showDialogInput(String title, String field, ISimpleCallBack<Double> callBack);

}
