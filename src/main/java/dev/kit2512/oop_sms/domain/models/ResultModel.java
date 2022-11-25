package dev.kit2512.oop_sms.domain.models;

import dev.kit2512.oop_sms.data.entities.ResultEntity;
import dev.kit2512.oop_sms.data.entities.SubjectEntity;


public class ResultModel {
    private Integer studentId;

    private Integer resultId;

    private SubjectModel subject;

    private Float resultScore;


    public ResultModel(Integer resultId, Integer studentId, SubjectModel subject, Float resultScore) {
        this.studentId = studentId;
        this.resultId = resultId;
        this.subject = subject;
        this.resultScore = resultScore;
    }

    public ResultModel() {

    }
    
    public ResultModel(ResultEntity resultEntity) {
        this.resultId = resultEntity.getResultId();
        this.subject = new SubjectModel(resultEntity.getSubjectEntity());
        this.resultScore = resultEntity.getResultScore();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public SubjectModel getSubject() {
        return subject;
    }

    public void setSubject(SubjectModel subject) {
        this.subject = subject;
    }

    public Float getResultScore() {
        return resultScore;
    }

    public void setResultScore(Float resultScore) {
        this.resultScore = resultScore;
    }
}
