/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.models;

import dev.kit2512.oop_sms.domain.entities.UserEntity;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserException;
import dev.kit2512.oop_sms.domain.usecases.GetUserInfoUseCase;
import dev.kit2512.oop_sms.domain.usecases.UpdatePasswordUseCase;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */
@Singleton
public class UpdatePasswordModel extends AbstractModel {
    
    private final UpdatePasswordUseCase updatePasswordUseCase;
    
    private final GetUserInfoUseCase getUserInfoUseCase;
    
    public static final String FETCHING_DATA_PROPERTY = "FetchingData";
    
    public static final String CURRENT_PASWORD_PROPERTY = "CurrentPassword";
    
    public static final String NEW_PASSWORD_PROPERTY = "NewPassword";
    
    public static final String CONFIRM_NEW_PASSWORD_PROPERTY = "ConfirmNewPassword";
    
    public static final String ERROR_MESSASGE_PROPERTY = "ErrorMessage";
    
    public static final String UPDATING_PASSWORD = "UpdatingPassword";
    
    public static final String SUCCESS = "Success";
    
    private String currentPassword = "";
    
    private String newPassword = "";
    
    private String confirmNewPassword = "";
    
    private UserEntity currentUser;
    
    private String errorMessage = null;
        
    
    @Inject
    public UpdatePasswordModel(UpdatePasswordUseCase updatePasswordUseCase, GetUserInfoUseCase getUserInfoUseCase) {
        this.updatePasswordUseCase = updatePasswordUseCase;
        this.getUserInfoUseCase = getUserInfoUseCase;
    }

    public void setCurrentPassword(String newValue) {
        final var oldValue = this.currentPassword;
        this.currentPassword = newValue;
        super.firePropertyChange(CURRENT_PASWORD_PROPERTY, oldValue, newValue);
    }

    public void setNewPassword(String newValue) {
        final var oldValue = this.newPassword;
        this.newPassword = newValue;
        super.firePropertyChange(NEW_PASSWORD_PROPERTY, oldValue, newValue);
    }

    public void setErrorMessage(String newValue) {
        final var oldValue = this.errorMessage;
        this.errorMessage = newValue;
        super.firePropertyChange(ERROR_MESSASGE_PROPERTY, oldValue, newValue);
    }
    
    

    public void setConfirmNewPassword(String newValue) {
        final var oldValue = this.confirmNewPassword;
        this.confirmNewPassword = newValue;
        super.firePropertyChange(CONFIRM_NEW_PASSWORD_PROPERTY, oldValue, newValue);
    }

    public void setFetchingData(Integer userId) {
        super.firePropertyChange(FETCHING_DATA_PROPERTY, null, userId);
        
        try {
            this.currentUser = getUserInfoUseCase.execute(userId);
        } catch (UserException ex) {
            setErrorMessage(ex.getMessage());
            
        }
        super.firePropertyChange(FETCHING_DATA_PROPERTY, userId, null);
    }
    
    public void setUpdatingPassword(Boolean newValue) {
        super.firePropertyChange(UPDATING_PASSWORD, false, true);
        final String error = validatePassword();
        if (error!= null) {
            setErrorMessage(error);
            super.firePropertyChange(UPDATING_PASSWORD, true, false);
            return;
        }
        try {
            final UserEntity newUser = this.currentUser;
            newUser.setPassword(newPassword);
            newUser.setUserDateUpdated(new Date());
            updatePasswordUseCase.execute(currentUser, newUser);
            super.firePropertyChange(SUCCESS, null, true);
        } catch (UserException ex) {
            this.setErrorMessage(ex.getLocalizedMessage());
            this.firePropertyChange(SUCCESS, null, false);
        }
        
    }
    
    public String validatePassword() {
        if (currentPassword == null ? currentUser.getPassword() != null : !currentPassword.equals(currentUser.getPassword())) {
            return "Current pasword is incorrect";
        }
        
        if (newPassword == null || newPassword.isBlank()) {
            return "New password must be provided";
        }
        
        if (newPassword == null || confirmNewPassword.isBlank()) {
            return "Please confirm password";
        }
        
        if (!newPassword.equals(confirmNewPassword)) {
            return "New password does not match";
        }
        
        return null;
    }
}
