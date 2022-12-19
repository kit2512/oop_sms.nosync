package dev.kit2512.oop_sms.domain.entities;

import java.util.Date;

public class StaffEntity extends UserEntity implements Cloneable{
    private Integer salary;

    public StaffEntity() {
    }

    public StaffEntity(Integer userId, String username, String password, UserRole userRole, Date userDateCreated, Date userDateUpdated, String userFirstName, String userLastName, Date userDateOfBirth, String userMiddleName, Boolean userGender, String userAddress, String userEmail, String userPhone, Integer salary) {
        super(userId, username, password, userRole, userDateCreated, userDateUpdated, userFirstName, userLastName, userDateOfBirth, userMiddleName, userGender, userAddress, userEmail, userPhone);
        this.salary = salary;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
