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
@DatabaseTable( TableName = "tbl_menuType")
public class Menu {
    @SerializedName("id")
    @Expose
    @DatabaseColumn( columnName = "id", isPrimaryKey = true)
    private String id;
    @SerializedName("name")
    @Expose
    @DatabaseColumn( columnName = "name")
    private String name;
    @SerializedName("tbl_menu")
    @Expose
    @DatabaseColumn( columnName = "id", isEnableCustom = true)
    private List<MenuDetail> details;

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

    public List<MenuDetail> getDetails() {
        return details;
    }

    public void setDetails(List<MenuDetail> details) {
        this.details = details;
    }
}
