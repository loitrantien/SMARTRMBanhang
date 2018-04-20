package com.dnu.loi.smartrm.obj;

import com.dnu.loi.smartrm.database.DatabaseColumn;
import com.dnu.loi.smartrm.database.DatabaseTable;

/**
 * Mô tả:
 * <p>
 * Created by loi on 19/04/2018.
 */
@DatabaseTable(TableName = "bill")
public class Bill {

    @DatabaseColumn(columnName = "id", isPrimaryKey = true)
    private int id;

    @DatabaseColumn(columnName = "name")
    private String name;

    @DatabaseColumn(columnName = "date_order")
    private String date;

    @DatabaseColumn(columnName = "total")
    private String total;

    @DatabaseColumn(columnName = "payment")
    private String payment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

}
