package dev.kit2512.oop_sms.domain.repositories.ResultRepository;

import dev.kit2512.oop_sms.domain.entities.ResultEntity;

import java.util.HashMap;
import java.util.List;

public interface ResultRepository {
    List<ResultEntity> getUsers() throws ResultException;

    List<ResultEntity> getUsers(HashMap<String, Object> filter) throws ResultException;

    ResultEntity removeUser(ResultEntity userEntity) throws ResultException;

    ResultEntity addUser(ResultEntity userEntity) throws ResultException;

    ResultEntity updateUser(ResultEntity oldResultEntity, ResultEntity newSubjectModel) throws ResultException;
}
