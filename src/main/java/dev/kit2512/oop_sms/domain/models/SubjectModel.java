package dev.kit2512.oop_sms.domain.models;

import dev.kit2512.oop_sms.data.entities.SubjectEntity;

public class SubjectModel {
    private Integer subjectId;
    private String subjectName;
    private Integer subjectCredits;

    public SubjectModel(Integer subjectId, String subjectName, Integer subjectCredits) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectCredits = subjectCredits;
    }

    public SubjectModel(SubjectEntity subjectEntity) {
        this.subjectId = subjectEntity.getSubjectId();
        this.subjectName = subjectEntity.getSubjectName();
        this.subjectCredits = subjectEntity.getSubjectCredits();
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getSubjectCredits() {
        return subjectCredits;
    }

    public void setSubjectCredits(Integer subjectCredits) {
        this.subjectCredits = subjectCredits;
    }
}
