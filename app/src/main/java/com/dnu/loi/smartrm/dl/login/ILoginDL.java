package com.dnu.loi.smartrm.dl.login;
import com.dnu.loi.smartrm.entity.User;

import retrofit2.Callback;

/**
 * Mô tả:
 * <p>
 * Created by loi on 03/05/2018.
 */

public interface ILoginDL {
    void loginOnline(User user, Callback<User> callback);
}
