package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.data.daos.SubjectDao.SubjectDao;
import dev.kit2512.oop_sms.data.daos.UserDao.UserDao;
import dev.kit2512.oop_sms.domain.models.SubjectModel;
import dev.kit2512.oop_sms.domain.repositories.SubjectRepository.SubjectException;
import dev.kit2512.oop_sms.domain.repositories.SubjectRepository.SubjectRepository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

public class SubjectRepositoryImpl implements SubjectRepository {
    private SubjectDao subjectDao;

    @Inject
    public SubjectRepositoryImpl(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }
    @Override
    public List<SubjectModel> getUsers() throws SubjectException {
        return null;
    }

    @Override
    public List<SubjectModel> getUsers(HashMap<String, Object> filter) throws SubjectException {
        return null;
    }

    @Override
    public SubjectModel removeUser(SubjectModel userEntity) throws SubjectException {
        return null;
    }

    @Override
    public SubjectModel addUser(SubjectModel userEntity) throws SubjectException {
        return null;
    }

    @Override
    public SubjectModel updateUser(SubjectModel oldSubjectModel, SubjectModel newSubjectModel) throws SubjectException {
        return null;
    }
}
