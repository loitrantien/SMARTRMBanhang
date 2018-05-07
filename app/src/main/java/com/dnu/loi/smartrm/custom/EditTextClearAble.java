package com.dnu.loi.smartrm.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dnu.loi.smartrm.R;

/**
 * Created by loi on 3/27/2018.
 */

public class EditTextClearAble extends LinearLayout {
    private LinearLayout root;
    private ImageView ivLeftDrawable, ivClear;
    private EditText etContent;


    public EditTextClearAble(Context context) {
        super(context);
    }

    public EditTextClearAble(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public EditTextClearAble(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    public void init(Context context, @Nullable AttributeSet attrs) {
        ViewGroup viewGroup = (ViewGroup) inflate(context, R.layout.view_edit_text_clear_able, this);
        root = (LinearLayout) viewGroup.getChildAt(0);
        ivClear = root.findViewById(R.id.ivClear);
        ivLeftDrawable = root.findViewById(R.id.ivLeftDrawable);
        etContent = root.findViewById(R.id.etContent);

        //set thuộc tính của mView từ file xml
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.EditTextClearAble, 0, 0);


        String hint = a.getString(R.styleable.EditTextClearAble_hint);
        etContent.setHint(hint);

        int leftImage = a.getResourceId(R.styleable.EditTextClearAble_leftDrawable, -1);
        if (leftImage != -1) {
            ivLeftDrawable.setVisibility(VISIBLE);
            ivLeftDrawable.setImageResource(leftImage);
        }


//        float v = a.getDimension(R.styleable.EditTextClearAble_textSize, -1);
//        if (v != -1) {
//            etContent.setTextSize(TypedValue.COMPLEX_UNIT_SP,13f);
//        }

        int background = a.getResourceId(R.styleable.EditTextClearAble_background, -1);

        if (background != -1) {
            root.setBackgroundResource(background);
        }

        a.recycle();

        root.setOnClickListener((view) -> etContent.requestFocus());

        etContent.setOnFocusChangeListener((View view, boolean b) -> ivClear.setVisibility(etContent.getText().length() > 0 && b ? VISIBLE : INVISIBLE));

        etContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ivClear.setVisibility(etContent.getText().length() > 0 ? VISIBLE : INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ivClear.setOnClickListener((view -> etContent.setText("")));
    }

    public String getText() {
        return etContent.getText().toString();
    }

    public boolean doRequestFocus() {
        return etContent.requestFocus();
    }

    public void setTextSize(float size) {
        etContent.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    public void setHint(String hint) {
        etContent.setHint(hint);
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        etContent.addTextChangedListener(textWatcher);
    }

    public void setInputType(int type) {
        etContent.setInputType(type);
    }

    public void setHint(int hint) {
        etContent.setHint(hint);
    }

    public boolean isEmpty() {
        return etContent.getText() == null || etContent.getText().toString().isEmpty();
    }
}
