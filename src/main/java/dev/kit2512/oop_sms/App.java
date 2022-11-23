/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package dev.kit2512.oop_sms;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import dev.kit2512.oop_sms.config.AppConstants;
import dev.kit2512.oop_sms.config.injectors.AppGraph;
import dev.kit2512.oop_sms.config.injectors.DaggerAppGraph;
import dev.kit2512.oop_sms.config.injectors.DaoModule;
import dev.kit2512.oop_sms.config.injectors.RepositoryModule;
import dev.kit2512.oop_sms.data.daos.MajorDao.MajorDaoImpl;
import dev.kit2512.oop_sms.data.daos.ResultDao.ResultDao;
import dev.kit2512.oop_sms.data.daos.ResultDao.ResultDaoImpl;
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
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentRepository;
import dev.kit2512.oop_sms.domain.repositories.SubjectRepository.SubjectRepository;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserRepository;
import dev.kit2512.oop_sms.presentation.controllers.LoginController;
import dev.kit2512.oop_sms.presentation.models.AbstractModel;
import dev.kit2512.oop_sms.presentation.models.LoginModel;
import dev.kit2512.oop_sms.presentation.views.AbstractView;
import dev.kit2512.oop_sms.presentation.views.LoginView;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author macpro13
 */
public class App {

    private UserDao userDao;
    private StudentDao studentDao;
    private MajorDaoImpl majorDao;
    private ResultDao resultDao;
    private SubjectDao subjectDao;

    private AuthenticationRepository authenticationRepository;

    private UserRepository userRepository;

    private ResultRepository resultRepository;

    private SubjectRepository subjectRepository;

    private MajorRepository majorRepository;

    private StudentRepository studentRepository;

    private DaoModule daoModule;

    private RepositoryModule repositoryModule;

    private AppGraph appGraph;
    public static void main(String[] args) {
        final App app = new App();

    }

    public App() {
        setUpDaos();
        setUpRepository();
        setUpDagger();
        initUI();
    }

    private void initUI() {
        final LoginController loginController = appGraph.getLoginController();
        final LoginView loginView = appGraph.getLoginView();
        loginController.addView(loginView);
        loginView.setVisible(true);
    }

    private void setUpDaos() {
        try {
            JdbcConnectionSource connectionSource = new JdbcConnectionSource(AppConstants.DatabasePath.usersDatabase);
            userDao = new UserDaoImpl(connectionSource);
            studentDao = new StudentDaoImpl(connectionSource);
            majorDao = new MajorDaoImpl(connectionSource);
            subjectDao = new SubjectDaoImpl(connectionSource);
            resultDao = new ResultDaoImpl(connectionSource);

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setUpRepository() {
        authenticationRepository = new AuthenticationRepositoryImpl(userDao);
        userRepository = new UserRepositoryImpl(userDao);
        studentRepository = new StudentRepositoryImpl(studentDao);
        majorRepository = new MajorRepositoryImpl(majorDao);
        resultRepository = new ResultRepositoryImpl(resultDao);
        subjectRepository = new SubjectRepositoryImpl(subjectDao);
    }

    private void setUpDagger() {
        daoModule = new DaoModule(
                userDao,
                resultDao,
                studentDao,
                subjectDao,
                majorDao
        );

        repositoryModule = new RepositoryModule(
                authenticationRepository,
                resultRepository,
                subjectRepository,
                studentRepository,
                userRepository
        );

        appGraph = DaggerAppGraph.builder()
                .daoModule(daoModule)
                .repositoryModule(repositoryModule).build();
    }
}
