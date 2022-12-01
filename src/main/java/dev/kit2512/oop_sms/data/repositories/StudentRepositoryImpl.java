package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.data.daos.MajorDao.MajorDao;
import dev.kit2512.oop_sms.data.daos.ResultDao.ResultDao;
import dev.kit2512.oop_sms.data.daos.StudentDao.StudentDao;
import dev.kit2512.oop_sms.data.daos.SubjectDao.SubjectDao;
import dev.kit2512.oop_sms.data.daos.UserDao.UserDao;
import dev.kit2512.oop_sms.data.models.ResultModel;
import dev.kit2512.oop_sms.data.models.StudentModel;
import dev.kit2512.oop_sms.domain.entities.ResultEntity;
import dev.kit2512.oop_sms.domain.entities.StudentEntity;
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
    public List<StudentEntity> getStudents() throws StudentException {
        final List<StudentEntity> studentEntities = new ArrayList<>();
        
        try {
            final List<StudentModel> studentModelList = studentDao.queryForAll();

            for (StudentModel studentModel : studentModelList) {
                userDao.refresh(studentModel.getUser());
                majorDao.refresh(studentModel.getMajor());

                final StudentEntity studentEntity = studentModel.mapToEntity();
                final ArrayList<ResultEntity> resultEntities = new ArrayList<>();

                for (ResultModel resultModel : studentModel.getResultEntities()) {
                    resultDao.refresh(resultModel);
                    subjectDao.refresh(resultModel.getSubjectEntity());
                    resultEntities.add(resultModel.mapToEntity());
                }
                studentEntity.setResults(resultEntities);
                studentEntities.add(studentEntity);
            }
        } catch (SQLException ex) {
            throw new StudentException("Unable to get students");
        }
        return studentEntities;
    }

    @Override
    public List<StudentEntity> getStudents(HashMap<String, Object> filter) throws StudentException {
        return null;
    }

    @Override
    public StudentEntity removeStudent(StudentEntity userEntity) throws StudentException {
        return null;
    }

    @Override
    public StudentEntity addStudent(StudentEntity userEntity) throws StudentException {
        return null;
    }

    @Override
    public StudentEntity updateStudent(StudentEntity oldStudentModel, StudentEntity newStudentModel) throws StudentException {
        return null;
    }
   
}
