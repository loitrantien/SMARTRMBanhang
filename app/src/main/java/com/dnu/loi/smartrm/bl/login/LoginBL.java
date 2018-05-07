package com.dnu.loi.smartrm.bl.login;

import android.support.annotation.NonNull;

import com.dnu.loi.smartrm.common.ConstHelper;

import com.dnu.loi.smartrm.dl.login.ILoginDL;
import com.dnu.loi.smartrm.entity.User;
import com.dnu.loi.smartrm.pref.ApplicationCache;
import com.dnu.loi.smartrm.service.SynchronizeController;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Mô tả:
 * <p>
 * Created by loi on 03/05/2018.
 */

public class LoginBL implements ILoginBL {
    private ILoginDL dl;

    public LoginBL(ILoginDL dl) {
        this.dl = dl;
    }

    @Override
    public void callServiceLogin(User user, onDataLoaded<User> listener) {
        try {
            new Thread(() -> {
                try {
                    Thread.sleep(500);
                    dl.loginOnline(user, new Callback<User>() {
                        @Override
                        public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                            if (response.isSuccessful()) {
                                //cache lại user gần nhất
                                ApplicationCache.getInstance().putString(ConstHelper.PREF_IS_USER, new Gson().toJson(response.body()));
                                SynchronizeController.getInstance().startDownloadQueue(() -> listener.onResponse(user));
                            } else
                                listener.onFailed();
                        }

                        @Override
                        public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                            listener.onFailed();
                        }
                    });


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        } catch (Exception e) {
            listener.onException(e);
        }
    }
}
