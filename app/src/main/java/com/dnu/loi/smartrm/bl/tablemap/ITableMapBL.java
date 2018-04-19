package com.dnu.loi.smartrm.bl.tablemap;

import com.dnu.loi.smartrm.obj.Floor;
import com.dnu.loi.smartrm.obj.Table;
import com.dnu.loi.smartrm.ui.base.IBaseBL;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface ITableMapBL extends IBaseBL {
    /**
     * Phương thức khởi tạo danh sách bàn ăn
     * <p>
     * Created by loi on 4/18/2018
     */
    void initTableMap(onDataLoaded<List<Table>> listener);

    /**
     * Phương thức load tất cả các tầng
     * <p>
     * Created by loi on 4/18/2018
     */
    void loadAllFloor(onDataLoaded<List<Floor>> listener);

    /**
     * Phương thức lấy danh sách các bàn theo tầng
     *
     * @param floor Tầng được chọn
     *
     * Created by loi on 4/18/2018
     */
    void loadTablesByFloor(Floor floor,onDataLoaded<List<Table>> listener);

}
