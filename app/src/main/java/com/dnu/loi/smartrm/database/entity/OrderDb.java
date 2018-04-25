package com.dnu.loi.smartrm.database.entity;

import com.dnu.loi.smartrm.database.DatabaseColumn;
import com.dnu.loi.smartrm.database.DatabaseTable;

/**
 * Mô tả:
 * <p>
 * Created by loi on 26/04/2018.
 */
@DatabaseTable(TableName = "order")

public class OrderDb {
    @DatabaseColumn(columnName = "id", isPrimaryKey = true)
    private Integer OrderId;
    @DatabaseColumn(columnName = "id_table")
    private int table;
    @DatabaseColumn(columnName = "people_count")
    private Integer peopleCount;
    @DatabaseColumn(columnName = "total")
    private Double orderPrice;
    @DatabaseColumn(columnName = "state")
    private int state;

    public Integer getOrderId() {
        return OrderId;
    }

    public void setOrderId(Integer orderId) {
        OrderId = orderId;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
