package com.dnu.loi.smartrm.ui.ordermanage;

import com.dnu.loi.smartrm.ui.base.BasePresenter;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class OrderManagePresenter extends BasePresenter<IOrderManageView> implements IOrderManagePresenter {


    @Override
    public void onViewAttach(IOrderManageView view) {
        mView = view;
    }

    @Override
    public void onViewDestroy() {
        mView = null;
    }
}
