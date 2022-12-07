/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.models;

import dev.kit2512.oop_sms.domain.entities.UserEntity;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserException;
import dev.kit2512.oop_sms.domain.usecases.GetUserInfoUseCase;
import javax.inject.Inject;


/**
 *
 * @author macpro13
 */
public class InfoModel extends AbstractModel {
    private UserEntity user;
    
    public static final String USER_PROPERTY = "User";
    
    public static final String USER_ID = "UserId";
    
    public static final String ERROR_MESSAGE_PROPERTY = "ErrorMessage";
    
    public static final String LOADING_USER_PROPERTY  = "LoadingUser";
    
    public static final String CLOSE_PROPERTY = "Close";
    
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }
    
    private String errorMessage;
    
    private GetUserInfoUseCase getUserInfoUseCase;
    
    private Boolean loadingUser = false;
    
    @Inject
    public InfoModel(GetUserInfoUseCase getUserInfoUseCase) {
        this.getUserInfoUseCase = getUserInfoUseCase;
    }
    
    public void setUser(UserEntity userEntity) {
        final UserEntity oldValue = this.user;
        this.user = userEntity;
        super.firePropertyChange(USER_PROPERTY, oldValue, userEntity);
    }
    
    
    public void setUserId(Integer userId) {
        this.userId = userId;
        final UserEntity userEntity;
        try {
            userEntity = getUserInfoUseCase.execute(userId);
                    setUser(userEntity);

        } catch (UserException ex) {
            setErrorMessage(ex.getMessage());
        }
    }
    
    public void setErrorMessage(String newValue) {
        final String oldValue = this.errorMessage;
        this.errorMessage = newValue;
        firePropertyChange(ERROR_MESSAGE_PROPERTY, oldValue, this.errorMessage);
    }
    
    public void setClose(Boolean newValue) {
        final Boolean oldValue = false;
        if (newValue) {
            resetModel();
        }
        super.firePropertyChange(CLOSE_PROPERTY, oldValue, newValue);

    }
    
    private void resetModel() {
        this.user = null;
        this.loadingUser = false;
        this.userId = null;
        this.errorMessage = null;
    }
}