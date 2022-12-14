/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.domain.usecases;

import dev.kit2512.oop_sms.domain.entities.UserEntity;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRespository.AuthenticationException;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRespository.AuthenticationRepository;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */
@Singleton
public class LoginUseCase{
    @Inject
    public  AuthenticationRepository authenticationRepository;
    
    @Inject
    public LoginUseCase(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }
    
    public UserEntity execute(String username, String password) throws AuthenticationException {
            final UserEntity userEntity = authenticationRepository.logIn(username, password);
            if (userEntity == null) {
                throw new AuthenticationException("Username or password is incorrect");
            }
            return userEntity;
    }
}
