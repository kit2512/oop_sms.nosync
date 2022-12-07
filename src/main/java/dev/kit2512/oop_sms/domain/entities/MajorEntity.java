package dev.kit2512.oop_sms.domain.entities;

import dev.kit2512.oop_sms.data.models.MajorModel;

public class MajorEntity extends BaseEntity {
    private Integer id;
    private String name;
    private String code;

    public Integer getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public void setYearOfEstablishment(Integer yearOfEstablishment) {
        this.yearOfEstablishment = yearOfEstablishment;
    }

    private Integer yearOfEstablishment;

    public MajorEntity(Integer id, String name, String code, Integer yearOfEstablishment) {
        this.id = id;
        this.name = name;
        this.code = code.toUpperCase();
        this.yearOfEstablishment = yearOfEstablishment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.getCode() + " - " + this.getName();
    }
    
    
}
