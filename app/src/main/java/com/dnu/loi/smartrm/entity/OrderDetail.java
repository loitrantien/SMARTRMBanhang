package com.dnu.loi.smartrm.entity;

import com.dnu.loi.smartrm.database.DatabaseColumn;
import com.dnu.loi.smartrm.database.DatabaseTable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Mô tả:
 * <p>
 * Created by loi on 02/05/2018.
 */
@DatabaseTable(TableName = "tbl_orderDetail")
public class OrderDetail {
    @SerializedName("order_id")
    @Expose
    @DatabaseColumn( columnName = "order_id", isPrimaryKey = true)
    private String orderId;
    @SerializedName("amout")
    @Expose
    @DatabaseColumn( columnName = "amout")
    private Integer amount;
    @SerializedName("name")
    @Expose
    @DatabaseColumn( columnName = "name", isPrimaryKey = true )
    private String name;
    @SerializedName("price")
    @Expose
    @DatabaseColumn( columnName = "price")
    private Double price;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + String.format("<font color=#0973b8> (%s)</font>", String.valueOf(amount));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OrderDetail) {
            return ((OrderDetail) obj).getName().equals(name);
        }
        return super.equals(obj);
    }
}
