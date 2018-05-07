package com.dnu.loi.smartrm.utils;

import com.dnu.loi.smartrm.common.CommonApp;
import com.dnu.loi.smartrm.common.MyApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Mô tả:
 * <p>
 * Created by loi on 22/04/2018.
 */

public final class DataBaseHelper {

    public static void copyAssetToDatabase() {
        String destdir = "/data/data/" + MyApplication.getInstance().getPackageName() + "/databases/";
        String destpath = destdir + CommonApp.DATABASE_NAME;
        File f1 = new File(destpath);
        if (!f1.exists()) {
            File directory = new File(destdir);
            directory.mkdir();
            try {
                InputStream inputStream = MyApplication.getInstance().getAssets().open(CommonApp.DATABASE_NAME);
                OutputStream outputStream = new FileOutputStream(destpath);
                copyDB(inputStream, outputStream);
            } catch (IOException e) {
                ExceptionHelper.handlerException("CopyDatabaseHelper#copyAssetToDatabase", e);
            }
        }
    }


    private static void copyDB(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }
}
