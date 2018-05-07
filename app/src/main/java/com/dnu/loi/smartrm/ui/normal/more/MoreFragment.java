package com.dnu.loi.smartrm.ui.normal.more;

import android.support.v4.app.Fragment;
import android.view.View;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.ui.base.BaseFragment;

public class MoreFragment extends BaseFragment {

    private View.OnClickListener listener;


    @Override
    protected int getLayoutInflate() {
        return R.layout.fragment_more;
    }

    @Override
    protected void mappingView(View view) {
    }

    @Override
    protected void onBindView() {

    }

    @Override
    protected void setViewEvent() {

    }

    @Override
    protected void onViewAttach() {

    }

    @Override
    protected void onViewDestroy() {

    }

    public static Fragment newInstance(View.OnClickListener listener) {
        MoreFragment fragment = new MoreFragment();
        fragment.listener = listener;
        return fragment;
    }
}
