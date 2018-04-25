package com.dnu.loi.smartrm.dl.bill;

import com.dnu.loi.smartrm.common.OrderMode;
import com.dnu.loi.smartrm.database.Dal;
import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.database.entity.BillDb;
import com.dnu.loi.smartrm.obj.Bill;
import com.dnu.loi.smartrm.obj.BillDetail;
import com.dnu.loi.smartrm.obj.Order;
import com.dnu.loi.smartrm.ui.order.OrderActivity;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class BillDL implements IBillDL {

    @Override
    public int saveBill(Bill bill) throws DalException {
        BillDb billDb = bill.getDbObject();

        long result;

        result = Dal.getInstance().save(billDb, BillDb.class);
        for (BillDetail detail : bill.getBillDetails()) {
            result += Dal.getInstance().save(detail, BillDetail.class);
        }
        if (OrderActivity.MODE == OrderMode.EDIT_MODE) {

            result += Dal.getInstance().delete(bill.getOrder(), Order.class);
        }

        return (int) result;
    }
}
