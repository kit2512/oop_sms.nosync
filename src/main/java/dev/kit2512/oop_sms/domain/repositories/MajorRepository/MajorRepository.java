package dev.kit2512.oop_sms.domain.repositories.MajorRepository;

import dev.kit2512.oop_sms.domain.entities.MajorEntity;

import java.util.HashMap;
import java.util.List;

public interface MajorRepository {
    List<MajorEntity> getMajors() throws MajorException;

    List<MajorEntity> getMajors(HashMap<String, Object> filter) throws MajorException;

    MajorEntity removeMajor(MajorEntity userEntity) throws MajorException;

    MajorEntity addMajor(MajorEntity userEntity) throws MajorException;

    MajorEntity updateMajor(MajorEntity oldMajorModel, MajorEntity newMajorModel) throws MajorException;
}

