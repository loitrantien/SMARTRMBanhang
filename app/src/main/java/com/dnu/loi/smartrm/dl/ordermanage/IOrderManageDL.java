package com.dnu.loi.smartrm.dl.ordermanage;

import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.entity.Order;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface IOrderManageDL {
    List<Order> getAllOrder() throws DalException;
}
