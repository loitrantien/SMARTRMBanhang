package com.dnu.loi.smartrm.obj;

import com.dnu.loi.smartrm.database.DatabaseColumn;
import com.dnu.loi.smartrm.database.DatabaseTable;

/**
 * Mô tả: class đối tượng món ăn
 * <p>
 * Created by loi on 12/04/2018.
 */

@DatabaseTable(TableName = "Dishes")
public class Dishes {
    @DatabaseColumn(columnName = "id")
    private String id;

    @DatabaseColumn(columnName = "name")
    private String name;

    @DatabaseColumn(columnName = "price")
    private String price;

    private int amount;

    private boolean isSelected;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
