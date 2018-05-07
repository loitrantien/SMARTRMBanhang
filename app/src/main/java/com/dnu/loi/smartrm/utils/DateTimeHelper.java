package com.dnu.loi.smartrm.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

/**
 * Mô tả:
 * <p>
 * Created by loi on 16/04/2018.
 */

public final class DateTimeHelper {

    public static String getCurrentDateTime() {
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy (hh:mm aa)", Locale.ROOT);
            return dateFormat.format(c.getTime());
        } catch (Exception e) {
            ExceptionHelper.handlerException("DateTimeHelper#getCurrentDateTime", e);
        }
        return "";
    }

    public static String getBillNum() {
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-hh-mm", Locale.ROOT);
            return "HD"+dateFormat.format(c.getTime()).replace("-","")+ new Random().nextInt(1000);
        } catch (Exception e) {
            ExceptionHelper.handlerException("DateTimeHelper#getCurrentDateTime", e);
        }
        return "";
    }

    public static String getCurrentDate() {
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ROOT);
            return dateFormat.format(c.getTime());
        } catch (Exception e) {
            ExceptionHelper.handlerException("DateTimeHelper#getCurrentDateTime", e);
        }
        return "";
    }
}
