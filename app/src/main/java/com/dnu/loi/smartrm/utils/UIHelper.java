package com.dnu.loi.smartrm.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.widget.Toast;

import com.dnu.loi.smartrm.R;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Class tiện ích
 *
 * Created by loi on 3/27/2018.
 */

public final class UIHelper {

    public static void ToastShort(Context context, String data) {
        Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
    }

    public static void ToastLong(Context context, String data) {
        Toast.makeText(context, data, Toast.LENGTH_LONG).show();
    }

    public static void schedule(int DELAY, TimerTask task) {
        new Timer().schedule(task, DELAY);
    }

    public static DisplayMetrics getScreenSize(Activity activity) {

        DisplayMetrics metrics = new DisplayMetrics();
        if (activity != null) {
            activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        }
        return metrics;
    }

    public static boolean isConnected(Context context)  {
        boolean hasConnect = isNetworkAvailable(context);
//        boolean hasInternet = false;
//        if (hasConnect) {
//            try {
//                if (Runtime.getRuntime().exec("ping -c 1 8.8.8.8").waitFor() == 0) {
//                    hasInternet = true;
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return hasInternet;
//        }
        return hasConnect;
    }

    public static SpannableString setSpan(String s, int start, int end, int color) {
        SpannableString spannableString = new SpannableString(s);
        spannableString.setSpan(new ForegroundColorSpan(CommonApp.CONTEXT.getResources().getColor(color)),
                start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    private static boolean isNetworkAvailable(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return (manager.getActiveNetworkInfo() != null) && (manager.getActiveNetworkInfo().isConnected());
    }

}
