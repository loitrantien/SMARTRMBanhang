package com.dnu.loi.smartrm.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Mô tả:
 * <p>
 * Created by loi on 29/03/2018.
 */

public abstract class FragmentBase extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getLayoutInflate(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mappingView(view);
        onBindView();
        setViewEvent();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onViewAttach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onViewDestroy();
    }

    protected abstract int getLayoutInflate();

    protected abstract void mappingView(View view);

    protected abstract void onBindView();

    protected abstract void setViewEvent();

    protected abstract void onViewAttach();

    protected abstract void onViewDestroy();

}
