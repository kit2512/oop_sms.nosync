/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.controllers;

import dev.kit2512.oop_sms.presentation.models.EditInfoModel;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */
@Singleton
public class EditInfoController extends AbstractController {
    @Inject
    public EditInfoController(EditInfoModel model) {
        this.addModel(model);
    }
    

    public void elementFirstNameChanged(String text) {
        this.setModelProperty(EditInfoModel.FIRST_NAME_PROPERTY, text);
    }

    public void elementMiddleNameChanged(String text) {
        this.setModelProperty(EditInfoModel.MIDDLE_NAME_PROPERTY, text);
    }

    public void elementLastNameChanged(String text) {
        this.setModelProperty(EditInfoModel.LAST_NAME_PROPERTY, text);
    }

    public void elementAddressChanged(String text) {
        this.setModelProperty(EditInfoModel.ADDRESS_PROPERTY, text);
    }

    public void elementEmailChanged(String text) {
        this.setModelProperty(EditInfoModel.EMAIL_PROPERTY, text);
    }

    public void elementPhoneChanged(String text) {
        this.setModelProperty(EditInfoModel.PHONE_PROPERTY, text);
    }

    public void elementGenderChanged(Boolean selected) {
    this.setModelProperty(EditInfoModel.GENDER_PROPERTY, selected);
    }

    public void elementOKPressed() {
        this.setModelProperty(EditInfoModel.UPDATING_PROPERTY, true);
    }

    public void elementOldUserInfo(Integer userId) {
        this.setModelProperty(EditInfoModel.USER_PROPERTY, userId);
    }
    
}
