package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.data.daos.ResultDao.ResultDao;
import dev.kit2512.oop_sms.data.daos.ResultDao.ResultDaoImpl;
import dev.kit2512.oop_sms.data.entities.UserEntity;
import dev.kit2512.oop_sms.domain.models.ResultModel;
import dev.kit2512.oop_sms.domain.models.UserModel;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRespository.AuthenticationException;
import dev.kit2512.oop_sms.domain.repositories.ResultRepository.ResultException;
import dev.kit2512.oop_sms.domain.repositories.ResultRepository.ResultRepository;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultRepositoryImpl implements ResultRepository {
    private ResultDao resultDao;

    @Inject
    public ResultRepositoryImpl(ResultDao resultDao) {
        this.resultDao = resultDao;
    }

    public void setResultDao(ResultDaoImpl resultDao) {
        this.resultDao = resultDao;
    }


    @Override
    public List<ResultModel> getUsers() throws ResultException {
        return null;
    }

    @Override
    public List<ResultModel> getUsers(HashMap<String, Object> filter) throws ResultException {
        return null;
    }

    @Override
    public ResultModel removeUser(ResultModel userEntity) throws ResultException {
        return null;
    }

    @Override
    public ResultModel addUser(ResultModel userEntity) throws ResultException {
        return null;
    }

    @Override
    public ResultModel updateUser(ResultModel oldResultModel, ResultModel newSubjectModel) throws ResultException {
        return null;
    }
}
