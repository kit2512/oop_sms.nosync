package dev.kit2512.oop_sms.data.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dev.kit2512.oop_sms.domain.entities.ResultEntity;
import dev.kit2512.oop_sms.domain.entities.SubjectEntity;

@DatabaseTable(tableName = ResultModel.TABLE_NAME)
public final class ResultModel {
    public static final String TABLE_NAME = "results";

    public static final String COLUMN_RESULT_ID = "result_id";

    public static final String COLUMN_RESULT_SCORE = "result_score";

    @DatabaseField(columnName = ResultModel.COLUMN_RESULT_ID, generatedId = true)
    private Integer resultId;

    @DatabaseField(columnName = StudentModel.COLUMN_STUDENT_ID, foreign = true)
    private StudentModel studentModel;

    @DatabaseField(columnName = SubjectModel.COLUMN_SUBJECT_ID, foreign = true)
    private SubjectModel subjectModel;

    @DatabaseField(columnName = ResultModel.COLUMN_RESULT_SCORE)
    private Float resultScore;

    public ResultModel(Integer resultId, StudentModel studentModel, SubjectModel subjectModel, Float resultScore) {
        this.resultId = resultId;
        this.studentModel = studentModel;
        this.subjectModel = subjectModel;
        this.resultScore = resultScore;
    }

    public ResultModel() {

    }

    public ResultModel(ResultEntity resultEntity) {
        this.resultId = resultEntity.getResultId();
        this.studentModel = new StudentModel();
        this.studentModel.setId(resultEntity.getStudentId());
        this.subjectModel = new SubjectModel();
        this.setResultScore(resultEntity.getResultScore());
    }

    public ResultEntity mapToEntity() {
        return new ResultEntity(
          this.resultId,
          this.studentModel.getId(),
          this.getSubjectEntity().mapToEntity(),
                this.resultScore
        );
    }

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public StudentModel getStudentEntity() {
        return studentModel;
    }

    public void setStudentEntity(StudentModel studentModel) {
        this.studentModel = studentModel;
    }

    public SubjectModel getSubjectEntity() {
        return subjectModel;
    }

    public void setSubjectEntity(SubjectModel subjectModel) {
        this.subjectModel = subjectModel;
    }

    public Float getResultScore() {
        return resultScore;
    }

    public void setResultScore(Float resultScore) {
        this.resultScore = resultScore;
    }
}