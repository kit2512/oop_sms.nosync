package dev.kit2512.oop_sms.config.injectors;

import dagger.Module;
import dagger.Provides;
import dev.kit2512.oop_sms.data.daos.MajorDao.MajorDao;
import dev.kit2512.oop_sms.data.daos.ResultDao.ResultDao;
import dev.kit2512.oop_sms.data.daos.StaffDao.StaffDao;
import dev.kit2512.oop_sms.data.daos.StudentDao.StudentDao;
import dev.kit2512.oop_sms.data.daos.SubjectDao.SubjectDao;
import dev.kit2512.oop_sms.data.daos.UserDao.UserDao;

import javax.inject.Singleton;

@Module
public class DaoModule {
    private UserDao userDao;
    private ResultDao resultDao;
    private StudentDao studentDao;
    private SubjectDao subjectDao;
    private MajorDao majorDao;
    private StaffDao staffDao;

    public DaoModule(UserDao userDao, ResultDao resultDao, StudentDao studentDao, SubjectDao subjectDao, MajorDao majorDao, StaffDao staffDao) {
        this.userDao = userDao;
        this.resultDao = resultDao;
        this.studentDao = studentDao;
        this.subjectDao = subjectDao;
        this.majorDao = majorDao;
        this.staffDao = staffDao;
    }

    @Provides
    @Singleton
    public UserDao getUserDao() {
        return userDao;
    }

    @Provides
    @Singleton
    public ResultDao getResultDao() {
        return resultDao;
    }

    @Provides
    @Singleton
    public StudentDao getStudentDao() {
        return studentDao;
    }

    @Provides
    @Singleton
    public SubjectDao getSubjectDao() {
        return subjectDao;
    }

    @Provides
    @Singleton
    public MajorDao getMajorDao() {
        return majorDao;
    }

    @Provides
    @Singleton
    public StaffDao getStaffDao() {
        return staffDao;
    }
}
