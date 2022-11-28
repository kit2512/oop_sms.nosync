package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.data.daos.MajorDao.MajorDao;
import dev.kit2512.oop_sms.domain.entities.MajorEntity;
import dev.kit2512.oop_sms.domain.repositories.MajorRepository.MajorException;
import dev.kit2512.oop_sms.domain.repositories.MajorRepository.MajorRepository;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserException;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

public class MajorRepositoryImpl implements MajorRepository {
    private MajorDao majorDao;

    @Inject
    public MajorRepositoryImpl(MajorDao majorDao) {
        this.majorDao = majorDao;
    }

    @Override
    public List<MajorEntity> getUsers() throws UserException {
        return null;
    }

    @Override
    public List<MajorEntity> getUsers(HashMap<String, Object> filter) throws UserException {
        return null;
    }

    @Override
    public MajorEntity removeUser(MajorEntity userEntity) throws UserException {
        return null;
    }

    @Override
    public MajorEntity addUser(MajorEntity userEntity) throws UserException {
        return null;
    }

    @Override
    public MajorEntity updateUser(MajorEntity oldMajorModel, MajorEntity newMajorModel) throws MajorException {
        return null;
    }
}
