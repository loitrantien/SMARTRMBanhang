package com.dnu.loi.smartrm.bl.bill;

import com.dnu.loi.smartrm.dl.bill.IInvoiceDL;
import com.dnu.loi.smartrm.entity.Invoice;

import static com.dnu.loi.smartrm.common.ConstHelper.ERROR_VALUE;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class InvoiceBL implements IInvoiceBL {
    private IInvoiceDL dl;

    public InvoiceBL(IInvoiceDL dl) {
        this.dl = dl;
    }

    @Override
    public void saveInvoice(Invoice bill, onDataLoaded<Invoice> listener) {
        new Thread(() -> {
            int result;
            try {
                result = dl.saveInvoice(bill);
                if (result == ERROR_VALUE)
                    listener.onFailed();
                else
                    listener.onResponse(bill);
            } catch (Exception e) {
                listener.onException(e);
            }

        }).start();
    }
}
