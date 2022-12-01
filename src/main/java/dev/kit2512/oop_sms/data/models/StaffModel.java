package dev.kit2512.oop_sms.data.models;

import com.j256.ormlite.field.DatabaseField;
import dev.kit2512.oop_sms.domain.entities.StaffEntity;
import dev.kit2512.oop_sms.domain.entities.UserEntity;

import java.util.Date;

public class StaffModel {
    public static final String TABLE_NAME = "staffs";

    public static final String COLUMN_STAFF_ID = "id";

    public static final String COLUMN_STAFF_SALARY = "salary";

    @DatabaseField(columnName = COLUMN_STAFF_ID, generatedId = true)
    private Integer id;

    @DatabaseField(columnName = UserModel.COLUMN_USER_ID, foreign = true)
    private UserModel user;

    @DatabaseField(columnName = COLUMN_STAFF_SALARY)
    private Integer salary;

    public StaffModel() {

    }

    public StaffModel(Integer id, UserModel user, Integer salary) {
        this.id = id;
        this.user = user;
        this.salary = salary;
    }

    public StaffEntity mapToEntity() {
        final UserModel userEntity = this.getUser();
        return new StaffEntity(
                this.getId(),
                userEntity.getUserUsername(),
                userEntity.getUserPassword(),
                UserEntity.UserRole.valueOf(userEntity.getUserRole()),
                userEntity.getUserDateCreated(),
                userEntity.getUserDateUpdated(),
                userEntity.getUserFirstName(),
                userEntity.getUserLastName(),
                userEntity.getUserDateOfBirth(),
                userEntity.getUserMiddleName(),
                userEntity.getUserGender(),
                userEntity.getUserAddress(),
                userEntity.getUserEmail(),
                userEntity.getUserPhone(),
                this.getSalary()
        );
    }

    public Integer getId() {
        return id;
    }

    public UserModel getUser() {
        return user;
    }

    public Integer getSalary() {
        return salary;
    }
}
