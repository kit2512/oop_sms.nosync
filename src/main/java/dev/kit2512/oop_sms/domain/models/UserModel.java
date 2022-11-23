package dev.kit2512.oop_sms.domain.models;

import dev.kit2512.oop_sms.data.entities.UserEntity;

import java.util.Date;

public class UserModel extends BaseModel{
    public enum UserRole {
        STUDENT,
        STAFF,
        ADMIN,
    }
    
    private Integer userId;

    private String username;

    private String password;

    private UserRole userRole;

    private Date userDateCreated;

    private Date userDateUpdated;

    private String userFirstName;

    private String userLastName;

    private Date userDateOfBirth;

    private String userMiddleName;

    private Boolean userGender;

    private String userAddress;

    private String userEmail;

    private String userPhone;

    public UserModel() {

    }

    public UserModel(Integer userId, String username, String password, UserRole userRole, Date userDateCreated, Date userDateUpdated, String userFirstName, String userLastName, Date userDateOfBirth, String userMiddleName, Boolean userGender, String userAddress, String userEmail, String userPhone) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.userDateCreated = userDateCreated;
        this.userDateUpdated = userDateUpdated;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userDateOfBirth = userDateOfBirth;
        this.userMiddleName = userMiddleName;
        this.userGender = userGender;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Date getUserDateCreated() {
        return userDateCreated;
    }

    public void setUserDateCreated(Date userDateCreated) {
        this.userDateCreated = userDateCreated;
    }

    public Date getUserDateUpdated() {
        return userDateUpdated;
    }

    public void setUserDateUpdated(Date userDateUpdated) {
        this.userDateUpdated = userDateUpdated;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public Date getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public void setUserDateOfBirth(Date userDateOfBirth) {
        this.userDateOfBirth = userDateOfBirth;
    }

    public String getUserMiddleName() {
        return userMiddleName;
    }

    public void setUserMiddleName(String userMiddleName) {
        this.userMiddleName = userMiddleName;
    }

    public Boolean getUserGender() {
        return userGender;
    }

    public void setUserGender(Boolean userGender) {
        this.userGender = userGender;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                ", userDateCreated=" + userDateCreated +
                ", userDateUpdated=" + userDateUpdated +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userDateOfBirth=" + userDateOfBirth +
                ", userMiddleName='" + userMiddleName + '\'' +
                ", userGender=" + userGender +
                ", userAddress='" + userAddress + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }
}