package com.dnu.loi.smartrm.ui.normal.login;

import com.dnu.loi.smartrm.ui.base.IBasePresenter;

/**
 * Mô tả:
 * <p>
 * Created by loi on 03/05/2018.
 */

public interface ILoginPresenter extends IBasePresenter<ILoginView> {

    void reLogin();

    void loginOnline(String userName, String password);
}
