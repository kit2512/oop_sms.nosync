package dev.kit2512.oop_sms.domain.models;

import java.util.Calendar;
import java.util.List;

public class StudentModel{


    private UserModel user;

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
    public StudentModel(Integer studetnId, UserModel user, Integer yearOfAdmission, MajorModel major, String classLetter, List<ResultModel> results) {
        this.user = user;
        this.studentId = studetnId;
        this.yearOfAdmission = yearOfAdmission;
        this.major = major;
        this.classLetter = classLetter;
        this.results = results;
    }

    public StudentModel() {
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
        final Integer year = currentYear - yearOfAdmission + 1;
        final String majorCode = this.getMajor().getCode();

        return String.format("%s%d%03d", majorCode, year, this.studentId);
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
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
}
