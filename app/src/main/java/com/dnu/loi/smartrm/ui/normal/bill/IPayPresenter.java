package com.dnu.loi.smartrm.ui.normal.bill;

import com.dnu.loi.smartrm.entity.Invoice;
import com.dnu.loi.smartrm.ui.base.IBasePresenter;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

interface IPayPresenter extends IBasePresenter<IInvoiceView> {
    void saveInvoice(Invoice bill);
}
