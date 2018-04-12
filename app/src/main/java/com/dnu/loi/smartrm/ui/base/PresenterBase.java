package com.dnu.loi.smartrm.ui.base;

/**
 * Mô tả:
 * <p>
 * Created by loi on 29/03/2018.
 */

public abstract class PresenterBase<View extends MVPView> {

    View view;

    public PresenterBase(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    /**
     * Phương thức thực hiện khi khởi tạo view
     *
     * Created by loi on 3/29/2018
     */
    public abstract void onViewAttach();

    /**
     * Phương thức thực hiện khi destroy view
     *
     * Created by loi on 3/29/2018
     */
    public abstract void onViewDestroy();

}
