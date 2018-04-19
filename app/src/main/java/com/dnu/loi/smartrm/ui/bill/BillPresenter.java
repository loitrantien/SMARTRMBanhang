package com.dnu.loi.smartrm.ui.bill;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.bill.IBillBL;
import com.dnu.loi.smartrm.obj.Bill;
import com.dnu.loi.smartrm.ui.base.BasePresenter;
import com.dnu.loi.smartrm.ui.base.IBaseBL;
import com.dnu.loi.smartrm.utils.ExceptionHelper;
import com.dnu.loi.smartrm.utils.UIHelper;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class BillPresenter extends BasePresenter<IBillView> implements IBillPresenter {
    private IBillBL bl;

    public BillPresenter(IBillBL bl) {
        this.bl = bl;
    }

    @Override
    public void onViewAttach(IBillView view) {
        mView = view;
    }

    @Override
    public void onViewDestroy() {
        mView = null;
    }

    @Override
    public void saveBill(Bill bill) {
        bl.saveBill(bill, new IBaseBL.onDataLoaded<Bill>() {
            @Override
            public void onResponse(Bill bill) {
                getView().finish();
            }

            @Override
            public void onFailed() {
                getView().showError(UIHelper.getString(R.string.somthing_wrong));
            }

            @Override
            public void onException(Exception e) {
                ExceptionHelper.handlerException("BillPresenter#saveBill",e);
            }
        });
    }
}
