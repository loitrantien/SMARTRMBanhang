package com.dnu.loi.smartrm.ui.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.dnu.loi.smartrm.utils.UIHelper;

/**
 * Mô tả:
 * <p>
 * Created by loi on 23/04/2018.
 */

public abstract class BaseDialog extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = super.onCreateDialog(savedInstanceState);
        try {
            if (dialog.getWindow() != null) {
                dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            }
            dialog.setCanceledOnTouchOutside(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        try {

            DisplayMetrics metrics = getDisplayMetrics();
            getDialog().getWindow().setLayout(metrics.widthPixels, metrics.heightPixels);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    protected DisplayMetrics getDisplayMetrics() {
        return UIHelper.getScreenSize(getActivity());
    }

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
     * Phương thức gán sự kiện cho v
     * iew
     *
     * @Created_by TTLoi on 15/04/2018
     */
    protected abstract void setViewEvent();

    protected abstract void onViewAttach();

    protected abstract void onViewDestroy();

    protected void runOnUiThread(Runnable action) {
        getActivity().runOnUiThread(action);
    }

    protected <T extends View> T findViewById(@IdRes int id) {
        if (getView() != null) {
            return getView().findViewById(id);
        }
        return null;
    }

}
