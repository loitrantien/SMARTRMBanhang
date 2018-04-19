package com.dnu.loi.smartrm.ui.tablemap;

import com.dnu.loi.smartrm.obj.Floor;
import com.dnu.loi.smartrm.obj.Table;
import com.dnu.loi.smartrm.ui.base.MVPView;

import java.util.List;

/**
 * Mô tả: interface cũng cấp các phương thức tương tác với ui
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface ITableMapView extends MVPView {

    /**
     * Phương thức load các bàn
     *
     * Created by loi on 4/18/2018
     */
    void setListTable(List<Table> tables);

    /**
     * Phương thức load các tầng
     *
     * Created by loi on 4/18/2018
     */
    void setListFloor(List<Floor> floors);

    /**
     * Phương thức tìm kiếm bàn theo tên
     *
     * @param name tên bàn
     * Created by loi on 4/18/2018
     */
    void searchTableByName(String name);

    /**
     * Phương thức tạo mới order theo bàn được chọn
     *
     * @param table bàn được chọn
     * Created by loi on 4/18/2018
     */
    void goToNewOrder(Table table);

    /**
     * Phương thức hiển thị danh sách các tầng
     *
     * Created by loi on 4/18/2018
     */
    void showListFloor();
}
