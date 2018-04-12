package com.dnu.loi.smartrm.obj;
import com.dnu.loi.smartrm.database.DatabaseColumn;
import com.dnu.loi.smartrm.database.DatabaseTable;

/**
 * Mô tả:
 * <p>
 * Created by loi on 07/04/2018.
 */
@DatabaseTable(TableName = "OrderDetail")
public class OrderDetail {
    @DatabaseColumn(columnName = "orderId", isPrimaryKey = true)
    private String orderId;

    @DatabaseColumn(columnName = "dishesId", isPrimaryKey = true)
    private String dishesId;

    @DatabaseColumn(columnName = "dishesNameId", isPrimaryKey = true, isEnableCustom = true, classCustom = String.class)
    private String dishesName;

    @DatabaseColumn(columnName = "amount")
    private int amount;

    public String getDishesId() {
        return dishesId;
    }

    public void setDishesId(String dishesId) {
        this.dishesId = dishesId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    @Override
    public String toString() {
        return dishesName + String.format("<font color=#0973b8> (%s)</font>", String.valueOf(amount));
    }
}
