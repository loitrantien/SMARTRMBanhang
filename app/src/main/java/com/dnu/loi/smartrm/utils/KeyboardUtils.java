package com.dnu.loi.smartrm.utils;


import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class KeyboardUtils {
    public static void hideSoftKeyboard(Activity activity) {
        hideSoftKeyboard(activity, activity.getCurrentFocus());
    }

    public static void hideSoftKeyboard(Context context, View view) {
        if ((context == null) || (view == null)) {
            return;
        }
        ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void hideSoftKeyboardDelayed(Activity activity) {
        new Handler().postDelayed(() -> KeyboardUtils.hideSoftKeyboard(activity), 200L);
    }

    public static void hideSoftKeyboardDelayed(Activity activity, final View view) {
        new Handler().postDelayed(() -> KeyboardUtils.hideSoftKeyboard(activity, view), 200L);
    }

    public static void showSoftKeyboard(Context context, View view) {
        if (view == null) {
            return;
        }
        InputMethodManager manager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        view.requestFocus();
        assert manager != null;
        manager.showSoftInput(view, 0);
    }

    public static void showSoftKeyboardDelayed(Context context, View view) {
        showSoftKeyboardDelayed(context, view, 200L);
    }

    public static void showSoftKeyboardDelayed(Context context, final View view, long delay) {
        new Handler().postDelayed(() -> KeyboardUtils.showSoftKeyboard(context, view), delay);
    }
}

