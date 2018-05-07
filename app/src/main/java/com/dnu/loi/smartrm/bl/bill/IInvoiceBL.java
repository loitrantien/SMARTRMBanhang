package com.dnu.loi.smartrm.bl.bill;

import com.dnu.loi.smartrm.entity.Invoice;
import com.dnu.loi.smartrm.ui.base.IBaseBL;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface IInvoiceBL extends IBaseBL {
    void saveInvoice(Invoice bill, onDataLoaded<Invoice> listener);
}
