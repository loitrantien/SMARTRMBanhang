package com.dnu.loi.smartrm.bl.bill;

import com.dnu.loi.smartrm.obj.Bill;
import com.dnu.loi.smartrm.ui.base.IBaseBL;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface IBillBL extends IBaseBL {
    void saveBill(Bill bill, onDataLoaded<Bill> listener);
}
