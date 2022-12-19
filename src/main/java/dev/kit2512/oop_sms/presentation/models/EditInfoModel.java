/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.models;

import dev.kit2512.oop_sms.domain.entities.UserEntity;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserException;
import dev.kit2512.oop_sms.domain.usecases.UpdateUserInfoUseCase;
import dev.kit2512.oop_sms.domain.usecases.GetUserInfoUseCase;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */
@Singleton
public class EditInfoModel extends AbstractModel {

    public static final String FIRST_NAME_PROPERTY = "FirstName";
    public static final String LAST_NAME_PROPERTY = "LastName";
    public static final String MIDDLE_NAME_PROPERTY = "MiddleName";
    public static final String GENDER_PROPERTY = "Gender";
    public static final String ADDRESS_PROPERTY = "Address";
    public static final String EMAIL_PROPERTY = "Email";
    public static final String PHONE_PROPERTY = "Phone";
    public static final String ROLE_PROPERTY = "Role";
    public static final String MAJOR_PROPERY = "Major";
    public static final String YEAR_OF_ADMISSION_PROPERTY = "YearOfAdmission";
    public static final String CLASS_LETTER_PROPERTY = "ClassLetter";
    public static final String AVAILABLE_MAJORS = "AvailableMajors";
    public static final String ERROR_PROPERTY = "Error";
    public static final String UPDATING_PROPERTY = "Updating";
    public static final String SUCCESS_PROPERTY = "Success";
    public static final String USER_PROPERTY = "User";

    private UserEntity oldUser;
    private UserEntity newUser;
    private String error;


    private final UpdateUserInfoUseCase editUserInfoUseCase;
    private final GetUserInfoUseCase getUserInfoUseCase;

    @Inject
    public EditInfoModel(UpdateUserInfoUseCase editUserInfoUseCase, GetUserInfoUseCase getUserInfoUseCase) {
        this.editUserInfoUseCase = editUserInfoUseCase;
        this.getUserInfoUseCase = getUserInfoUseCase;
//        getMajors();
    }
    
    public void setUser(Integer userId) {
        try {
            final UserEntity user = getUserInfoUseCase.execute(userId);
            this.oldUser = user;
            this.newUser = user.clone();
           
            this.firePropertyChange(USER_PROPERTY, oldUser, newUser);
        } catch (UserException ex) {
            setError(ex.getLocalizedMessage());
            Logger.getLogger(EditInfoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setUpdating(Boolean newValue) {
        validate();
        if (error == null) {
            try {
                editUserInfoUseCase.execute(oldUser, newUser);
                this.firePropertyChange(SUCCESS_PROPERTY, false, true);
            } catch (UserException ex) {
                setError(ex.getLocalizedMessage());
            }
        } else {
            setError(error);
        }
    }
    public void setError(String newValue) {
        final var oldValue = this.error;
        this.error = newValue;
        super.firePropertyChange(ERROR_PROPERTY, oldValue, newValue);
    }

    public void setFirstName(String newValue) {
        final var oldValue = this.newUser.getUserFirstName();
        this.newUser.setUserFirstName(newValue);
        this.firePropertyChange(FIRST_NAME_PROPERTY, oldValue, newValue);
    }

    public void setMiddleName(String newValue) {
        final var oldValue = this.newUser.getUserMiddleName();
        this.newUser.setUserMiddleName(newValue);
        this.firePropertyChange(MIDDLE_NAME_PROPERTY, oldValue, newValue);
    }

    public void setLastName(String newValue) {
        final var oldValue = this.newUser.getUserLastName();
        this.newUser.setUserLastName(newValue);
        this.firePropertyChange(LAST_NAME_PROPERTY, oldValue, newValue);
    }

    public void setGender(Boolean newValue) {
        final var oldValue = this.newUser.getUserGender();
        this.newUser.setUserGender( newValue);
        this.firePropertyChange(GENDER_PROPERTY, oldValue, newValue);
    }

    public void setAddress(String newValue) {
        final var oldValue = this.newUser.getUserAddress();
        this.newUser.setUserAddress(newValue);
        this.firePropertyChange(ADDRESS_PROPERTY, oldValue, newValue);
    }

    public void setEmail(String newValue) {
        final var oldValue = this.newUser.getUserEmail();
        this.newUser.setUserEmail(newValue);
        this.firePropertyChange(EMAIL_PROPERTY, oldValue, newValue);
    }

    public void setPhone(String newValue) {
        final var oldValue = this.newUser.getUsername();
        this.newUser.setUserPhone(newValue);
        this.firePropertyChange(PHONE_PROPERTY, oldValue, newValue);
    }

    
    private void validate() {
        if (newUser.getUserFirstName() == null || newUser.getUserFirstName().isEmpty()) {
            this.error = "Invalid first name";
        }
        
        if (newUser.getUserLastName() == null || newUser.getUserLastName().isEmpty()) {
            this.error = "Invalid last name";
        }
        
        if (newUser.getUserPhone() == null || newUser.getUserPhone().isEmpty()) {
            this.error = "Invalid phone number";
        }
        
        if (newUser.getUserEmail() == null || newUser.getUserEmail().isEmpty() || !newUser.getUserEmail().contains("@")) {
            this.error = "Invalid email";
        }
        
        
        if (newUser.getUserGender() == null) {
            this.error="Invalid gender";
        }
        
        if (newUser.getUserAddress() == null || newUser.getUserAddress().isEmpty()) {
            this.error="Invalid addressd";
        }

        this.error = null;
    }
}
