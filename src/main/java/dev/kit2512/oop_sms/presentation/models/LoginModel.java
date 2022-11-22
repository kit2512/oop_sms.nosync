package dev.kit2512.oop_sms.presentation.models;

import dev.kit2512.oop_sms.config.exceptions.LoginException;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRepository;
import dev.kit2512.oop_sms.domain.usecases.LoginUseCase;

import javax.inject.Inject;

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

    private String username;
    private String password;
    private String errorMessage;
    private boolean success;

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
            } else {
                if (password.isEmpty()) {
                    throw new LoginException("Password must not be empty");
                } else {
                    loginUseCase.excecute(this.username, this.password);
                    setErrorMessage(null);
                    setSuccess(true);
                }
            }

        } catch (LoginException ex) {
            setSuccess(false);
            setErrorMessage(ex.getMessage());
            ex.printStackTrace();
        }
        super.firePropertyChange(IS_LOADING_PROPERTY, isLoading, !isLoading);
    }
}
