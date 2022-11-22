/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.data.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dev.kit2512.oop_sms.domain.entities.UserEntity;

import java.util.Date;


/**
 *
 * @author macpro13
 */

@DatabaseTable(tableName = User.TABLE_NAME)
public class User extends UserEntity {
    public static final String TABLE_NAME = "users";

    @DatabaseField(columnName = "id", generatedId = true)
    private Integer id;

    @DatabaseField(columnName = "username", canBeNull = false, unique = true)
    private String username;

    @DatabaseField(columnName = "password", canBeNull = false)
    private String password;

    @DatabaseField(columnName = "dateCreated", dataType = DataType.DATE_STRING, format = "yyyy-MM-dd HH:mm:ss", canBeNull = false)
    private Date dateCreated;

    @DatabaseField(columnName = "dateUpdated", dataType = DataType.DATE_STRING, format = "yyyy-MM-dd HH:mm:ss", canBeNull = false)
    private Date dateUpdated;

    @DatabaseField(columnName = "fullName")
    private String fullName;

    @DatabaseField(columnName = "email")
    private String email;

    @DatabaseField(columnName = "phone")
    private String phone;

    @DatabaseField(columnName = "address")
    private String address;

    @DatabaseField(columnName = "role", canBeNull = false)
    private String role;

    @DatabaseField(columnName = "gender", canBeNull = false)
    private boolean gender;


    public static final User demoUser = new User("demo", "demo", new Date(), new Date(), "Demo User", "abc@gmail.com", "1234567890", "1234 Main St", "user", true);

    public User(String username, String password, Date dateCreated, Date dateUpdated, String fullName, String email, String phone, String address, String role, boolean gender) {
        this.username = username;
        this.password = password;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this.gender = gender;
    }

    public User() {

    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }


}
