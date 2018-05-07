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
@DatabaseTable( TableName = "tbl_menu")
public class MenuDetail {
    @SerializedName("tbl_dishes")
    @Expose
    private Dishes dishes;
    @SerializedName("type_id")
    @Expose
    @DatabaseColumn( columnName = "type_id", isPrimaryKey = true)
    private String typeId;
    @SerializedName("dishes_id")
    @Expose
    @DatabaseColumn( columnName = "dishes_id", isPrimaryKey = true)
    private String dishesId;
    @SerializedName("is_active")
    @Expose
    @DatabaseColumn( columnName = "is_active")
    private Boolean isActive;

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getDishesId() {
        return dishesId;
    }

    public void setDishesId(String dishesId) {
        this.dishesId = dishesId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
