/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.domain.usecases;

import dev.kit2512.oop_sms.domain.models.UserModel;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRespository.AuthenticationException;
import dev.kit2512.oop_sms.config.exceptions.LoginException;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRespository.AuthenticationRepository;
import javax.inject.Inject;

/**
 *
 * @author macpro13
 */
public class LoginUseCase{
    @Inject
    public  AuthenticationRepository authenticationRepository;
    
    @Inject
    public LoginUseCase(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }
    
    public UserModel excecute(String username, String password) throws LoginException {
        try {
            final UserModel userModel = authenticationRepository.logIn(username, password);
            if (userModel == null) {
                throw new LoginException("Username or password is incorrect");
            }
            return userModel;
        } catch (AuthenticationException ex) {
            throw new LoginException(ex.getMessage());
        } catch (IndexOutOfBoundsException ex) {
            throw new LoginException("UserEntity not found");
        }
    }
}
