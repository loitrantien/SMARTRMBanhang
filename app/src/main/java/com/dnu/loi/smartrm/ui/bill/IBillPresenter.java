package com.dnu.loi.smartrm.ui.bill;

import com.dnu.loi.smartrm.obj.Bill;
import com.dnu.loi.smartrm.ui.base.IBasePresenter;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

interface IBillPresenter extends IBasePresenter<IBillView> {
    void saveBill(Bill bill);
}
