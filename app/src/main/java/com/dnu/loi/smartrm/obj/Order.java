package com.dnu.loi.smartrm.obj;

import com.dnu.loi.smartrm.database.DatabaseColumn;
import com.dnu.loi.smartrm.database.DatabaseTable;
import com.dnu.loi.smartrm.database.entity.OrderDb;

import java.util.List;

/**
 * Mô tả: class mô tả đối tượng order
 * <p>
 * Created by loi on 07/04/2018.
 */
@DatabaseTable(TableName = "order")
public class Order {
    @DatabaseColumn(columnName = "id", isPrimaryKey = true)
    private Integer id;
    @DatabaseColumn(columnName = "id_table", isEnableCustom = true, classCustom = Table.class)
    private Table table;
    @DatabaseColumn(columnName = "people_count")
    private Integer peopleCount;
    @DatabaseColumn(columnName = "id", isEnableCustom = true, classCustom = OrderDetail.class)
    private List<OrderDetail> detailList;
    @DatabaseColumn(columnName = "total")
    private Double orderPrice;
    @DatabaseColumn(columnName = "state")
    private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public String getPeopleCount() {
        return String.valueOf(peopleCount);
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public List<OrderDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<OrderDetail> detailList) {
        this.detailList = detailList;
    }

    public String getOrderPrice() {
        return String.valueOf(orderPrice);
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

    public String getDetailListString() {
        if (detailList != null) {

            StringBuilder c = new StringBuilder();
            for (int i = 0; i < detailList.size(); i++) {
                OrderDetail detail = detailList.get(i);
                c.append(detail).append(detailList.size() == 1 || i == detailList.size() - 1 ? "" : ", ");
            }
            return c.toString();
        }
        return "";
    }
    public OrderDb getDbObject(){
        OrderDb orderDb = new OrderDb();
        orderDb.setOrderId(id);
        orderDb.setOrderPrice(orderPrice);
        orderDb.setPeopleCount(peopleCount);
        orderDb.setTable(table.getTableId());
        orderDb.setState(state);
        return orderDb;
    }
}
