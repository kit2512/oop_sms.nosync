package dev.kit2512.oop_sms.data.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = SubjectEntity.TABLE_NAME)
public class SubjectEntity {
    public static final String TABLE_NAME = "subjects";

    public static final String COLUMN_SUBJECT_ID = "subject_id";
    @DatabaseField(columnName = SubjectEntity.COLUMN_SUBJECT_ID, generatedId = true)
    private Integer subjectId;

    public static final String COLUMN_SUBJECT_NAME = "subject_name";
    @DatabaseField(columnName = SubjectEntity.COLUMN_SUBJECT_NAME)
    private String subjectName;

    @DatabaseField(columnName = SubjectEntity.SOLUMN_SUBJECT_CREDITS)
    public static final String SOLUMN_SUBJECT_CREDITS = "subject_credit";
    private String subjectCredits;

    public SubjectEntity() {

    }

    public SubjectEntity(Integer subjectId, String subjectName, String subjectCredits) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectCredits = subjectCredits;
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

    public String getSubjectCredits() {
        return subjectCredits;
    }

    public void setSubjectCredits(String subjectCredits) {
        this.subjectCredits = subjectCredits;
    }
}