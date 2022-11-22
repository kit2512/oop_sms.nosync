package dev.kit2512.oop_sms.domain.entities;

import java.util.Date;

public abstract class UserEntity {
    public static  final String ID_PROPERTY = "id";
    public static  final String USERNAME_PROPERTY = "username";
    public static  final String PASSWORD_PROPERTY = "password";
    public static  final String DATE_CREATED_PROPERTY = "dateCreated";
    public static  final String DATE_UPDATED_PROPERTY = "dateUpdated";
    public static  final String FULL_NAME_PROPERTY = "fullName";
    public static  final String EMAIL_PROPERTY = "email";
    public static  final String PHONE_PROPERTY = "phone";
    public static  final String ADDRESS_PROPERTY = "address";
    public static  final String ROLE_PROPERTY = "role";

    abstract public Integer getId();

    abstract public String getUsername();

    abstract public void setUsername(String username);

    abstract public Date getDateCreated();

    abstract public Date getDateUpdated();

    abstract public void setDateUpdated(Date dateUpdated);

    abstract public String getFullName();

    abstract public void setFullName(String fullName);

    abstract public String getEmail();

    abstract public void setEmail(String email);

    abstract public String getPhone();

    abstract public void setPhone(String phone);

    abstract public String getAddress();

    abstract public void setAddress(String address);

    abstract public String getRole();

    abstract public void setRole(String role);

    abstract public boolean getGender();

    abstract public void setGender(boolean gender);
}
