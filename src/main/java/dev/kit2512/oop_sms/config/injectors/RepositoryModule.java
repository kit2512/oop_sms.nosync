package dev.kit2512.oop_sms.config.injectors;

import dagger.Module;
import dagger.Provides;
import dev.kit2512.oop_sms.data.daos.MajorDao.MajorDao;
import dev.kit2512.oop_sms.data.daos.ResultDao.ResultDao;
import dev.kit2512.oop_sms.data.daos.SubjectDao.SubjectDao;
import dev.kit2512.oop_sms.data.daos.UserDao.UserDao;
import dev.kit2512.oop_sms.data.repositories.*;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRespository.AuthenticationRepository;
import dev.kit2512.oop_sms.domain.repositories.MajorRepository.MajorRepository;
import dev.kit2512.oop_sms.domain.repositories.ResultRepository.ResultRepository;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentRepository;
import dev.kit2512.oop_sms.domain.repositories.SubjectRepository.SubjectRepository;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserRepository;

import javax.inject.Singleton;

@Module()
public class RepositoryModule {
    private AuthenticationRepository authenticationRepository;
    private ResultRepository resultRepository;
    private SubjectRepository subjectRepository;
    private StudentRepository studentRepository;
    private UserRepository userRepository;


    public RepositoryModule(AuthenticationRepository authenticationRepository, ResultRepository resultRepository, SubjectRepository subjectRepository, StudentRepository studentRepository, UserRepository userRepository) {
        this.authenticationRepository = authenticationRepository;
        this.resultRepository = resultRepository;
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    @Provides
    @Singleton
    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }

    @Provides
    @Singleton
    public ResultRepository getResultRepository() {
        return resultRepository;
    }

    @Provides
    @Singleton
    public SubjectRepository getSubjectRepository() {
        return subjectRepository;
    }

    @Provides
    @Singleton
    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    @Provides
    @Singleton
    public UserRepository getUserRepository() {
        return userRepository;
    }
}
