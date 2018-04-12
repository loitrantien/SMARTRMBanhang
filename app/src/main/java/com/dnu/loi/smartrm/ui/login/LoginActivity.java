package com.dnu.loi.smartrm.ui.login;

import android.content.Intent;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.custom.EditTextClearAble;
import com.dnu.loi.smartrm.ui.base.BaseActivity;
import com.dnu.loi.smartrm.ui.main.MainActivity;
import com.dnu.loi.smartrm.utils.CommonApp;
import com.dnu.loi.smartrm.utils.ScreenApp;
import com.dnu.loi.smartrm.utils.UIHelper;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private TextView btnLogin, btnConnectOnline, btnConnectOffline;

    private LinearLayout llLoging;

    private EditTextClearAble etDomain, etUsername, etPassword;

    //todo

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void mappingView() {
        btnLogin = findViewById(R.id.btnLogin);
        llLoging = findViewById(R.id.llLogin);
        btnConnectOnline = findViewById(R.id.tvConnectOnline);
        btnConnectOffline = findViewById(R.id.tvConnectOffline);
        btnConnectOnline.setSelected(true);
        etDomain = findViewById(R.id.etDomain);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        autoResizeLoginForm();
    }

    @Override
    protected void setViewEvent() {
        btnLogin.setOnClickListener(this);
        btnConnectOnline.setOnClickListener(this);
        btnConnectOffline.setOnClickListener(this);
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
        } else {
            newWidth = screenWidth - screenWidth / 10;
            CommonApp.SCREEN = ScreenApp.Normal;
        }

        FrameLayout.LayoutParams params =
                new FrameLayout.LayoutParams(newWidth,
                        FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
        llLoging.setLayoutParams(params);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.btnLogin:
                gotoMain();
                break;
            case R.id.tvConnectOnline:
                btnConnectOnline.setSelected(true);
                btnConnectOffline.setSelected(false);
                btnConnectOnline.setTextColor(btnConnectOnline.isSelected()
                        ? getResources().getColor(R.color.colorPrimary) : getResources().getColor(R.color.colorWhite));
                btnConnectOffline.setTextColor(btnConnectOffline.isSelected()
                        ? getResources().getColor(R.color.colorPrimary) : getResources().getColor(R.color.colorWhite));
                btnConnectOnline.setTypeface(btnConnectOnline.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
                btnConnectOffline.setTypeface(btnConnectOffline.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
                etDomain.setHint(btnConnectOnline.isSelected() ? R.string.domain_online : R.string.domain_offline);


                break;
            case R.id.tvConnectOffline:
                btnConnectOffline.setSelected(true);
                btnConnectOnline.setSelected(false);
                btnConnectOffline.setTextColor(btnConnectOffline.isSelected()
                        ? getResources().getColor(R.color.colorPrimary) : getResources().getColor(R.color.colorWhite));
                btnConnectOnline.setTextColor(btnConnectOnline.isSelected()
                        ? getResources().getColor(R.color.colorPrimary) : getResources().getColor(R.color.colorWhite));
                btnConnectOffline.setTypeface(btnConnectOffline.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
                btnConnectOnline.setTypeface(btnConnectOnline.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
                etDomain.setHint(btnConnectOffline.isSelected() ? R.string.domain_offline : R.string.domain_online);

                break;
        }

    }


}
