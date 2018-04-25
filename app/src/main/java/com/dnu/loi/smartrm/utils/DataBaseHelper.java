package com.dnu.loi.smartrm.utils;

import com.dnu.loi.smartrm.common.CommonApp;
import com.dnu.loi.smartrm.common.ConstHelper;
import com.dnu.loi.smartrm.common.MyApplication;
import com.dnu.loi.smartrm.database.Dal;
import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.database.entity.BillDb;
import com.dnu.loi.smartrm.obj.Bill;
import com.dnu.loi.smartrm.obj.Dishes;
import com.dnu.loi.smartrm.obj.Order;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 22/04/2018.
 */

public final class DataBaseHelper {

    public static int getNewOrderId() {
        try {
            List<Order> orders = Dal.getInstance().query("SELECT * FROM 'order' where id in (select Max(id) from 'order')", Order.class);
            if (orders != null && orders.size() > 0)
                return orders.get(0).getId() + 1;
        } catch (DalException e) {
            ExceptionHelper.handlerException("DataBaseHelper#getNewOrderId", e);
        }
        return ConstHelper.ERROR_VALUE;
    }

    public static int getNewDishesId() {
        try {
            List<Dishes> dishes = Dal.getInstance().query("SELECT * FROM 'products' where id in (select Max(id) from 'products')", Dishes.class);
            if (dishes != null && dishes.size() > 0)
                return dishes.get(0).getId() + 1;
        } catch (DalException e) {
            ExceptionHelper.handlerException("DataBaseHelper#getNewDishesId", e);
        }
        return ConstHelper.ERROR_VALUE;
    }

    public static int getNewBillId() {
        try {
            List<BillDb> bills = Dal.getInstance().query("SELECT * FROM 'bills' where id in (select Max(id) from 'bills')", BillDb.class);
            if (bills != null && bills.size() > 0)
                return bills.get(0).getId() + 1;
        } catch (DalException e) {
            ExceptionHelper.handlerException("DataBaseHelper#getNewDishesId", e);
        }
        return ConstHelper.ERROR_VALUE;
    }

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
