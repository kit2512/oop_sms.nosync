package dev.kit2512.oop_sms.domain.repositories.ResultRepository;

import dev.kit2512.oop_sms.domain.models.ResultModel;

import java.util.HashMap;
import java.util.List;

public interface ResultRepository {
    List<ResultModel> getUsers() throws ResultException;

    List<ResultModel> getUsers(HashMap<String, Object> filter) throws ResultException;

    ResultModel removeUser(ResultModel userEntity) throws ResultException;

    ResultModel addUser(ResultModel userEntity) throws ResultException;

    ResultModel updateUser(ResultModel oldResultModel, ResultModel newSubjectModel) throws ResultException;
}
