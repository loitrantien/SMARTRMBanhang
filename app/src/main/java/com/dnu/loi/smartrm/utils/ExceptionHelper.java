package com.dnu.loi.smartrm.utils;

import android.util.Log;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class ExceptionHelper {

    public static void handlerException(String TAG, Exception e) {
        Log.e(TAG, e.getMessage()+"");
    }
}
