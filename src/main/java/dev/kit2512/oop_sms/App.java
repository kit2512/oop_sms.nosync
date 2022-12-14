/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package dev.kit2512.oop_sms;

import com.formdev.flatlaf.FlatDarkLaf;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import dev.kit2512.oop_sms.config.AppConstants;
import dev.kit2512.oop_sms.config.injectors.AppGraph;
import dev.kit2512.oop_sms.config.injectors.DaggerAppGraph;
import dev.kit2512.oop_sms.config.injectors.DaoModule;
import dev.kit2512.oop_sms.config.injectors.RepositoryModule;
import dev.kit2512.oop_sms.config.injectors.ServiceModule;
import dev.kit2512.oop_sms.data.daos.MajorDao.MajorDaoImpl;
import dev.kit2512.oop_sms.data.daos.ResultDao.ResultDao;
import dev.kit2512.oop_sms.data.daos.ResultDao.ResultDaoImpl;
import dev.kit2512.oop_sms.data.daos.StaffDao.StaffDao;
import dev.kit2512.oop_sms.data.daos.StaffDao.StaffDaoImpl;
import dev.kit2512.oop_sms.data.daos.StudentDao.StudentDao;
import dev.kit2512.oop_sms.data.daos.StudentDao.StudentDaoImpl;
import dev.kit2512.oop_sms.data.daos.SubjectDao.SubjectDao;
import dev.kit2512.oop_sms.data.daos.SubjectDao.SubjectDaoImpl;
import dev.kit2512.oop_sms.data.daos.UserDao.UserDao;
import dev.kit2512.oop_sms.data.daos.UserDao.UserDaoImpl;
import dev.kit2512.oop_sms.data.repositories.*;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRespository.AuthenticationRepository;
import dev.kit2512.oop_sms.domain.repositories.MajorRepository.MajorRepository;
import dev.kit2512.oop_sms.domain.repositories.ResultRepository.ResultRepository;
import dev.kit2512.oop_sms.domain.repositories.StaffRepository.StaffRepository;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentRepository;
import dev.kit2512.oop_sms.domain.repositories.SubjectRepository.SubjectRepository;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserRepository;
import dev.kit2512.oop_sms.services.FileService.FileService;
import dev.kit2512.oop_sms.services.FileService.FileServiceImpl;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author macpro13
 */
public class App {

    private UserDao userDao;
    
    private StudentDao studentDao;
    
    private MajorDaoImpl majorDao;
    
    private ResultDao resultDao;
    
    private SubjectDao subjectDao;

    private StaffDao staffDao;

    private AuthenticationRepository authenticationRepository;

    private UserRepository userRepository;

    private ResultRepository resultRepository;

    private SubjectRepository subjectRepository;

    private MajorRepository majorRepository;

    private StudentRepository studentRepository;

    private StaffRepository staffRepository;

    private DaoModule daoModule;

    private RepositoryModule repositoryModule;
    
    private FileService fileService;
    
    private ServiceModule serviceModule;



    public static AppGraph appGraph;
    
    
    public static void main(String[] args) {
        final App app = new App();
    }

    public App() {
        try {
            /* Set the Nimbus look and feel */
            System.setProperty("log4j.configurationFile","./src/res/log4j2.xml");
            UIManager.setLookAndFeel(new FlatDarkLaf());
            setUpService();
            setUpDaos();
            setUpRepository();
            setUpDagger();
            
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    appGraph.getLoginView().setVisible(true);
                }
            });
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setUpDaos() {
        try {
            JdbcConnectionSource connectionSource = new JdbcConnectionSource(AppConstants.DatabasePath.usersDatabase);
            userDao = new UserDaoImpl(connectionSource);
            studentDao = new StudentDaoImpl(connectionSource);
            majorDao = new MajorDaoImpl(connectionSource);
            subjectDao = new SubjectDaoImpl(connectionSource);
            resultDao = new ResultDaoImpl(connectionSource);
            staffDao = new StaffDaoImpl(connectionSource);

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setUpRepository() {
        authenticationRepository = new AuthenticationRepositoryImpl(userDao);
        userRepository = new UserRepositoryImpl(userDao);
        studentRepository = new StudentRepositoryImpl(studentDao,
                userDao,
                resultDao,
                majorDao,
                subjectDao
        );
        majorRepository = new MajorRepositoryImpl(majorDao);
        resultRepository = new ResultRepositoryImpl(resultDao);
        subjectRepository = new SubjectRepositoryImpl(subjectDao);
        staffRepository = new StaffRepositoryImpl(staffDao);
    }

    private void setUpDagger() {
        daoModule = new DaoModule(
                userDao,
                resultDao,
                studentDao,
                subjectDao,
                majorDao,
                staffDao
        );

        repositoryModule = new RepositoryModule(
                authenticationRepository,
                resultRepository,
                subjectRepository,
                studentRepository,
                userRepository,
                majorRepository,
                staffRepository
        );
        
        serviceModule = new ServiceModule(fileService);

        appGraph = DaggerAppGraph.builder()
                .daoModule(daoModule)
                .repositoryModule(repositoryModule)
                .serviceModule(serviceModule).build();
    }

    private void setUpService() {
        this.fileService = new FileServiceImpl();
    }
}
