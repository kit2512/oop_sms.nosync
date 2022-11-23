package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.data.daos.StudentDao.StudentDao;
import dev.kit2512.oop_sms.domain.models.StudentModel;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentException;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentRepository;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserException;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private StudentDao studentDao;

    @Inject
    public StudentRepositoryImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<StudentModel> getUsers() throws UserException {
        return null;
    }

    @Override
    public List<StudentModel> getUsers(HashMap<String, Object> filter) throws UserException {
        return null;
    }

    @Override
    public StudentModel removeUser(StudentModel userEntity) throws UserException {
        return null;
    }

    @Override
    public StudentModel addUser(StudentModel userEntity) throws UserException {
        return null;
    }

    @Override
    public StudentModel updateUser(StudentModel oldStudentModel, StudentModel newStudentModel) throws StudentException {
        return null;
    }
}
