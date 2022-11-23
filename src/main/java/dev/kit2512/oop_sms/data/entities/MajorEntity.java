package dev.kit2512.oop_sms.data.entities;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dev.kit2512.oop_sms.domain.models.MajorModel;

@DatabaseTable(tableName = MajorEntity.TABLE_NAME)
public class MajorEntity {
    public final static String TABLE_NAME = "majors";

    public final static String COLUMN_MAJOR_ID = "major_id";

    public final static String COLUMN_MAJOR_NAME = "major_name";

    public final static String COLUMN_MAJOR_CODE = "major_code";

    public final static String COLUMN_YEAR_OF_ESTABLISHMENT = "major_year_of_establishment";

    @DatabaseField(columnName = MajorEntity.COLUMN_MAJOR_ID, generatedId = true)
    private Integer majorId;

    @DatabaseField(columnName = MajorEntity.COLUMN_MAJOR_NAME, canBeNull = false, dataType = DataType.STRING)
    private String majorName;

    @DatabaseField(columnName = MajorEntity.COLUMN_MAJOR_CODE, canBeNull = false)
    private String majorCode;

    @DatabaseField(columnName = MajorEntity.COLUMN_YEAR_OF_ESTABLISHMENT, canBeNull = false)
    private Integer yearOfEstablishment;

    public MajorEntity() {
    }

    public MajorEntity(String majorName, String majorCode, Integer yearOfEstablishment) {
        this.majorName = majorName;
        this.majorCode = majorCode;
        this.yearOfEstablishment = yearOfEstablishment;
    }

    public MajorModel mapToModel() {
        return new MajorModel(majorId, majorName, majorCode, yearOfEstablishment);
    }

    public MajorEntity(MajorModel majorModel) {
        this.majorId = majorModel.getId();
        this.majorName = majorModel.getName();
        this.majorCode = majorModel.getCode();
        this.yearOfEstablishment = majorModel.getYearOfEstablishment();
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public Integer getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public void setYearOfEstablishment(Integer yearOfEstablishment) {
        this.yearOfEstablishment = yearOfEstablishment;
    }
}
