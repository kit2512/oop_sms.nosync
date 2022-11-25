package dev.kit2512.oop_sms.data.entities;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import dev.kit2512.oop_sms.domain.models.ResultModel;
import dev.kit2512.oop_sms.domain.models.StudentModel;

import java.util.ArrayList;


@DatabaseTable(tableName = StudentEntity.TABLE_NAME)
public class StudentEntity {
    public static final String TABLE_NAME = "students";

    public static final String COLUMN_STUDENT_ID = "student_id";

    public static final String COLUMN_YEAR_OF_ADMISSION = "student_year_of_admission";

    public static final String COLUMN_CLASS_LETTER = "student_class_letter";

    public ForeignCollection<ResultEntity> getResultEntities() {
        return resultEntities;
    }

    @ForeignCollectionField
    private ForeignCollection<ResultEntity> resultEntities;

    @DatabaseField(columnName = StudentEntity.COLUMN_STUDENT_ID, generatedId = true)
    private Integer id;

    @DatabaseField(columnName = StudentEntity.COLUMN_YEAR_OF_ADMISSION, canBeNull = false)
    private Integer yearOfAdmission;

    @DatabaseField(columnName = StudentEntity.COLUMN_CLASS_LETTER)
    private String classLetter;


    @DatabaseField(columnName = UserEntity.COLUMN_USER_ID, foreign = true, canBeNull = false)
    private UserEntity user;

    @DatabaseField(columnName = MajorEntity.COLUMN_MAJOR_ID, foreign = true, canBeNull = false)
    private MajorEntity major;

    public StudentEntity() {

    }

    public StudentEntity(Integer yearOfAdmission, String classLetter, MajorEntity major) {
        this.yearOfAdmission = yearOfAdmission;
        this.classLetter = classLetter;
        this.major = major;
    }

    public StudentEntity(StudentModel model) {
        this.yearOfAdmission = model.getYearOfAdmission();
        this.classLetter = model.getClassLetter();
        this.major = new MajorEntity(model.getMajor());
    }

    public StudentModel mapToModel() {
        StudentModel studentModel = new StudentModel();
        studentModel.setStudentId(this.id);
        studentModel.setMajor(this.major.mapToModel());
        studentModel.setClassLetter(this.classLetter);
        ArrayList<ResultModel> resultModelArrayList = new ArrayList<>();
        for (ResultEntity resultEntity : this.getResultEntities()) {
            resultModelArrayList.add(resultEntity.mapToModel());
        }
        return studentModel;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public MajorEntity getMajor() {
        return major;
    }

    public void setMajor(MajorEntity major) {
        this.major = major;
    }

}
