package com.dnu.loi.smartrm.obj;

import com.dnu.loi.smartrm.database.DatabaseColumn;
import com.dnu.loi.smartrm.database.DatabaseTable;

import java.io.Serializable;

/**
 * Mô tả: class đối tượng món ăn
 * <p>
 * Created by loi on 12/04/2018.
 */

@DatabaseTable(TableName = "products")
public class Dishes {

    @DatabaseColumn(columnName = "id", isPrimaryKey = true)
    private int id;

    @DatabaseColumn(columnName = "name")
    private String name;

    @DatabaseColumn(columnName = "unit_price")
    private Double price;

    @DatabaseColumn(columnName = "description")
    private String description;

    @DatabaseColumn(columnName = "image")
    private String image;

    @DatabaseColumn(columnName = "unit")
    private String unit;

    @DatabaseColumn(columnName = "id_type")
    private int id_type;

    private transient int amount;

    private transient boolean isSelected;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public int getId_type() {
        return id_type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dishes)
            return ((Dishes) obj).getId() == id;
        return super.equals(obj);
    }
}
