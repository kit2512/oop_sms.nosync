/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.config.injectors;

import dagger.Component;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRespository.AuthenticationRepository;
import dev.kit2512.oop_sms.domain.repositories.StaffRepository.StaffRepository;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentRepository;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserRepository;
import dev.kit2512.oop_sms.domain.usecases.AddStudentUseCase;
import dev.kit2512.oop_sms.domain.usecases.CreateUserUseCase;
import dev.kit2512.oop_sms.domain.usecases.GetMajorListUseCase;
import dev.kit2512.oop_sms.domain.usecases.GetStudentListUseCase;
import dev.kit2512.oop_sms.domain.usecases.GetUserInfoUseCase;
import dev.kit2512.oop_sms.domain.usecases.LoginUseCase;
import dev.kit2512.oop_sms.domain.usecases.UpdateUserInfoUseCase;
import dev.kit2512.oop_sms.presentation.controllers.*;
import dev.kit2512.oop_sms.presentation.models.AddStudentModel;
import dev.kit2512.oop_sms.presentation.models.DashboardModel;
import dev.kit2512.oop_sms.presentation.models.LoginModel;
import dev.kit2512.oop_sms.presentation.models.StudentListModel;
import dev.kit2512.oop_sms.presentation.views.AddStudentView;
import dev.kit2512.oop_sms.presentation.views.DashboardView.DashboardView;
import dev.kit2512.oop_sms.presentation.views.InfoView.InforView;
import dev.kit2512.oop_sms.presentation.views.LoginView;
import dev.kit2512.oop_sms.presentation.views.UpdatePasswordView;

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

    AuthenticationRepository getAuthenticationRepository();

    StudentRepository getStudentRepository();

    UserRepository getUserRepository();

    StaffRepository getStaffRepository();

    LoginUseCase getLoginUseCase();

    CreateUserUseCase getCreateUserUseCase();

    GetStudentListUseCase getStudentListUseCase();

    LoginModel getLoginModel();

    LoginController getLoginController();


    LoginView getLoginView();


    InforView getInfoView();

    DashboardModel getDashboardModel();


    DashboardController getDashboardController();

    InfoController getInfoController();

    DashboardView getDashboardView();

    GetUserInfoUseCase getUserInfoUseCase();

    AddStudentUseCase getAddStudentUseCase();

    AddStudentModel getAddStudentModel();

    AddStudentController getAddStudentController();
    
    AddStudentView getAddStudentView();

    GetMajorListUseCase getMajorListUseCase();

    StudentListModel getStudentListModel();
    
    UpdatePasswordController getUpdatePasswordController();
    
    UpdateUserInfoUseCase getUpdatePasswordUseCase();
    
    UpdatePasswordView getUpdatePasswordView();

    StudentListController getStudentListController();
}
