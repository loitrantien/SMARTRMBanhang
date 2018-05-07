package com.dnu.loi.smartrm.custom;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.dnu.loi.smartrm.utils.ExceptionHelper;

/**
 * Mô tả:
 * <p>
 * Created by loi on 03/05/2018.
 */

public class StatusLayout extends ConstraintLayout {

    private RelativeLayout relativeLayout;

    private View status;

    private LayoutInflater layoutInflater;

    public StatusLayout(Context context) {
        super(context);
        layoutInflater = LayoutInflater.from(context);
        initView();
    }

    public StatusLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        layoutInflater = LayoutInflater.from(context);
        initView();
    }

    public StatusLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        layoutInflater = LayoutInflater.from(context);
        initView();
    }

    private void initView() {
        relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        relativeLayout.setBackgroundColor(Color.TRANSPARENT);
        relativeLayout.setOnClickListener((v)->{});
        this.addView(relativeLayout);
        hiddenStatus();
    }

    private void initStatus(Activity activity, int layoutResource) {
        activity.runOnUiThread(() -> {
            removeAllStatus();
            try {
                status = layoutInflater.inflate(layoutResource, relativeLayout,false);
                status.setLayoutParams(new ViewGroup.LayoutParams(relativeLayout.getLayoutParams().width, relativeLayout.getLayoutParams().height));
                relativeLayout.addView(status);
            }catch (Exception e){
                ExceptionHelper.handlerException("StatusLayout#initStatus",e);
            }
        });
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }


    public View getStatus() {
        return status;
    }

    public void showStatus(Activity activity, int layoutResource) {
        if (relativeLayout != null) {
            relativeLayout.setVisibility(VISIBLE);
            initStatus(activity, layoutResource);
        }
    }

    public void hiddenStatus() {
        if (relativeLayout != null) {
            relativeLayout.setVisibility(GONE);
        }
    }

    private void removeAllStatus() {
        if (relativeLayout != null && relativeLayout.getChildCount() > 0) {
            relativeLayout.removeAllViews();
            hiddenStatus();
        }
    }
}
