package dev.kit2512.oop_sms.data.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dev.kit2512.oop_sms.domain.entities.SubjectEntity;

@DatabaseTable(tableName = SubjectModel.TABLE_NAME)
public class SubjectModel {
    public static final String TABLE_NAME = "subjects";

    public static final String SOLUMN_SUBJECT_CREDITS = "subject_credit";

    public static final String COLUMN_SUBJECT_NAME = "subject_name";

    public static final String COLUMN_SUBJECT_ID = "subject_id";
    @DatabaseField(columnName = SubjectModel.COLUMN_SUBJECT_ID, generatedId = true)
    private Integer subjectId;

    @DatabaseField(columnName = SubjectModel.COLUMN_SUBJECT_NAME)
    private String subjectName;

    @DatabaseField(columnName = SubjectModel.SOLUMN_SUBJECT_CREDITS)
    private Integer subjectCredits;

    public SubjectModel() {

    }

    public SubjectModel(Integer subjectId, String subjectName, Integer subjectCredits) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectCredits = subjectCredits;
    }

    public SubjectModel(SubjectEntity entity) {
        this.subjectId = entity.getSubjectId();
        this.subjectName = entity.getSubjectName();
        this.subjectCredits = entity.getSubjectCredits();
    }

    public SubjectEntity mapToEntity() {
        return new SubjectEntity(
                this.subjectId,
                this.subjectName,
                this.subjectCredits
        );
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
