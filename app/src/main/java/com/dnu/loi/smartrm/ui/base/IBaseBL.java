package com.dnu.loi.smartrm.ui.base;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface IBaseBL {
    interface onDataLoaded<Data> {
        void onResponse(Data data);

        void onFailed();

        void onException(Exception e);
    }
}
