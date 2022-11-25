package dev.kit2512.oop_sms.domain.models;

import com.j256.ormlite.dao.ForeignCollection;
import dev.kit2512.oop_sms.data.entities.ResultEntity;
import dev.kit2512.oop_sms.data.entities.StudentEntity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StudentModel extends UserModel{

    private Integer studentId;

    private Integer yearOfAdmission;

    private MajorModel major;

    private String classLetter;

    public List<ResultModel> getResults() {
        return results;
    }

    public void setResults(List<ResultModel> results) {
        this.results = results;
    }

    private List<ResultModel> results;
    public StudentModel(Integer studetnId, Integer yearOfAdmission, MajorModel major, String classLetter, List<ResultModel> results) {
        this.studentId = studetnId;
        this.yearOfAdmission = yearOfAdmission;
        this.major = major;
        this.classLetter = classLetter;
        this.results = results;
    }

    public StudentModel() {
    }
    
    public StudentModel(StudentEntity studentEntity) {
        super(studentEntity.getUser());
        this.studentId = studentEntity.getId();
        this.yearOfAdmission = studentEntity.getYearOfAdmission();
        this.major = new MajorModel(studentEntity.getMajor());
        this.classLetter = studentEntity.getClassLetter();
        this.results = new ArrayList<>();
        final ForeignCollection<ResultEntity> resultEntities = studentEntity.getResultEntities();
        for (ResultEntity resultEntity : resultEntities) {
            final ResultModel resultModel = new ResultModel(resultEntity);
            this.results.add(new ResultModel(resultEntity));
        }
    }

    public Integer getYearOfAdmission() {
        return yearOfAdmission;
    }

    public MajorModel getMajor() {
        return major;
    }


    public String getStudentFullId() {
        final Integer currentYear = Calendar.getInstance().get(Calendar.YEAR) - 1900;
        final Integer yearOfAdmission = this.getYearOfAdmission();
        final Integer year = yearOfAdmission - this.major.getYearOfEstablishment() + 1;
        final String majorCode = this.getMajor().getCode();

        return String.format("%s%d%03d", majorCode, year, this.studentId);
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setYearOfAdmission(Integer yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

    public void setMajor(MajorModel major) {
        this.major = major;
    }

    public String getClassLetter() {
        return classLetter;
    }

    public void setClassLetter(String classLetter) {
        this.classLetter = classLetter;
    }

    public Float getGPA() {
        Float totalGrade = 0f;
        Integer totalCredit = 0;
        for (ResultModel result : this.results) {
            totalGrade += result.getResultScore() * (float)result.getSubject().getSubjectCredits();
            totalCredit += result.getSubject().getSubjectCredits();
        }
        return totalGrade / totalCredit;
    }
}
