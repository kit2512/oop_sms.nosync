package dev.kit2512.oop_sms.domain.repositories.SubjectRepository;

import dev.kit2512.oop_sms.domain.entities.SubjectEntity;

import java.util.HashMap;
import java.util.List;

public interface SubjectRepository {
    List<SubjectEntity> getUsers() throws SubjectException;

    List<SubjectEntity> getUsers(HashMap<String, Object> filter) throws SubjectException;

    SubjectEntity removeUser(SubjectEntity userEntity) throws SubjectException;

    SubjectEntity addUser(SubjectEntity userEntity) throws SubjectException;

    SubjectEntity updateUser(SubjectEntity oldSubjectEntity, SubjectEntity newSubjectEntity) throws SubjectException;
}
