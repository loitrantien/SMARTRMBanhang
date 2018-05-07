package com.dnu.loi.smartrm.ui.normal.login;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.login.LoginBL;

import com.dnu.loi.smartrm.custom.EditTextClearAble;
import com.dnu.loi.smartrm.custom.StatusLayout;
import com.dnu.loi.smartrm.dl.login.LoginDL;
import com.dnu.loi.smartrm.ui.base.BaseActivity;
import com.dnu.loi.smartrm.ui.normal.main.MainActivity;
import com.dnu.loi.smartrm.common.CommonApp;
import com.dnu.loi.smartrm.common.ScreenApp;
import com.dnu.loi.smartrm.utils.UIHelper;

public class LoginActivity extends BaseActivity implements View.OnClickListener, ILoginView {

    private TextView btnLogin;

    private LinearLayout llLogin;

    private EditTextClearAble etUsername, etPassword;

    private StatusLayout statusLayout;

    private ILoginPresenter presenter = new LoginPresenter(new LoginBL(new LoginDL()));

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void mappingView() {
        btnLogin = findViewById(R.id.btnLogin);
        llLogin = findViewById(R.id.llLogin);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        statusLayout = findViewById(R.id.slLogin);
    }

    @Override
    protected void onBindView() {
        etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        autoResizeLoginForm();
        presenter.onViewAttach(this);
        presenter.reLogin();
    }

    @Override
    protected void setViewEvent() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    protected void onActivityDestroy() {
        presenter.onViewDestroy();
    }

    @Override
    public void gotoMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void showReLogin() {
        statusLayout.showStatus(this,R.layout.status_re_login);
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
                if (etUsername.isEmpty()) {
                    etUsername.doRequestFocus();
                    break;
                }

                if (etPassword.isEmpty()) {
                    etPassword.doRequestFocus();
                    break;
                }

                if (UIHelper.isConnected(this)) {
                    showLoading();
                    presenter.loginOnline(etUsername.getText(), etPassword.getText());
                } else
                    showNetworkError();
                break;
        }

    }


    @Override
    public void showLoading() {
        statusLayout.showStatus(this, R.layout.status_loading);
    }

    @Override
    public void hideLoading() {
        runOnUiThread(() -> statusLayout.hiddenStatus())
        ;
    }

    @Override
    public void showNetworkError() {
        runOnUiThread(() -> UIHelper.ToastShort(getString(R.string.network_error)))
        ;
    }

    @Override
    public void showError(String message) {
        runOnUiThread(() -> UIHelper.ToastShort(message))
        ;
    }
}
