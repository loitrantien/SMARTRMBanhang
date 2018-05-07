package com.dnu.loi.smartrm.utils;

import java.text.DecimalFormat;

/**
 * Mô tả:
 * <p>
 * Created by loi on 03/05/2018.
 */

public class MoneyHelper {

    public static String getMoneyFromDouble(Double money){

        DecimalFormat format = new DecimalFormat("###,###,###.00");
        String str = format.format(money).replace(",",".").trim();
        if (str.substring(str.length()-3).equals(".00")) {
            return str.substring(0,str.length()-3);
        }
        return str;
    }

}
