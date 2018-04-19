package com.dnu.loi.smartrm.ui.base;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface IBasePresenter<View> {
    /**
     * Phương thức thực hiện khi khởi tạo mView
     * <p>
     * Created by loi on 3/29/2018
     */
     void onViewAttach(View view);

    /**
     * Phương thức thực hiện khi destroy mView
     * <p>
     * Created by loi on 3/29/2018
     */
     void onViewDestroy();
}
