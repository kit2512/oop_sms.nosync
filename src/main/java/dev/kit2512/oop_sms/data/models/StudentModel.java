package dev.kit2512.oop_sms.data.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import dev.kit2512.oop_sms.domain.entities.ResultEntity;
import dev.kit2512.oop_sms.domain.entities.StudentEntity;
import dev.kit2512.oop_sms.domain.entities.UserEntity;

import java.util.ArrayList;


@DatabaseTable(tableName = StudentModel.TABLE_NAME)
public class StudentModel {
    public static final String TABLE_NAME = "students";

    public static final String COLUMN_STUDENT_ID = "student_id";

    public static final String COLUMN_YEAR_OF_ADMISSION = "student_year_of_admission";

    public static final String COLUMN_CLASS_LETTER = "student_class_letter";

    public ForeignCollection<ResultModel> getResultEntities() {
        return resultEntities;
    }

    @ForeignCollectionField
    private ForeignCollection<ResultModel> resultEntities;

    @DatabaseField(columnName = StudentModel.COLUMN_STUDENT_ID, generatedId = true)
    private Integer id;

    @DatabaseField(columnName = StudentModel.COLUMN_YEAR_OF_ADMISSION, canBeNull = false)
    private Integer yearOfAdmission;

    @DatabaseField(columnName = StudentModel.COLUMN_CLASS_LETTER)
    private String classLetter;


    @DatabaseField(columnName = UserModel.COLUMN_USER_ID, foreign = true, canBeNull = false)
    private UserModel user;

    @DatabaseField(columnName = MajorModel.COLUMN_MAJOR_ID, foreign = true, canBeNull = false)
    private MajorModel major;

    public StudentModel() {

    }

    public StudentModel(Integer yearOfAdmission, String classLetter, MajorModel major) {
        this.yearOfAdmission = yearOfAdmission;
        this.classLetter = classLetter;
        this.major = major;
    }

    public StudentModel(StudentEntity model) {
        this.yearOfAdmission = model.getYearOfAdmission();
        this.classLetter = model.getClassLetter();
        this.major = new MajorModel(model.getMajor());
    }

    public StudentEntity mapToEntity() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setUserGender(this.user.getUserGender());
        studentEntity.setUserId(this.user.getUserId());
        studentEntity.setPassword(this.user.getUserPassword());
        studentEntity.setUsername(this.user.getUserUsername());
        studentEntity.setUserDateCreated(this.user.getUserDateCreated());
        studentEntity.setUserDateUpdated(this.user.getUserDateUpdated());
        studentEntity.setUserRole(UserEntity.UserRole.valueOf(this.user.getUserRole()));
        studentEntity.setUserFirstName(this.user.getUserFirstName());
        studentEntity.setUserLastName(this.user.getUserLastName());
        studentEntity.setUserEmail(this.user.getUserEmail());
        studentEntity.setUserPhone(this.user.getUserPhone());
        studentEntity.setUserAddress(this.user.getUserAddress());
        studentEntity.setUserDateOfBirth(this.user.getUserDateOfBirth());
        studentEntity.setUserMiddleName(this.user.getUserMiddleName());

        studentEntity.setStudentId(this.id);
        studentEntity.setMajor(this.major.mapToEntity());
        studentEntity.setClassLetter(this.classLetter);
        studentEntity.setYearOfAdmission(this.yearOfAdmission);
        ArrayList<ResultEntity> resultEntityArrayList = new ArrayList<>();
        for (ResultModel resultModel : this.getResultEntities()) {
            resultEntityArrayList.add(resultModel.mapToEntity());
        }
        studentEntity.setResults(resultEntityArrayList);
        return studentEntity;
    }



    public Integer getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(Integer yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

    public String getClassLetter() {
        return classLetter;
    }

    public void setClassLetter(String classLetter) {
        this.classLetter = classLetter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public MajorModel getMajor() {
        return major;
    }

    public void setMajor(MajorModel major) {
        this.major = major;
    }

}
