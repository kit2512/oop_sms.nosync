package dev.kit2512.oop_sms.data.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dev.kit2512.oop_sms.domain.models.ResultModel;
import dev.kit2512.oop_sms.domain.models.SubjectModel;

@DatabaseTable(tableName = ResultEntity.TABLE_NAME)
public final class ResultEntity {
    public static final String TABLE_NAME = "results";

    public static final String COLUMN_RESULT_ID = "result_id";

    public static final String COLUMN_RESULT_SCORE = "result_score";

    @DatabaseField(columnName = ResultEntity.COLUMN_RESULT_ID, generatedId = true)
    private Integer resultId;

    @DatabaseField(columnName = StudentEntity.COLUMN_STUDENT_ID, foreign = true)
    private StudentEntity studentEntity;

    @DatabaseField(columnName = SubjectEntity.COLUMN_SUBJECT_ID, foreign = true)
    private SubjectEntity subjectEntity;

    @DatabaseField(columnName = ResultEntity.COLUMN_RESULT_SCORE)
    private Float resultScore;

    public ResultEntity(Integer resultId, StudentEntity studentEntity, SubjectEntity subjectEntity, Float resultScore) {
        this.resultId = resultId;
        this.studentEntity = studentEntity;
        this.subjectEntity = subjectEntity;
        this.resultScore = resultScore;
    }

    public ResultEntity() {

    }

    public ResultEntity(ResultModel resultModel) {
        this.resultId = resultModel.getResultId();
        this.studentEntity = new StudentEntity();
        this.studentEntity.setId(resultModel.getStudentId());
        this.subjectEntity = new SubjectEntity();
        this.setResultScore(resultModel.getResultScore());
    }

    public ResultModel mapToModel() {
        return new ResultModel(
          this.resultId,
          this.studentEntity.getId(),
          new SubjectModel(this.getSubjectEntity()),
                this.resultScore
        );
    }

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public SubjectEntity getSubjectEntity() {
        return subjectEntity;
    }

    public void setSubjectEntity(SubjectEntity subjectEntity) {
        this.subjectEntity = subjectEntity;
    }

    public Float getResultScore() {
        return resultScore;
    }

    public void setResultScore(Float resultScore) {
        this.resultScore = resultScore;
    }
}