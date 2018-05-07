package com.dnu.loi.smartrm.ui.normal.bill;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.bill.IInvoiceBL;
import com.dnu.loi.smartrm.entity.Invoice;
import com.dnu.loi.smartrm.ui.base.BasePresenter;
import com.dnu.loi.smartrm.ui.base.IBaseBL;
import com.dnu.loi.smartrm.utils.ExceptionHelper;
import com.dnu.loi.smartrm.utils.UIHelper;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class PayPresenter extends BasePresenter<IInvoiceView> implements IPayPresenter {
    private IInvoiceBL bl;

    public PayPresenter(IInvoiceBL bl) {
        this.bl = bl;
    }

    @Override
    public void onViewAttach(IInvoiceView view) {
        mView = view;
    }

    @Override
    public void onViewDestroy() {
        mView = null;
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        bl.saveInvoice(invoice, new IBaseBL.onDataLoaded<Invoice>() {
            @Override
            public void onResponse(Invoice bill) {
                getView().showSaveBillSuccess();
            }

            @Override
            public void onFailed() {
                getView().showError(UIHelper.getString(R.string.somthing_wrong));
            }

            @Override
            public void onException(Exception e) {
                ExceptionHelper.handlerException("PayPresenter#saveBill",e);
            }
        });
    }
}
