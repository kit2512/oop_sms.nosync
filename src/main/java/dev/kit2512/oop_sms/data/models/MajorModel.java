package dev.kit2512.oop_sms.data.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dev.kit2512.oop_sms.domain.entities.MajorEntity;

@DatabaseTable(tableName = MajorModel.TABLE_NAME)
public class MajorModel {
    public final static String TABLE_NAME = "majors";

    public final static String COLUMN_MAJOR_ID = "major_id";

    public final static String COLUMN_MAJOR_NAME = "major_name";

    public final static String COLUMN_MAJOR_CODE = "major_code";

    public final static String COLUMN_YEAR_OF_ESTABLISHMENT = "major_year_of_establishment";

    @DatabaseField(columnName = MajorModel.COLUMN_MAJOR_ID, generatedId = true)
    private Integer majorId;

    @DatabaseField(columnName = MajorModel.COLUMN_MAJOR_NAME, canBeNull = false, dataType = DataType.STRING)
    private String majorName;

    @DatabaseField(columnName = MajorModel.COLUMN_MAJOR_CODE, canBeNull = false)
    private String majorCode;

    @DatabaseField(columnName = MajorModel.COLUMN_YEAR_OF_ESTABLISHMENT, canBeNull = false)
    private Integer yearOfEstablishment;

    public MajorModel() {
    }

    public MajorModel(String majorName, String majorCode, Integer yearOfEstablishment) {
        this.majorName = majorName;
        this.majorCode = majorCode;
        this.yearOfEstablishment = yearOfEstablishment;
    }

    public MajorModel(MajorEntity majorEntity) {
        this.majorId = majorEntity.getId();
        this.majorName = majorEntity.getName();
        this.majorCode = majorEntity.getCode();
        this.yearOfEstablishment = majorEntity.getYearOfEstablishment();
    }

    public MajorEntity mapToEntity() {
        return new MajorEntity(majorId, majorName, majorCode, yearOfEstablishment);
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
