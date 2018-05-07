package com.dnu.loi.smartrm.ui.normal.login;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.login.ILoginBL;
import com.dnu.loi.smartrm.common.CommonApp;
import com.dnu.loi.smartrm.common.ConstHelper;
import com.dnu.loi.smartrm.entity.User;
import com.dnu.loi.smartrm.pref.ApplicationCache;
import com.dnu.loi.smartrm.ui.base.BasePresenter;
import com.dnu.loi.smartrm.ui.base.IBaseBL;
import com.dnu.loi.smartrm.utils.UIHelper;
import com.google.gson.Gson;

/**
 * Mô tả:
 * <p>
 * Created by loi on 03/05/2018.
 */

public class LoginPresenter extends BasePresenter<ILoginView> implements ILoginPresenter {

    private ILoginBL bl;

    public LoginPresenter(ILoginBL bl) {
        this.bl = bl;
    }

    @Override
    public void onViewAttach(ILoginView iLoginView) {
        mView = iLoginView;
    }

    @Override
    public void onViewDestroy() {
        bl = null;
    }


    @Override
    public void reLogin() {
        getView().showReLogin();
        if (ApplicationCache.getInstance().contains(ConstHelper.PREF_IS_USER)) {
            User user = new Gson().fromJson(ApplicationCache.getInstance().getString(ConstHelper.PREF_IS_USER), User.class);
            loginOnline(user.getUserName(), user.getPassword());
        } else
            getView().hideLoading();
    }

    @Override
    public void loginOnline(String userName, String password) {
        User user = new User(userName, password);

        bl.callServiceLogin(user, new IBaseBL.onDataLoaded<User>() {
            @Override
            public void onResponse(User user) {
                CommonApp.USER_CACHE = user;
                getView().gotoMain();
                getView().hideLoading();
            }

            @Override
            public void onFailed() {
                getView().showError(UIHelper.getString(R.string.login_fail));
                getView().hideLoading();
            }

            @Override
            public void onException(Exception e) {
                getView().showError(UIHelper.getString(R.string.somthing_wrong));
                getView().hideLoading();
            }
        });
    }
}
