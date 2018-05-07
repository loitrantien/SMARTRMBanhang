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
@DatabaseTable( TableName = "tbl_invoiceDetail")
public class InvoiceDetail {
    @SerializedName("invoice_id")
    @Expose
    @DatabaseColumn( columnName = "invoice_id", isPrimaryKey = true)
    private String invoiceId;
    @SerializedName("amount")
    @Expose
    @DatabaseColumn( columnName = "amount")
    private Integer amount;
    @SerializedName("name")
    @Expose
    @DatabaseColumn( columnName = "name", isPrimaryKey = true)
    private String name;
    @SerializedName("price")
    @Expose
    @DatabaseColumn( columnName = "price")
    private Double price;

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
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
}
