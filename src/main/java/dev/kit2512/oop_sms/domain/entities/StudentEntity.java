package dev.kit2512.oop_sms.domain.entities;

import com.j256.ormlite.dao.ForeignCollection;
import dev.kit2512.oop_sms.data.models.ResultModel;
import dev.kit2512.oop_sms.data.models.StudentModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StudentEntity extends UserEntity {

    private Integer studentId;

    private Integer yearOfAdmission;

    private MajorEntity major;

    private String classLetter;

    public List<ResultEntity> getResults() {
        return results;
    }

    public void setResults(List<ResultEntity> results) {
        this.results = results;
    }

    private List<ResultEntity> results;
    public StudentEntity(Integer studetnId, Integer yearOfAdmission, MajorEntity major, String classLetter, List<ResultEntity> results) {
        this.studentId = studetnId;
        this.yearOfAdmission = yearOfAdmission;
        this.major = major;
        this.classLetter = classLetter;
        this.results = results;
    }


    public StudentEntity() {
    }

    public Integer getYearOfAdmission() {
        return yearOfAdmission;
    }

    public MajorEntity getMajor() {
        return major;
    }


    public String getStudentFullId() {
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

    public void setMajor(MajorEntity major) {
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
        for (ResultEntity result : this.results) {
            totalGrade += result.getResultScore() * (float)result.getSubject().getSubjectCredits();
            totalCredit += result.getSubject().getSubjectCredits();
        }
        return totalGrade / totalCredit;
    }
}
