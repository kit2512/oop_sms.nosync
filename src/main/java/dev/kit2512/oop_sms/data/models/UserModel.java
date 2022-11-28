package dev.kit2512.oop_sms.data.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dev.kit2512.oop_sms.domain.entities.UserEntity;

import java.util.Date;

@DatabaseTable(tableName = UserModel.TABLE_NAME)
public class UserModel {

    public static final String TABLE_NAME = "users";

    public static final String COLUMN_USER_ID = "user_id";

    public static final String COLUMN_USER_USERNAME = "user_username";

    public static final String COLUMN_USER_PASSWORD = "user_password";

    public static final String COLUMN_DATE_CREATED = "user_date_created";

    public static final String COLUMN_DATE_UPDATED = "user_date_updated";

    public static final String COLUMN_FIRST_NAME = "user_first_name";

    public static final String COLUMN_LAST_NAME = "user_last_name";

    public static final String COLUMN_MIDDLE_NAME = "user_middle_name";

    public static final String COLUMN_USER_EMAIL = "user_email";

    public static final String COLUMN_PHONE = "user_phone";

    public static final String COLUMN_ADDRESS = "user_address";

    public static final String COLUMN_ROLE = "user_role";

    public static final String COLUMN_GENDER = "user_gender";

    public static final String COLUMN_DATE_OF_BIRTH = "user_date_of_birth";

    @DatabaseField(columnName = UserModel.COLUMN_USER_ID, generatedId = true)
    private Integer userId;

    @DatabaseField(columnName = UserModel.COLUMN_USER_USERNAME, canBeNull = false, unique = true)
    private String userUsername;

    @DatabaseField(columnName = UserModel.COLUMN_USER_PASSWORD, canBeNull = false)
    private String userPassword;

    @DatabaseField(columnName = UserModel.COLUMN_ROLE)
    private String userRole;

    @DatabaseField(columnName = UserModel.COLUMN_DATE_CREATED, canBeNull = false, format = "yyyy-MM-dd")
    private Date userDateCreated;

    @DatabaseField(columnName = UserModel.COLUMN_DATE_UPDATED, canBeNull = false, format = "yyyy-MM-dd")
    private Date userDateUpdated;

    @DatabaseField(columnName = UserModel.COLUMN_FIRST_NAME, canBeNull = false)
    private String userFirstName;

    @DatabaseField(columnName = UserModel.COLUMN_LAST_NAME, canBeNull = false)
    private String userLastName;
    
    @DatabaseField(columnName = UserModel.COLUMN_DATE_OF_BIRTH, format = "yyyy-MM-dd")
    private Date userDateOfBirth;

    @DatabaseField(columnName = UserModel.COLUMN_MIDDLE_NAME)
    private String userMiddleName;

    @DatabaseField(columnName = UserModel.COLUMN_GENDER, canBeNull = false)
    private Boolean userGender;

    @DatabaseField(columnName = UserModel.COLUMN_ADDRESS)
    private String userAddress;

    @DatabaseField(columnName = UserModel.COLUMN_USER_EMAIL, canBeNull = false)
    private String userEmail;

    @DatabaseField(columnName = UserModel.COLUMN_PHONE)
    private String userPhone;

    public UserModel() {

    }

    public UserModel(Integer userId, String userUsername, String userPassword, String userRole, Date userDateCreated, Date userDateUpdated, String userFirstName, String userLastName, Date userDateOfBirth, String userMiddleName, Boolean userGender, String userAddress, String userEmail, String userPhone) {
        this.userId = userId;
        this.userUsername = userUsername;
        this.userPassword = userPassword;
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

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
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


    public UserModel(dev.kit2512.oop_sms.domain.entities.UserEntity entity) {
                this.userId = entity.getUserId();
                this.userUsername = entity.getUsername();
                this.userPassword = entity.getPassword();
                this.userRole = entity.getUserRole().name();
                this.userDateCreated =entity.getUserDateCreated();
                this.userDateUpdated = entity.getUserDateUpdated();
                this.userFirstName = entity.getUserFirstName();
                this.userLastName = entity.getUserLastName();
                this.userDateOfBirth = entity.getUserDateOfBirth();
                this.userMiddleName = entity.getUserMiddleName();
                this.userGender = entity.getUserGender();
                this.userAddress = entity.getUserAddress();
                this.userEmail = entity.getUserEmail();
                this.userPhone = entity.getUserPhone();
    }

    public UserEntity mapToEntity() {
        UserEntity entity = new UserEntity();
        entity.setUserId(this.userId);
        entity.setUsername(this.userUsername);
        entity.setPassword(this.userPassword);
        entity.setUserGender(this.userGender);
        entity.setUserRole(UserEntity.UserRole.valueOf(this.userRole));
        entity.setUserDateCreated(this.userDateCreated);
        entity.setUserDateUpdated(this.userDateUpdated);
        entity.setUserFirstName(this.userFirstName);
        entity.setUserLastName(this.userLastName);
        entity.setUserDateOfBirth(this.userDateOfBirth);
        entity.setUserMiddleName(this.userMiddleName);
        entity.setUserGender(this.userGender);
        entity.setUserAddress(this.userAddress);
        entity.setUserEmail(this.userEmail);
        entity.setUserPhone(this.userPhone);
        return entity;
    }
}
