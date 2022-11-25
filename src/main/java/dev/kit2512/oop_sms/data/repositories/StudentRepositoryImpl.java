package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.data.daos.MajorDao.MajorDao;
import dev.kit2512.oop_sms.data.daos.ResultDao.ResultDao;
import dev.kit2512.oop_sms.data.daos.StudentDao.StudentDao;
import dev.kit2512.oop_sms.data.daos.SubjectDao.SubjectDao;
import dev.kit2512.oop_sms.data.daos.UserDao.UserDao;
import dev.kit2512.oop_sms.data.entities.ResultEntity;
import dev.kit2512.oop_sms.data.entities.StudentEntity;
import dev.kit2512.oop_sms.data.entities.SubjectEntity;
import dev.kit2512.oop_sms.domain.models.ResultModel;
import dev.kit2512.oop_sms.domain.models.StudentModel;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentException;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentRepository;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private StudentDao studentDao;
    private UserDao userDao;
    private ResultDao resultDao;

    private MajorDao majorDao;

    private SubjectDao subjectDao;
    
    @Inject
    public StudentRepositoryImpl(StudentDao studentDao, UserDao userDao, ResultDao resultDao, MajorDao majorDao, SubjectDao subjectDao) {
        this.studentDao = studentDao;
        this.userDao = userDao;
        this.resultDao = resultDao;
        this.majorDao = majorDao;
        this.subjectDao = subjectDao;

    }

    @Override
    public List<StudentModel> getStudents() throws StudentException {
        final List<StudentModel> studentModels = new ArrayList<>();
        
        try {
            final List<StudentEntity> studentEntities = studentDao.queryForAll();


            for (StudentEntity studentEntity : studentEntities) {
                userDao.refresh(studentEntity.getUser());
                majorDao.refresh(studentEntity.getMajor());

                final StudentModel studentModel = new StudentModel(studentEntity);
                final ArrayList<ResultModel> resultModels = new ArrayList<>();

                for (ResultEntity resultEntity : studentEntity.getResultEntities()) {
                    resultDao.refresh(resultEntity);
                    subjectDao.refresh(resultEntity.getSubjectEntity());
                    resultModels.add(new ResultModel(resultEntity));
                }
                studentModel.setResults(resultModels);
                studentModels.add(studentModel);
            }
        } catch (SQLException ex) {
            throw new StudentException("Unable to get students");
        }
        return studentModels;
    }

    @Override
    public List<StudentModel> getStudents(HashMap<String, Object> filter) throws StudentException {
        return null;
    }

    @Override
    public StudentModel removeUser(StudentModel userEntity) throws StudentException {
        return null;
    }

    @Override
    public StudentModel addUser(StudentModel userEntity) throws StudentException {
        return null;
    }

    @Override
    public StudentModel updateUser(StudentModel oldStudentModel, StudentModel newStudentModel) throws StudentException {
        return null;
    }
   
}
