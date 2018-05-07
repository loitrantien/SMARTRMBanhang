package com.dnu.loi.smartrm.ui.normal.dialog;


import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.ui.base.BaseDialog;
import com.dnu.loi.smartrm.utils.UIHelper;

/**
 * Mô tả:
 * <p>
 * Created by loi on 25/04/2018.
 */

public class InputNumberDialog extends BaseDialog {

    private TextView tvTitle, tvField, tvDone;

    private EditText etContent;

    private ISimpleCallBack<Double> callBack;

    private String title, field;

    public static InputNumberDialog newInstance(String title, String field, ISimpleCallBack<Double> callBack) {

        InputNumberDialog fragment = new InputNumberDialog();
        fragment.title = title;
        fragment.field = field;
        fragment.callBack = callBack;
        return fragment;
    }

    @Override
    protected int getLayoutInflate() {
        return R.layout.dialog_input_number;
    }

    @Override
    protected DisplayMetrics getDisplayMetrics() {
        DisplayMetrics metrics = new DisplayMetrics();

        int height = WindowManager.LayoutParams.WRAP_CONTENT;
        int width = UIHelper.getScreenSize(getActivity()).widthPixels;

        metrics.widthPixels = width - width / 8;
        metrics.heightPixels = height;
        return metrics;
    }

    @Override
    protected void mappingView(View view) {
        tvDone = findViewById(R.id.tvDone);
        tvTitle = findViewById(R.id.tvTitle);
        tvField = findViewById(R.id.tvField);
        etContent = findViewById(R.id.etContent);
    }

    @Override
    protected void onBindView() {
        tvTitle.setText(title);
        tvField.setText(field);
    }

    @Override
    protected void setViewEvent() {
        tvDone.setOnClickListener(v -> {
            callBack.callback(Double.valueOf(etContent.getText().toString().isEmpty() ? "0" : etContent.getText().toString()));
            dismiss();
        });
    }

    @Override
    protected void onViewAttach() {

    }

    @Override
    protected void onViewDestroy() {

    }
}
