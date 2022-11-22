/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.config.injectors;

import dagger.Component;
import dev.kit2512.oop_sms.data.repositories.AuthenticationRepositoryImpl;
import dev.kit2512.oop_sms.domain.usecases.LoginUseCase;
import dev.kit2512.oop_sms.presentation.controllers.LoginController;
import dev.kit2512.oop_sms.presentation.models.LoginModel;
import dev.kit2512.oop_sms.presentation.views.LoginView;

import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */


@Singleton
@Component(modules = UserDaoModule.class)
public interface AppGraph {
    AuthenticationRepositoryImpl getAuthenticationRepository();

    LoginUseCase getLoginUseCase();

    LoginModel getLoginModel();

    LoginController getLoginController();

    LoginView getLoginView();
}
