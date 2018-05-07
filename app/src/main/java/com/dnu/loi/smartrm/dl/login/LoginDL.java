package com.dnu.loi.smartrm.dl.login;


import com.dnu.loi.smartrm.entity.User;

import com.dnu.loi.smartrm.service.ApiUtils;

import retrofit2.Callback;

/**
 * Mô tả:
 * <p>
 * Created by loi on 03/05/2018.
 */

public class LoginDL implements ILoginDL {

    @Override
    public void loginOnline(User user, Callback<User> callback) {
        ApiUtils.getAPIService().login(user).enqueue(callback);
    }
}
