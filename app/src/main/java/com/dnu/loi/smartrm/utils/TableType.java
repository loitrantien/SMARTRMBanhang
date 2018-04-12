package com.dnu.loi.smartrm.utils;

import com.dnu.loi.smartrm.R;

/**
 * Mô tả: enum mô tả các loại bàn
 *
 * Created by loi on 04/04/2018.
 */

public enum TableType {

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

    TableType(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getImageResource(){
        return imageResource;
    }
}
