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
@DatabaseTable( TableName = "tbl_order")

public class Order {
    @SerializedName("id")
    @Expose
    @DatabaseColumn( columnName = "id", isPrimaryKey = true)
    private String id;
    @SerializedName("create_date")
    @Expose
    @DatabaseColumn( columnName = "create_date")
    private String createDate;
    @SerializedName("update_date")
    @Expose
    @DatabaseColumn( columnName = "update_date")
    private String updateDate;
    @SerializedName("note")
    @Expose
    @DatabaseColumn( columnName = "note")
    private String note;
    @SerializedName("table_id")
    @Expose
    @DatabaseColumn( columnName = "table_id")
    private String tableId;
    @SerializedName("people")
    @Expose
    @DatabaseColumn( columnName = "people")
    private int people;
    @SerializedName("state")
    @Expose
    @DatabaseColumn( columnName = "state")
    private String state;
    @SerializedName("total")
    @Expose
    @DatabaseColumn( columnName = "total")
    private Double total;
    @SerializedName("tbl_orderDetail")
    @Expose
    @DatabaseColumn( columnName = "id", isEnableCustom = true, classCustom = OrderDetail.class)
    private List<OrderDetail> details;
    @SerializedName("tbl_table")
    @Expose
    @DatabaseColumn( columnName = "table_id", isEnableCustom = true, classCustom = Table.class)
    private Table table;

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getDetailListString() {
        if (details != null) {

            StringBuilder c = new StringBuilder();
            for (int i = 0; i < details.size(); i++) {
                OrderDetail detail = details.get(i);
                c.append(detail).append(details.size() == 1 || i == details.size() - 1 ? "" : ", ");
            }
            return c.toString();
        }
        return "";
    }
}
