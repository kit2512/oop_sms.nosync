package dev.kit2512.oop_sms.config.injectors;

import dagger.Module;
import dagger.Provides;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRespository.AuthenticationRepository;
import dev.kit2512.oop_sms.domain.repositories.MajorRepository.MajorRepository;
import dev.kit2512.oop_sms.domain.repositories.ResultRepository.ResultRepository;
import dev.kit2512.oop_sms.domain.repositories.StaffRepository.StaffRepository;
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
    private MajorRepository majorRepository;

    private StaffRepository staffRepository;


    public RepositoryModule(AuthenticationRepository authenticationRepository, ResultRepository resultRepository, SubjectRepository subjectRepository, StudentRepository studentRepository, UserRepository userRepository, MajorRepository majorRepository, StaffRepository staffRepository) {
        this.authenticationRepository = authenticationRepository;
        this.resultRepository = resultRepository;
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.majorRepository = majorRepository;
        this.staffRepository = staffRepository;
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
    
    @Provides
    @Singleton
    public MajorRepository getMajorRepository() {
        return majorRepository;
    }

    @Provides
    @Singleton
    public  StaffRepository staffRepository() {return staffRepository;}
}
