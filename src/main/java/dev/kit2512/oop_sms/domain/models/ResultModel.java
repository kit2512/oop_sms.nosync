package dev.kit2512.oop_sms.domain.models;

import dev.kit2512.oop_sms.data.entities.StudentEntity;
import dev.kit2512.oop_sms.data.entities.SubjectEntity;

public class ResultModel {
    private Integer resultId;

    private Integer studentId;

    private Integer subjectId;

    private Float resultScore;

    private String subjectName;

    public ResultModel(Integer resultId, Integer studentId, Integer subjectId, String subjectName, Float resultScore) {
        this.resultId = resultId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.resultScore = resultScore;
    }

    public ResultModel() {

    }


    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Float getResultScore() {
        return resultScore;
    }

    public void setResultScore(Float resultScore) {
        this.resultScore = resultScore;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
