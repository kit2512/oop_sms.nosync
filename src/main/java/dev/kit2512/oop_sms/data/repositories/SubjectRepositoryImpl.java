package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.data.daos.SubjectDao.SubjectDao;
import dev.kit2512.oop_sms.domain.entities.SubjectEntity;
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
    public List<SubjectEntity> getUsers() throws SubjectException {
        return null;
    }

    @Override
    public List<SubjectEntity> getUsers(HashMap<String, Object> filter) throws SubjectException {
        return null;
    }

    @Override
    public SubjectEntity removeUser(SubjectEntity userEntity) throws SubjectException {
        return null;
    }

    @Override
    public SubjectEntity addUser(SubjectEntity userEntity) throws SubjectException {
        return null;
    }

    @Override
    public SubjectEntity updateUser(SubjectEntity oldSubjectEntity, SubjectEntity newSubjectEntity) throws SubjectException {
        return null;
    }
}
