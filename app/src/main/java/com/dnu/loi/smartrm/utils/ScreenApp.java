package com.dnu.loi.smartrm.utils;

/**
 * enum mô tả loại và độ rộng màn hình
 *
 * @Created_by tranloi247 on 31/03/2018.
 */

public enum ScreenApp {
    Large, Normal;

    int width, height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
