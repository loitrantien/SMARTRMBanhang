package com.dnu.loi.smartrm.ui.dialog;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.ui.base.BaseDialog;
import com.dnu.loi.smartrm.ui.base.BaseRecyclerViewAdapter;
import com.dnu.loi.smartrm.utils.UIHelper;

/**
 * Mô tả:
 * <p>
 * Created by loi on 25/04/2018.
 */

public class SimpleListDialog<T> extends BaseDialog {

    private TextView tvTitle, tvDone;

    private RecyclerView mRecyclerView;

    private ISimpleCallBack<T> callBack;

    private String title = "";

    private BaseRecyclerViewAdapter<T, SimpleListDialog.ViewHolder> adapter;

    public void setInstance(BaseRecyclerViewAdapter<T, SimpleListDialog.ViewHolder> adapter, ISimpleCallBack<T> callBack) {
        this.callBack = callBack;
        this.adapter = adapter;
    }

    public void setTitle(String title){
        this.title = title;
    }

    @Override
    protected DisplayMetrics getDisplayMetrics() {
        DisplayMetrics metrics = new DisplayMetrics();

        int height = WindowManager.LayoutParams.WRAP_CONTENT;
        int width = UIHelper.getScreenSize(getActivity()).widthPixels;

        metrics.widthPixels = width - width / 10;
        metrics.heightPixels = height;
        return metrics;
    }

    @Override
    protected int getLayoutInflate() {
        return R.layout.dialog_list;
    }

    @Override
    protected void mappingView(View view) {
        tvTitle = findViewById(R.id.tvTitle);
        tvDone = findViewById(R.id.tvDone);
        mRecyclerView = findViewById(R.id.rcvList);
    }

    @Override
    protected void onBindView() {
        tvTitle.setText(title);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void setViewEvent() {
        tvDone.setOnClickListener(v -> {
            callBack.callback(getData());
            dismiss();
        });
    }

    private T getData() {
        return adapter.getItemSelected();
    }


    @Override
    protected void onViewAttach() {

    }

    @Override
    protected void onViewDestroy() {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivCheckBox;
        public TextView tvContent;
        public LinearLayout llContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            ivCheckBox = itemView.findViewById(R.id.ivCheckBox);
            tvContent = itemView.findViewById(R.id.tvContent);
            llContainer = itemView.findViewById(R.id.llContainer);
        }
    }
}
