package com.dnu.loi.smartrm.ui.base;

/**
 * Mô tả: interface dùng chung cung cấp các phương thức tuqoqng tác với giao diện
 *
 * Created by loi on 29/03/2018.
 */

public interface MVPView {

    /**
     * Phương thức hiển thị thanh loading
     *
     * Created by loi on 4/7/2018
     */
    void showProgressDialog();

    /**
     * Phương thức ẩn thanh loading
     *
     * Created by loi on 4/7/2018
     */
    void hideProgressDialog();

    /**
     * Phương thức đưa ra thông báo lỗi khi không có mạng
     *
     * Created by loi on 4/7/2018
     */
    void showNetworkError();

}
