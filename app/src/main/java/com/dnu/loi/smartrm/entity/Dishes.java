package com.dnu.loi.smartrm.entity;

import com.dnu.loi.smartrm.database.DatabaseColumn;
import com.dnu.loi.smartrm.database.DatabaseTable;
import com.dnu.loi.smartrm.service.ApiUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Mô tả:
 * <p>
 * Created by loi on 02/05/2018.
 */
@DatabaseTable(TableName = "tbl_dishes")

public class Dishes {
    @SerializedName("id")
    @Expose
    @DatabaseColumn(columnName = "id", isPrimaryKey = true)
    private String id;

    @SerializedName("code")
    @Expose
    @DatabaseColumn(columnName = "code")
    private String code;

    @SerializedName("name")
    @Expose
    @DatabaseColumn(columnName = "name")
    private String name;

    @SerializedName("type_id")
    @Expose
    @DatabaseColumn(columnName = "type_id")
    private String typeId;

    @SerializedName("unit")
    @Expose
    @DatabaseColumn(columnName = "unit")
    private String unit;

    @SerializedName("price")
    @Expose
    @DatabaseColumn(columnName = "price")
    private Double price;

    @SerializedName("description")
    @Expose
    @DatabaseColumn(columnName = "description")
    private String description;

    @SerializedName("image")
    @Expose
    @DatabaseColumn(columnName = "image")
    private String image;

    @SerializedName("tbl_dishesType")
    @Expose
    private DishesType type;

    private boolean isSelected;

    private int Amount;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public DishesType getType() {
        return type;
    }

    public void setType(DishesType type) {
        this.type = type;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
        return !image.contains("http") ? ApiUtils.BASE_URL + image : image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dishes) {
            return ((Dishes) obj).getName().equalsIgnoreCase(name);
        }
        return super.equals(obj);
    }
}
