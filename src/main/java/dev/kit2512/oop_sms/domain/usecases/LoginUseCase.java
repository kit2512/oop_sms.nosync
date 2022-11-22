/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.domain.usecases;

import dev.kit2512.oop_sms.config.exceptions.AuthenticationException;
import dev.kit2512.oop_sms.config.exceptions.LoginException;
import dev.kit2512.oop_sms.data.models.User;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRepository;
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
    
    public User excecute(String username, String password) throws LoginException {
        try {
            final User user = authenticationRepository.logIn(username, password);
            if (user == null) {
                throw new LoginException("Username or password is incorrect");
            }
            return user;
        } catch (AuthenticationException ex) {
            throw new LoginException(ex.getMessage());
        } catch (IndexOutOfBoundsException ex) {
            throw new LoginException("User not found");
        }
    }
}
