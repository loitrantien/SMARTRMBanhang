package com.dnu.loi.smartrm.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Mô tả:
 * <p>
 * Created by loi on 16/04/2018.
 */

public final class DateTimeHelper {

    public static String getCurrentDateTime() {
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy (hh:mm aa)", Locale.ROOT);
            return dateFormat.format(c.getTime());
        } catch (Exception e) {
            ExceptionHelper.handlerException("DateTimeHelper#getCurrentDateTime", e);
        }
        return "";
    }

}
