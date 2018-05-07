package com.dnu.loi.smartrm.common;

import com.dnu.loi.smartrm.R;

/**
 * Mô tả: enum mô tả các loại bàn
 *
 * Created by loi on 04/04/2018.
 */

public enum ETableType {

    CIRCLE_2(R.drawable.sl_circle_two),
    CIRCLE_4(R.drawable.sl_circle_four),
    CIRCLE_6(R.drawable.sl_circle_six),
    CIRCLE_8(R.drawable.sl_circle_eight),
    CIRCLE_10(R.drawable.sl_circle_ten),
    CIRCLE_12(R.drawable.sl_circle_twelve),
    SQUARE_2(R.drawable.sl_square_two),
    SQUARE_4(R.drawable.sl_square_four),
    SQUARE_6(R.drawable.sl_square_six),
    SQUARE_8(R.drawable.sl_square_eight),
    SQUARE_10(R.drawable.sl_square_ten),
    SQUARE_12(R.drawable.sl_square_twelve);

    int imageResource;

    public static ETableType getType(String s){
        switch (s){
            case "CIRCLE_2":
                return CIRCLE_2;
            case "CIRCLE_4":
                return CIRCLE_4;
            case "CIRCLE_6":
                return CIRCLE_6;
            case "CIRCLE_8":
                return CIRCLE_8;
            case "CIRCLE_10":
                return CIRCLE_10;
            case "CIRCLE_12":
                return CIRCLE_12;
            case "SQUARE_2":
                return SQUARE_2;
            case "SQUARE_4":
                return SQUARE_4;
            case "SQUARE_6":
                return SQUARE_6;
            case "SQUARE_10":
                return SQUARE_10;
            case "SQUARE_8":
                return SQUARE_8;
            case "SQUARE_12":
                return SQUARE_12;

        }
        return null;
    }

    ETableType(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getImageResource(){
        return imageResource;
    }
}
