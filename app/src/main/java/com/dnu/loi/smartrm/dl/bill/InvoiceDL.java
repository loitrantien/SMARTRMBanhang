package com.dnu.loi.smartrm.dl.bill;

import com.dnu.loi.smartrm.database.Dal;
import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.entity.Invoice;
import com.dnu.loi.smartrm.entity.InvoiceDetail;


/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class InvoiceDL implements IInvoiceDL {

    @Override
    public int saveInvoice(Invoice invoice) throws DalException {
        long result;

        result = Dal.getInstance().save(invoice, Invoice.class);
        for (InvoiceDetail detail : invoice.getDetails()) {
            result += Dal.getInstance().save(detail, InvoiceDetail.class);
        }

        return (int) result;
    }
}
