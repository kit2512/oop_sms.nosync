package dev.kit2512.oop_sms.domain.entities;

import java.util.Date;

public interface UserEntity {
    Integer getId();

    String getUsername();

    void setUsername(String username);

    Date getDateCreated();


    Date getDateUpdated();

    void setDateUpdated(Date dateUpdated);

    String getFullName();

    void setFullName(String fullName);

    String getEmail();

    void setEmail(String email);

    String getPhone();

    void setPhone(String phone);

    String getAddress();

    void setAddress(String address);

    String getRole();

    void setRole(String role);

    boolean getGender();

    void setGender(boolean gender);
}
