package com.dnu.loi.smartrm.bl.login;

import com.dnu.loi.smartrm.entity.User;
import com.dnu.loi.smartrm.ui.base.IBaseBL;

/**
 * Mô tả:
 * <p>
 * Created by loi on 03/05/2018.
 */

public interface ILoginBL extends IBaseBL {
    void callServiceLogin(User user, onDataLoaded<User> listener);

}
