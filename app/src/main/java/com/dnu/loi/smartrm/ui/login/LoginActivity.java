package com.dnu.loi.smartrm.ui.login;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.custom.EditTextClearAble;
import com.dnu.loi.smartrm.ui.base.BaseActivity;
import com.dnu.loi.smartrm.ui.main.MainActivity;
import com.dnu.loi.smartrm.common.CommonApp;
import com.dnu.loi.smartrm.common.ScreenApp;
import com.dnu.loi.smartrm.utils.UIHelper;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private TextView btnLogin;

    private LinearLayout llLogin;

    private EditTextClearAble etDomain, etUsername, etPassword;

    //todo

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void mappingView() {
        btnLogin = findViewById(R.id.btnLogin);
        llLogin = findViewById(R.id.llLogin);
        etDomain = findViewById(R.id.etDomain);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
    }

    @Override
    protected void onBindView() {
        autoResizeLoginForm();
    }

    @Override
    protected void setViewEvent() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    protected void onActivityDestroy() {

    }

    private void gotoMain() {
        startActivity(new Intent(this, MainActivity.class));
    }

    /**
     * Mô tả:Phương thức tự động thay đổi kích thức của form login theo kich thước màn hình
     * <p>
     * Created by loi on 3/29/2018
     */
    private void autoResizeLoginForm() {

        int screenWidth = UIHelper.getScreenSize(this).widthPixels;

        int newWidth;
        //auto resize kích thước của form login
        if (findViewById(R.id.vCheckLarge) != null) {
            newWidth = screenWidth / 3;
            CommonApp.SCREEN = ScreenApp.Large;
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            newWidth = screenWidth - screenWidth / 10;
            CommonApp.SCREEN = ScreenApp.Normal;
        }

        FrameLayout.LayoutParams params =
                new FrameLayout.LayoutParams(newWidth,
                        FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
        llLogin.setLayoutParams(params);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnLogin:
                gotoMain();
                break;
        }

    }


}
