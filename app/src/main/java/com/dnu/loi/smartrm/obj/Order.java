package com.dnu.loi.smartrm.obj;

import com.dnu.loi.smartrm.database.DatabaseColumn;

import java.util.List;

/**
 * Mô tả: class mô tả đối tượng order
 * <p>
 * Created by loi on 07/04/2018.
 */

public class Order {
    @DatabaseColumn(columnName = "OrderId", isPrimaryKey = true)
    private String OrderId;
    @DatabaseColumn(columnName = "FloorId")
    private String FloorId;
    @DatabaseColumn(columnName = "TableId", isEnableCustom = true, classCustom = Integer.class)
    private int tableNum;
    @DatabaseColumn(columnName = "PeopleCount")
    private int peopleCount;
    @DatabaseColumn(columnName = "OrderId", isEnableCustom = true, classCustom = OrderDetail.class)
    private List<OrderDetail> detailList;
    @DatabaseColumn(columnName = "OrderPrice")
    private long orderPrice;

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getFloorId() {
        return FloorId;
    }

    public void setFloorId(String floorId) {
        FloorId = floorId;
    }

    public String getTableNum() {
        return String.valueOf(tableNum);
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public String getPeopleCount() {
        return String.valueOf(peopleCount);
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public List<OrderDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<OrderDetail> detailList) {
        this.detailList = detailList;
    }

    public String getOrderPrice() {
        return String.valueOf(orderPrice);
    }

    public void setOrderPrice(long orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getDetailListString() {
        StringBuilder c = new StringBuilder();
        for (OrderDetail detail : detailList) {
            c.append(detail+", ");
        }
        return c.toString();
    }
}
