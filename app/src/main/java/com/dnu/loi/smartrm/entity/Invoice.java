package com.dnu.loi.smartrm.entity;

import com.dnu.loi.smartrm.database.DatabaseColumn;
import com.dnu.loi.smartrm.database.DatabaseTable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 02/05/2018.
 */
@DatabaseTable( TableName = "tbl_invoice")

public class Invoice {
    @SerializedName("id")
    @Expose
    @DatabaseColumn( columnName = "id", isPrimaryKey = true)
    private String id;

    @SerializedName("code")
    @Expose
    @DatabaseColumn( columnName = "code")
    private String code;

    @SerializedName("table_id")
    @Expose
    @DatabaseColumn( columnName = "table_id")
    private String tableId;

    @SerializedName("user_id")
    @Expose
    @DatabaseColumn( columnName = "user_id")
    private String userId;

    @SerializedName("time_in")
    @Expose
    @DatabaseColumn( columnName = "time_in")
    private String timeIn;

    @SerializedName("time_out")
    @Expose
    @DatabaseColumn( columnName = "time_out")
    private String timeOut;

    @SerializedName("date")
    @Expose
    @DatabaseColumn( columnName = "date")
    private String date;

    @SerializedName("total")
    @Expose
    @DatabaseColumn( columnName = "total")
    private Double total;

    @SerializedName("tbl_invoiceDetail")
    @Expose
    @DatabaseColumn( columnName = "id", isEnableCustom = true)
    private List<InvoiceDetail> details;

    @SerializedName("tbl_table")
    @Expose
    private Table table;

    public List<InvoiceDetail> getDetails() {
        return details;
    }

    public void setDetails(List<InvoiceDetail> details) {
        this.details = details;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
