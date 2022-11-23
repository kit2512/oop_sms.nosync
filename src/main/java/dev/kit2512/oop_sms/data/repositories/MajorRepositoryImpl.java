package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.data.daos.MajorDao.MajorDao;
import dev.kit2512.oop_sms.domain.models.MajorModel;
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
    public List<MajorModel> getUsers() throws UserException {
        return null;
    }

    @Override
    public List<MajorModel> getUsers(HashMap<String, Object> filter) throws UserException {
        return null;
    }

    @Override
    public MajorModel removeUser(MajorModel userEntity) throws UserException {
        return null;
    }

    @Override
    public MajorModel addUser(MajorModel userEntity) throws UserException {
        return null;
    }

    @Override
    public MajorModel updateUser(MajorModel oldMajorModel, MajorModel newMajorModel) throws MajorException {
        return null;
    }
}
