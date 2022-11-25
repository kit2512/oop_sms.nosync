/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.config.injectors;

import dagger.Component;
import dev.kit2512.oop_sms.data.repositories.AuthenticationRepositoryImpl;
import dev.kit2512.oop_sms.data.repositories.StudentRepositoryImpl;
import dev.kit2512.oop_sms.data.repositories.UserRepositoryImpl;
import dev.kit2512.oop_sms.domain.usecases.CreateUserUseCase;
import dev.kit2512.oop_sms.domain.usecases.GetStudentListUseCase;
import dev.kit2512.oop_sms.domain.usecases.LoginUseCase;
import dev.kit2512.oop_sms.presentation.controllers.DashboardController;
import dev.kit2512.oop_sms.presentation.controllers.LoginController;
import dev.kit2512.oop_sms.presentation.models.DashboardModel;
import dev.kit2512.oop_sms.presentation.models.LoginModel;
import dev.kit2512.oop_sms.presentation.views.DashboardView.DashboardView;
import dev.kit2512.oop_sms.presentation.views.LoginView;

import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */


@Singleton
@Component(
        modules = {
                RepositoryModule.class,
                DaoModule.class
        }
)
public interface AppGraph {

    AuthenticationRepositoryImpl getAuthenticationRepository();

    StudentRepositoryImpl getStudentRepository();

    UserRepositoryImpl getUserRepository();
    
    // use cases
    LoginUseCase getLoginUseCase();
    
    CreateUserUseCase getCreateUserUseCase();
    
    GetStudentListUseCase getStudentListUseCase();

    LoginModel getLoginModel();

    LoginController getLoginController();

    LoginView getLoginView();
    
    DashboardModel getDashboardModel();
    
    DashboardController getDashboardController();
    
    DashboardView getDashboardView();

}
