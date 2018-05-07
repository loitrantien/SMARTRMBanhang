package com.dnu.loi.smartrm.dl.bill;

import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.entity.Invoice;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface IInvoiceDL {
    int saveInvoice(Invoice invoice) throws DalException;
}
