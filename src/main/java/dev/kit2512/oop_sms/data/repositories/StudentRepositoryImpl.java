package dev.kit2512.oop_sms.data.repositories;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.Where;
import dev.kit2512.oop_sms.data.daos.MajorDao.MajorDao;
import dev.kit2512.oop_sms.data.daos.ResultDao.ResultDao;
import dev.kit2512.oop_sms.data.daos.StudentDao.StudentDao;
import dev.kit2512.oop_sms.data.daos.SubjectDao.SubjectDao;
import dev.kit2512.oop_sms.data.daos.UserDao.UserDao;
import dev.kit2512.oop_sms.data.models.ResultModel;
import dev.kit2512.oop_sms.data.models.StudentModel;
import dev.kit2512.oop_sms.data.models.UserModel;
import dev.kit2512.oop_sms.domain.entities.ResultEntity;
import dev.kit2512.oop_sms.domain.entities.StudentEntity;
import dev.kit2512.oop_sms.domain.entities.UserEntity;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentException;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentRepository;
import java.sql.SQLException;
import java.util.*;

import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentRepositoryImpl implements StudentRepository {

    static final Random random = new Random(new Date().getTime());

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
                userDao.refresh(studentModel.user);
                majorDao.refresh(studentModel.major);

                final StudentEntity studentEntity = studentModel.mapToEntity();
                final ArrayList<ResultEntity> resultEntities = new ArrayList<>();

                for (ResultModel resultModel : studentModel.getResultEntities()) {
                    resultDao.refresh(resultModel);
                    subjectDao.refresh(resultModel.getSubjectModel());
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
    public StudentEntity removeStudent(Integer userId) throws StudentException {
        try {
            final StudentEntity student = getStudent(userId);
            for (ResultEntity result : student.getResults()) {
                resultDao.deleteById(result.getResultId());
            }
            studentDao.deleteById(student.getStudentId());
            userDao.deleteById(student.getUserId());
            return student;
        } catch (StudentException | SQLException ex) {
            throw new StudentException(ex.getMessage());
        }
    }

    @Override
    public Integer addStudent(StudentEntity newStudent) throws StudentException {
        UserModel createdUserModel;
        try {
            final UserModel userModel = new UserModel(newStudent);

            if (newStudent.getUsername() != null) {
                userModel.setUsername(newStudent.getUsername());
                userModel.setPassword(newStudent.getPassword());
            } else {
                final String generatedUserName = newStudent.getMajor().getCode() + newStudent.getYearOfAdmission() + random.nextInt();
                final String generatedPassword = "@" + generatedUserName + "SMS";
                userModel.setUsername(generatedUserName);
                userModel.setPassword(generatedPassword);
                newStudent.setPassword(generatedPassword);
                newStudent.setUsername(generatedUserName);
            }

            userDao.create(userModel);

            QueryBuilder<UserModel, Integer> queryBuilder = userDao.queryBuilder();
            Where<UserModel, Integer> where = queryBuilder.where();
            SelectArg selectArg = new SelectArg();
            where.eq("user_username", selectArg);
            selectArg.setValue(userModel.getUserUsername());
            PreparedQuery<UserModel> preparedQuery = queryBuilder.prepare();

            createdUserModel = userDao.queryForFirst(preparedQuery);
            newStudent.setUserId(createdUserModel.getUserId());

        } catch (SQLException ex) {
            Logger.getLogger(StudentRepositoryImpl.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            throw new StudentException("Unable to create new user");
        }

        if (createdUserModel != null) {
            try {
                StudentModel studentModel = new StudentModel(newStudent);
                studentModel.setUser(createdUserModel);
                return studentDao.create(studentModel);
            } catch (SQLException ex) {
                try {
                    userDao.delete(createdUserModel);
                } catch (SQLException ex1) {
                    throw new StudentException(ex.getMessage());
                }
                throw new StudentException("Unable to create new Student");
            }
        } else {
            throw new StudentException("Unable to create user");
        }
    }

    @Override
    public StudentEntity updateStudent(StudentEntity oldStudentModel, StudentEntity newStudentModel) throws StudentException {
        return null;
    }

    @Override
    public StudentEntity getStudent(Integer userId) throws StudentException {
        try {
            final QueryBuilder<StudentModel, Integer> queryBuilder = studentDao.queryBuilder();
            final Where<StudentModel, Integer> where = queryBuilder.where();
            final SelectArg selectArg = new SelectArg();
            where.eq("user_id", selectArg);
            selectArg.setValue(userId);
            final PreparedQuery<StudentModel> preparedQuery = queryBuilder.prepare();
            final StudentModel studentModel = studentDao.queryForFirst(preparedQuery);
            userDao.refresh(studentModel.user);
            majorDao.refresh(studentModel.major);
            for (ResultModel resultModel : studentModel.getResultEntities()) {
                resultDao.refresh(resultModel);
                subjectDao.refresh(resultModel.getSubjectModel());
            }
            return studentModel.mapToEntity();
        } catch (SQLException e) {
            throw new StudentException("Unable to get student");
        }
    }
}
