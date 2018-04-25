package com.dnu.loi.smartrm.obj;

import com.dnu.loi.smartrm.database.DatabaseColumn;
import com.dnu.loi.smartrm.database.DatabaseTable;
import com.dnu.loi.smartrm.database.entity.BillDb;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 19/04/2018.
 */
@DatabaseTable(TableName = "bills")
public class Bill {

    @DatabaseColumn(columnName = "id", isPrimaryKey = true)
    private int id;

    @DatabaseColumn(columnName = "name")
    private String name;

    @DatabaseColumn(columnName = "date_order")
    private String date;

    @DatabaseColumn(columnName = "total")
    private String total;

    @DatabaseColumn(columnName = "id_table", isEnableCustom = true, classCustom = Table.class)
    private Table table;

    private List<BillDetail> billDetails;

    private Order order;

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public List<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }

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

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public BillDb getDbObject() {
        BillDb billDb = new BillDb();
        billDb.setId(id);
        billDb.setDate(date);
        billDb.setName(name);
        billDb.setTable(table.getTableId());
        billDb.setTotal(total);
        return billDb;
    }
}
