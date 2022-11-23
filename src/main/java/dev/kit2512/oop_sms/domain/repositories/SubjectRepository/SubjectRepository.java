package dev.kit2512.oop_sms.domain.repositories.SubjectRepository;

import dev.kit2512.oop_sms.domain.models.SubjectModel;

import java.util.HashMap;
import java.util.List;

public interface SubjectRepository {
    List<SubjectModel> getUsers() throws SubjectException;

    List<SubjectModel> getUsers(HashMap<String, Object> filter) throws SubjectException;

    SubjectModel removeUser(SubjectModel userEntity) throws SubjectException;

    SubjectModel addUser(SubjectModel userEntity) throws SubjectException;

    SubjectModel updateUser(SubjectModel oldSubjectModel, SubjectModel newSubjectModel) throws SubjectException;
}
