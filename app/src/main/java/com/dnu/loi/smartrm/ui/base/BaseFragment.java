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

public abstract class BaseFragment extends Fragment {


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

    /**
     * Phương thức ánh xạ mView
     *
     * @param view @null
     * @Created_by TTLoi on 29/03/2018.
     */
    protected abstract void mappingView(View view);

    /**
     * Phương thức bingding mView
     *
     * @Created_by TTLoi on 15/04/2018
     */
    protected abstract void onBindView();

    /**
     *Phương thức gán sự kiện cho v
     * iew
     *@Created_by TTLoi on 15/04/2018
     */
    protected abstract void setViewEvent();

    protected abstract void onViewAttach();

    protected abstract void onViewDestroy();

}
