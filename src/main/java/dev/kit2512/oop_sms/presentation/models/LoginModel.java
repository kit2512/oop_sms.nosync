package dev.kit2512.oop_sms.presentation.models;

import dev.kit2512.oop_sms.domain.entities.UserEntity;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRespository.AuthenticationException;
import dev.kit2512.oop_sms.domain.usecases.LoginUseCase;

import javax.inject.Inject;
import javax.inject.Singleton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author macpro13
 */
@Singleton
public class LoginModel extends AbstractModel {

    public static final String USERNAME_PROPERTY = "Username";
    public static final String PASSWORD_PORPERTY = "Password";
    public static final String ERROR_MESSAGE_PROPERTY = "ErrorMessage";
    public static final String IS_LOADING_PROPERTY = "IsLoading";
    public static final String SUCCESS_PROPERTY = "Success";

    public static final String USER_PROPERTY = "User";
    private String username;
    private String password;
    private String errorMessage;
    private boolean success;



    private UserEntity user;

    private final LoginUseCase loginUseCase;

    @Inject
    public LoginModel(LoginUseCase loginUseCase) {
        this.username = "";
        this.password = "";
        this.errorMessage = null;
        this.loginUseCase = loginUseCase;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void setSuccess(boolean success) {
        final boolean oldValue = this.success;
        this.success = success;
        super.firePropertyChange(SUCCESS_PROPERTY, oldValue, success);
    }

    public void setErrorMessage(String errorMessage) {
        final String oldValue = this.errorMessage;
        this.errorMessage = errorMessage;
        super.firePropertyChange(ERROR_MESSAGE_PROPERTY, oldValue, errorMessage);
    }

    public void setIsLoading(Boolean isLoading) {
        super.firePropertyChange(IS_LOADING_PROPERTY, !isLoading, isLoading);
        try {
            if (username.isEmpty()) {
                throw new AuthenticationException("Username must not be empty");
            }

//            if (!username.matches(AppConstants.StringPattern.usernamePattern)) {
//                throw new LoginException("Username is not valid");
//            }

            if (username.length() <= 8 || username.length() >= 16) {
                throw new AuthenticationException("Username must be between 8 and 16 characters");
            }

            if (password.isEmpty()) {
                throw new AuthenticationException("Password must not be empty");
            }

            if (password.length() <= 8 ) {
                throw new AuthenticationException("Password must be at least 8 characters");
            }

            final UserEntity userEntity = loginUseCase.execute(this.username, this.password);
            setErrorMessage(null);
            setSuccess(true);
            setUser(userEntity);
        } catch (AuthenticationException ex) {
            setSuccess(false);
            setErrorMessage(ex.getMessage());
            ex.printStackTrace();
        }
        super.firePropertyChange(IS_LOADING_PROPERTY, isLoading, !isLoading);
    }

    public void setUser(UserEntity user) {
        final UserEntity oldValue = this.user;
        this.user = user;
        firePropertyChange(USER_PROPERTY, oldValue, user);
    }
}
