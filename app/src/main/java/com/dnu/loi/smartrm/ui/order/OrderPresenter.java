package com.dnu.loi.smartrm.ui.order;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.order.IOrderBL;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.DishesType;
import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.ui.base.BasePresenter;
import com.dnu.loi.smartrm.ui.base.IBaseBL;
import com.dnu.loi.smartrm.utils.ExceptionHelper;
import com.dnu.loi.smartrm.utils.UIHelper;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class OrderPresenter extends BasePresenter<IOrderView> implements IOrderPresenter {

    private IOrderBL bl;

    public OrderPresenter(IOrderBL bl) {
        this.bl = bl;
    }

    @Override
    public void onViewAttach(IOrderView view) {
        mView = view;
    }

    @Override
    public void onViewDestroy() {
        mView = null;
    }

    @Override
    public void initData() {
        bl.initDishesTypeList(new IBaseBL.onDataLoaded<List<DishesType>>() {
            @Override
            public void onResponse(List<DishesType> dishesTypes) {
                getView().setDishesTypeList(dishesTypes);
                getDishesListByType(dishesTypes.get(0));
            }

            @Override
            public void onFailed() {
                getView().showError(UIHelper.getString(R.string.somthing_wrong));
            }

            @Override
            public void onException(Exception e) {
                ExceptionHelper.handlerException("initDishesTypeList",e);
            }
        });
    }

    @Override
    public void getDishesListByType(DishesType dishesType){
        bl.getDishesListByType(dishesType,new IBaseBL.onDataLoaded<List<Dishes>>() {
            @Override
            public void onResponse(List<Dishes> dishesList) {
                getView().setDishesList(dishesList);
            }

            @Override
            public void onFailed() {
                getView().showError(UIHelper.getString(R.string.somthing_wrong));
            }

            @Override
            public void onException(Exception e) {
                ExceptionHelper.handlerException("OrderPresenter#initData", e);
            }
        });
    }

    @Override
    public void saveOrder(Order order) {
        bl.saveOrder(order, new IBaseBL.onDataLoaded<Order>() {
            @Override
            public void onResponse(Order order) {
                getView().showSaveOrderSuccess();
            }

            @Override
            public void onFailed() {
                getView().showError(UIHelper.getString(R.string.somthing_wrong));
            }

            @Override
            public void onException(Exception e) {
                ExceptionHelper.handlerException("saveOrder#initData", e);
            }
        });
    }
}
