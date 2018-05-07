package com.dnu.loi.smartrm.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.dnu.loi.smartrm.R;

/**
 * Mô tả:
 * <p>
 * Created by loi on 06/05/2018.
 */

public abstract class BaseActivityOnlyFragment extends AppCompatActivity {

    private static Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_only_fragment);
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frContainer, fragment)
                    .commit();
        }
    }

    public static void setFrament(Fragment fragment) {
        BaseActivityOnlyFragment.fragment = fragment;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fragment = null;
    }
}
