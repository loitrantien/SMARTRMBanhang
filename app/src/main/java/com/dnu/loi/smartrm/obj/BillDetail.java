package com.dnu.loi.smartrm.obj;

import com.dnu.loi.smartrm.database.DatabaseColumn;
import com.dnu.loi.smartrm.database.DatabaseTable;

/**
 * Mô tả:
 * <p>
 * Created by loi on 20/04/2018.
 */
@DatabaseTable(TableName = "bill_detail")
public class BillDetail {

    @DatabaseColumn(columnName = "id_bill",isPrimaryKey = true)
    private int IdBill;

    @DatabaseColumn(columnName = "id_product",isPrimaryKey = true)
    private int IdDishes;

    @DatabaseColumn(columnName = "quantity")
    private int quantity;

    @DatabaseColumn(columnName = "unit_price")
    private double unitPrice;

    public int getIdBill() {
        return IdBill;
    }

    public void setIdBill(int idBill) {
        IdBill = idBill;
    }

    public int getIdDishes() {
        return IdDishes;
    }

    public void setIdDishes(int idDishes) {
        IdDishes = idDishes;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
