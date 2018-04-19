package com.dnu.loi.smartrm.ui.base;

/**
 * Mô tả:
 * <p>
 * Created by loi on 29/03/2018.
 */

public abstract class BasePresenter<View extends MVPView> {

    protected View mView;


    public View getView() {
        return mView;
    }

    public void setView(View mView) {
        this.mView = mView;
    }

}
