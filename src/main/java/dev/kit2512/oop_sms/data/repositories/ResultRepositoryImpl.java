package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.data.daos.ResultDao.ResultDao;
import dev.kit2512.oop_sms.data.daos.ResultDao.ResultDaoImpl;
import dev.kit2512.oop_sms.domain.entities.ResultEntity;
import dev.kit2512.oop_sms.domain.repositories.ResultRepository.ResultException;
import dev.kit2512.oop_sms.domain.repositories.ResultRepository.ResultRepository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

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
    public List<ResultEntity> getUsers() throws ResultException {
        return null;
    }

    @Override
    public List<ResultEntity> getUsers(HashMap<String, Object> filter) throws ResultException {
        return null;
    }

    @Override
    public ResultEntity removeUser(ResultEntity userEntity) throws ResultException {
        return null;
    }

    @Override
    public ResultEntity addUser(ResultEntity userEntity) throws ResultException {
        return null;
    }

    @Override
    public ResultEntity updateUser(ResultEntity oldResultEntity, ResultEntity newSubjectModel) throws ResultException {
        return null;
    }
}
