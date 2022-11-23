package dev.kit2512.oop_sms.domain.repositories.MajorRepository;

import dev.kit2512.oop_sms.domain.models.MajorModel;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserException;

import java.util.HashMap;
import java.util.List;

public interface MajorRepository {
    List<MajorModel> getUsers() throws UserException;

    List<MajorModel> getUsers(HashMap<String, Object> filter) throws UserException;

    MajorModel removeUser(MajorModel userEntity) throws UserException;

    MajorModel addUser(MajorModel userEntity) throws UserException;

    MajorModel updateUser(MajorModel oldMajorModel, MajorModel newMajorModel) throws MajorException;
}

