package com.dnu.loi.smartrm.obj;

import com.dnu.loi.smartrm.database.DatabaseColumn;
import com.dnu.loi.smartrm.database.DatabaseTable;

/**
 * Mô tả:
 * <p>
 * Created by loi on 07/04/2018.
 */
@DatabaseTable(TableName = "order_detail")
public class OrderDetail {
    @DatabaseColumn(columnName = "id_order", isPrimaryKey = true)
    private int orderId;

    @DatabaseColumn(columnName = "id_product", isPrimaryKey = true)
    private int dishesId;

    @DatabaseColumn(columnName = "name_product", isEnableCustom = true, classCustom = String.class)
    private String dishesName;

    @DatabaseColumn(columnName = "quantity")
    private int amount;

    @DatabaseColumn(columnName = "unit_price")
    private double price;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getDishesId() {
        return dishesId;
    }

    public void setDishesId(int dishesId) {
        this.dishesId = dishesId;
    }

    public String getDishesName() {
        return dishesName;
    }

    public void setDishesName(String dishesName) {
        this.dishesName = dishesName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return dishesName + String.format("<font color=#0973b8> (%s)</font>", String.valueOf(amount));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OrderDetail) {
            return ((OrderDetail) obj).dishesId == dishesId && ((OrderDetail) obj).orderId == orderId;
        }
        return super.equals(obj);
    }
}
