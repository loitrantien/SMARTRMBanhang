package com.dnu.loi.smartrm.bl.bill;

import com.dnu.loi.smartrm.dl.bill.IBillDL;
import com.dnu.loi.smartrm.obj.Bill;

import static com.dnu.loi.smartrm.common.ConstHelper.ERROR_VALUE;
import static com.dnu.loi.smartrm.common.ConstHelper.SUCCESS_VALUE;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class BillBL implements IBillBL {
    private IBillDL dl;

    public BillBL(IBillDL dl) {
        this.dl = dl;
    }

    @Override
    public void saveBill(Bill bill, onDataLoaded<Bill> listener) {
        new Thread(() -> {
            int result;
            try {
                result = dl.saveBill(bill);
                if (result == SUCCESS_VALUE)
                    listener.onResponse(bill);
                if (result == ERROR_VALUE)
                    listener.onFailed();

            } catch (Exception e) {
                listener.onException(e);
            }

        }).start();
    }
}
