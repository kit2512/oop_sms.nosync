package dev.kit2512.oop_sms.domain.entities;



public class ResultEntity implements Cloneable{
    private Integer studentId;

    private Integer resultId;

    private SubjectEntity subject;

    private Float resultScore;


    public ResultEntity(Integer resultId, Integer studentId, SubjectEntity subject, Float resultScore) {
        this.studentId = studentId;
        this.resultId = resultId;
        this.subject = subject;
        this.resultScore = resultScore;
    }

    public ResultEntity() {

    }

    public Integer getStudentId() {
        return studentId;
    }


    public Integer getResultId() {
        return resultId;
    }


    public SubjectEntity getSubject() {
        return subject;
    }


    public Float getResultScore() {
        return resultScore;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    public void setResultScore(Float resultScore) {
        this.resultScore = resultScore;
    }
}
