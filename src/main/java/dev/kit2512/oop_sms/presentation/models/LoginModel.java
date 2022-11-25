package dev.kit2512.oop_sms.presentation.models;

import dev.kit2512.oop_sms.config.AppConstants;
import dev.kit2512.oop_sms.config.exceptions.LoginException;
import dev.kit2512.oop_sms.domain.models.UserModel;
import dev.kit2512.oop_sms.domain.usecases.LoginUseCase;

import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author macpro13
 */
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



    private UserModel user;

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
                throw new LoginException("Username must not be empty");
            }

//            if (!username.matches(AppConstants.StringPattern.usernamePattern)) {
//                throw new LoginException("Username is not valid");
//            }

            if (username.length() <= 8 || username.length() >= 16) {
                throw new LoginException("Username must be between 8 and 16 characters");
            }

            if (password.isEmpty()) {
                throw new LoginException("Password must not be empty");
            }

            if (password.length() <= 8 ) {
                throw new LoginException("Password must be at least 8 characters");
            }

            final UserModel userModel = loginUseCase.excecute(this.username, this.password);
            setErrorMessage(null);
            setSuccess(true);
            setUser(userModel);
        } catch (LoginException ex) {
            setSuccess(false);
            setErrorMessage(ex.getMessage());
            ex.printStackTrace();
        }
        super.firePropertyChange(IS_LOADING_PROPERTY, isLoading, !isLoading);
    }

    public void setUser(UserModel user) {
        final UserModel oldValue = this.user;
        this.user = user;
        firePropertyChange(USER_PROPERTY, oldValue, user);
    }
}
