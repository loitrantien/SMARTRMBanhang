package com.dnu.loi.smartrm.ui.normal.tablemap;

import com.dnu.loi.smartrm.entity.Floor;
import com.dnu.loi.smartrm.entity.Table;
import com.dnu.loi.smartrm.ui.base.IBasePresenter;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface ITableMapPresenter extends IBasePresenter<ITableMapView> {

    /**
     * Phương thức khởi tạo danh sách bàn ăn
     *
     * Created by loi on 4/18/2018
     */
    void initTableMap();


    /**
     * Phương thức lấy danh sách các bàn theo tầng
     *
     * @param floor Tầng được chọn
     * Created by loi on 4/18/2018
     */
    void loadTablesByFloor(Floor floor);

    /**
     * Phương thức lấy danh sách các bàn đã được chọn
     *
     * Created by loi on 4/18/2018
     */
    void getTableMapSelected();

    void onTableSelectedClick(Table table);
}
