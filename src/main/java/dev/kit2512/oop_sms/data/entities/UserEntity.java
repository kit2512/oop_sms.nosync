package dev.kit2512.oop_sms.data.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dev.kit2512.oop_sms.domain.models.UserModel;

import java.util.Date;

@DatabaseTable(tableName = UserEntity.TABLE_NAME)
public class UserEntity{

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

    @DatabaseField(columnName = UserEntity.COLUMN_USER_ID, generatedId = true)
    private Integer userId;

    @DatabaseField(columnName = UserEntity.COLUMN_USER_USERNAME, canBeNull = false, unique = true)
    private String userUsername;

    @DatabaseField(columnName = UserEntity.COLUMN_USER_PASSWORD, canBeNull = false)
    private String userPassword;

    @DatabaseField(columnName = UserEntity.COLUMN_ROLE)
    private String userRole;

    @DatabaseField(columnName = UserEntity.COLUMN_DATE_CREATED, canBeNull = false, format = "yyyy-MM-dd")
    private Date userDateCreated;

    @DatabaseField(columnName = UserEntity.COLUMN_DATE_UPDATED, canBeNull = false, format = "yyyy-MM-dd")
    private Date userDateUpdated;

    @DatabaseField(columnName = UserEntity.COLUMN_FIRST_NAME, canBeNull = false)
    private String userFirstName;

    @DatabaseField(columnName = UserEntity.COLUMN_LAST_NAME, canBeNull = false)
    private String userLastName;
    
    @DatabaseField(columnName = UserEntity.COLUMN_DATE_OF_BIRTH, format = "yyyy-MM-dd")
    private Date userDateOfBirth;

    @DatabaseField(columnName = UserEntity.COLUMN_MIDDLE_NAME)
    private String userMiddleName;

    @DatabaseField(columnName = UserEntity.COLUMN_GENDER, canBeNull = false)
    private Boolean userGender;

    @DatabaseField(columnName = UserEntity.COLUMN_ADDRESS)
    private String userAddress;

    @DatabaseField(columnName = UserEntity.COLUMN_USER_EMAIL, canBeNull = false)
    private String userEmail;

    @DatabaseField(columnName = UserEntity.COLUMN_PHONE)
    private String userPhone;

    public UserEntity() {

    }

    public UserEntity(Integer userId, String userUsername, String userPassword, String userRole, Date userDateCreated, Date userDateUpdated, String userFirstName, String userLastName, Date userDateOfBirth, String userMiddleName, Boolean userGender, String userAddress, String userEmail, String userPhone) {
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

    public UserModel mapToModel() {
        return new UserModel(
                this.userId,
                this.userUsername,
                this.userPassword,
                UserModel.UserRole.valueOf(this.userRole),
                this.userDateCreated ,
                this.userDateUpdated ,
                this.userFirstName ,
                this.userLastName ,
                this.userDateOfBirth ,
                this.userMiddleName ,
                this.userGender ,
                this.userAddress ,
                this.userEmail ,
                this.userPhone
        );
    }

    public UserEntity(UserModel model) {
                this.userId = model.getUserId();
                this.userUsername = model.getUsername();
                this.userPassword = model.getPassword();
                this.userRole = model.getUserRole().name();
                this.userDateCreated =model.getUserDateCreated();
                this.userDateUpdated = model.getUserDateUpdated();
                this.userFirstName = model.getUserFirstName();
                this.userLastName = model.getUserLastName();
                this.userDateOfBirth = model.getUserDateOfBirth();
                this.userMiddleName = model.getUserMiddleName();
                this.userGender = model.getUserGender();
                this.userAddress = model.getUserAddress();
                this.userEmail = model.getUserEmail();
                this.userPhone = model.getUserPhone();
    }
}
