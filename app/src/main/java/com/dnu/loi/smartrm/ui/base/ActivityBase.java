package com.dnu.loi.smartrm.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Mô tả:
 * <p>
 * Created by loi on 29/03/2018.
 */

public abstract class ActivityBase extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mappingView();
        setViewEvent();
    }

    protected abstract int getLayout();

    protected abstract void mappingView();

    protected abstract void setViewEvent();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onActivityDestroy();
    }

    protected abstract void onActivityDestroy();
}
