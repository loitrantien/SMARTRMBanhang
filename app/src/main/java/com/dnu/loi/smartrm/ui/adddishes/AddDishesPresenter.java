package com.dnu.loi.smartrm.ui.adddishes;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.adddishes.IAddDishesBL;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.DishesType;
import com.dnu.loi.smartrm.ui.base.BasePresenter;
import com.dnu.loi.smartrm.ui.base.IBaseBL;
import com.dnu.loi.smartrm.utils.ExceptionHelper;
import com.dnu.loi.smartrm.utils.UIHelper;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 25/04/2018.
 */

public class AddDishesPresenter extends BasePresenter<IAddDishesView> implements IAddDishesPresenter {
    private IAddDishesBL bl;

    public AddDishesPresenter(IAddDishesBL bl) {
        this.bl = bl;
    }

    @Override
    public void initDishesTypeList() {
        bl.initDishesTypeList(new IBaseBL.onDataLoaded<List<DishesType>>() {
            @Override
            public void onResponse(List<DishesType> dishesTypes) {
                getView().setDishesTypeList(dishesTypes);
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
    public void saveDishes(Dishes dishes) {
        bl.saveDishes(dishes, new IBaseBL.onDataLoaded<Dishes>() {
            @Override
            public void onResponse(Dishes dishes) {
                getView().onSaveDishesSuccess();
            }

            @Override
            public void onFailed() {
                getView().showError(UIHelper.getString(R.string.somthing_wrong));
            }

            @Override
            public void onException(Exception e) {
                ExceptionHelper.handlerException("saveDishes", e);
            }
        });
    }

    @Override
    public void onViewAttach(IAddDishesView iAddDishesView) {
        mView = iAddDishesView;
    }

    @Override
    public void onViewDestroy() {
        mView =null;
    }
}
