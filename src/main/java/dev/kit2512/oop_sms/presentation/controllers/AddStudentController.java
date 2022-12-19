/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.controllers;

import dev.kit2512.oop_sms.domain.entities.MajorEntity;
import dev.kit2512.oop_sms.presentation.models.AddStudentModel;
import dev.kit2512.oop_sms.presentation.models.StudentListModel;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */
@Singleton
public class AddStudentController extends AbstractController {

    @Inject
    public AddStudentController(AddStudentModel model) {
        super();
        this.addModel(model);
    }

    public void elementFirstNameChanged(String newValue) {
        super.setModelProperty(AddStudentModel.FIRST_NAME_PROPERTY, newValue);
    }

    public void elementLastNameChanged(String newValue) {
        super.setModelProperty(AddStudentModel.LAST_NAME_PROPERTY, newValue);
    }

    public void elementMiddleNameChanged(String newValue) {
        super.setModelProperty(AddStudentModel.MIDDLE_NAME_PROPERTY, newValue);
    }

    public void getMajors() {
        super.setModelProperty(AddStudentModel.GETTING_MAJORS_PROPERTY, true);
    }

    public void elementSeletedMajorChanged(MajorEntity newValue) {
        super.setModelProperty(AddStudentModel.SELECTED_MAJOR_PROPERTY, newValue);
    }

    public void elementAutoGenerateIDAndPasswordChange(Boolean newValue) {
        super.setModelProperty(AddStudentModel.AUTO_GENERATE_ID_PASSWORD_PROPERTY, newValue);
    }

    public void elementDateOfBirthNameChanged(Date newValue) {
        super.setModelProperty(AddStudentModel.DATE_OF_BIRTH_PROPERTY, newValue);
    }

    public void elementPhoneChanged(String newValue) {
        super.setModelProperty(AddStudentModel.PHONE_PROPERTY, newValue);

    }

    public void elementClassLetterChanged(String newValue) {
        super.setModelProperty(AddStudentModel.CLASS_LETTER_PROPERTY, newValue);

    }

    public void elementYearOfAdmissionChanged(Integer newValue) {
         super.setModelProperty(AddStudentModel.YEAR_OF_ADMISSION, newValue);
    }

    public void elementGenderChanged(Boolean newValue) {
        super.setModelProperty(AddStudentModel.GENDER_PROPERTY, newValue);
    }

    public void elementUsernameChanged(String newValue) {
        super.setModelProperty(AddStudentModel.USERNAME_PROPERTY, newValue);
    }

    public void elementPasswordChanged(String newValue) {
        super.setModelProperty(AddStudentModel.PASSWORD_PROPERTY, newValue);
    }

    public void elementAddButtonActionPerformed(boolean b) {
        super.setModelProperty(AddStudentModel.ADDING_NEW_STUDENT, b);
    }

    public void elementAddressChanged(String newValue) {
        super.setModelProperty(AddStudentModel.ADDRESS_PROPERTY, newValue);
    }

    public void elementEmailChanged(String newValue) {
        super.setModelProperty(AddStudentModel.EMAIL_PROPERTY, newValue);
    }

    public void elementStudentListShoudReload() {
        super.setModelProperty(StudentListModel.FETCHING_STUDENT_LIST_PROPERTY, true);
    }

    public void elementShouldCloseChanged(boolean b) {
        super.setModelProperty(AddStudentModel.SHOULD_CLOSE_PROPERTY, true);
    }
}
