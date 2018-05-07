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
@DatabaseTable( TableName = "tbl_user")

public class User {
    @SerializedName("id")
    @Expose
    @DatabaseColumn( columnName = "id", isPrimaryKey = true)
    private String id;
    @SerializedName("user_name")
    @Expose
    @DatabaseColumn( columnName = "user_name")
    private String userName;
    @SerializedName("password")
    @Expose
    @DatabaseColumn( columnName = "password")
    private String password;
    @SerializedName("first_name")
    @Expose
    @DatabaseColumn( columnName = "first_name")
    private String firstName;
    @SerializedName("last_name")
    @Expose
    @DatabaseColumn( columnName = "last_name")
    private String lastName;
    @SerializedName("avatar")
    @Expose
    @DatabaseColumn( columnName = "avatar")
    private Object avatar;
    @SerializedName("date_of_birth")
    @Expose
    @DatabaseColumn( columnName = "date_of_birth")
    private String dateOfBirth;
    @SerializedName("email")
    @Expose
    @DatabaseColumn( columnName = "email")
    private String email;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Object getAvatar() {
        return avatar;
    }

    public void setAvatar(Object avatar) {
        this.avatar = avatar;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
