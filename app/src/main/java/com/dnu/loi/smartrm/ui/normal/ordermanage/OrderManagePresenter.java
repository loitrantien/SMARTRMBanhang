package com.dnu.loi.smartrm.ui.normal.ordermanage;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.ordermanage.IOrderManageBL;
import com.dnu.loi.smartrm.entity.Order;
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

public class OrderManagePresenter extends BasePresenter<IOrderManageView> implements IOrderManagePresenter {

    private IOrderManageBL bl;

    public OrderManagePresenter(IOrderManageBL bl) {
        this.bl = bl;
    }

    @Override
    public void onViewAttach(IOrderManageView view) {
        mView = view;
    }

    @Override
    public void onViewDestroy() {
        mView = null;
    }

    @Override
    public void initOrderList() {
        bl.initOrderList(new IBaseBL.onDataLoaded<List<Order>>() {
            @Override
            public void onResponse(List<Order> orders) {
                getView().setOrderList(orders);
            }

            @Override
            public void onFailed() {
                getView().showError(UIHelper.getString(R.string.somthing_wrong));
            }

            @Override
            public void onException(Exception e) {
                ExceptionHelper.handlerException("initOrderList",e);
            }
        });
    }
}
