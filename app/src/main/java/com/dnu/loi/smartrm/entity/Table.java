package com.dnu.loi.smartrm.entity;

import com.dnu.loi.smartrm.common.ETableType;
import com.dnu.loi.smartrm.database.DatabaseColumn;
import com.dnu.loi.smartrm.database.DatabaseTable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Mô tả:
 * <p>
 * Created by loi on 02/05/2018.
 */
@DatabaseTable( TableName = "tbl_table")
public class Table {
    @SerializedName("id")
    @Expose
    @DatabaseColumn( columnName = "id", isPrimaryKey = true)
    private String id;
    @SerializedName("code")
    @Expose
    @DatabaseColumn( columnName = "code")
    private String code;
    @SerializedName("name")
    @Expose
    @DatabaseColumn( columnName = "name")
    private String name;
    @SerializedName("type_id")
    @Expose
    @DatabaseColumn( columnName = "type_id")
    private String typeId;
    @SerializedName("floor_id")
    @Expose
    @DatabaseColumn( columnName = "floor_id")
    private String floorId;
    @SerializedName("tbl_tableType")
    @Expose
    @DatabaseColumn( columnName = "type_id" ,isEnableCustom = true, classCustom = TableType.class)
    private TableType type;

    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public TableType getType() {
        return type;
    }

    public void setType(TableType type) {
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

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public int getTableImageResource() {
        return ETableType.getType(type.getCode().trim()).getImageResource();
    }
}
