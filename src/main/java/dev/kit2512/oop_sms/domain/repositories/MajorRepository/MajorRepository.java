package dev.kit2512.oop_sms.domain.repositories.MajorRepository;

import dev.kit2512.oop_sms.domain.entities.MajorEntity;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserException;

import java.util.HashMap;
import java.util.List;

public interface MajorRepository {
    List<MajorEntity> getUsers() throws UserException;

    List<MajorEntity> getUsers(HashMap<String, Object> filter) throws UserException;

    MajorEntity removeUser(MajorEntity userEntity) throws UserException;

    MajorEntity addUser(MajorEntity userEntity) throws UserException;

    MajorEntity updateUser(MajorEntity oldMajorModel, MajorEntity newMajorModel) throws MajorException;
}

