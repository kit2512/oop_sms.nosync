/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.controllers;

import dev.kit2512.oop_sms.presentation.models.UpdatePasswordModel;
import javax.inject.Inject;

/**
 *
 * @author macpro13
 */
public class UpdatePasswordController extends AbstractController {
    
    @Inject
    public UpdatePasswordController(UpdatePasswordModel model) {
        super();
        this.addModel(model);
    }

    public void elementCurrentPasswordChanged(String newValue) {
        super.setModelProperty(UpdatePasswordModel.CURRENT_PASWORD_PROPERTY, newValue);
    }

    public void elementNewPasswordChanged(String newValue) {
        super.setModelProperty(UpdatePasswordModel.NEW_PASSWORD_PROPERTY, newValue);
    }

    public void elementConfirmPasswordChanged(String newValue) {
        super.setModelProperty(UpdatePasswordModel.CONFIRM_NEW_PASSWORD_PROPERTY, newValue);
    }

    public void elementUpdateButtonClicked(boolean b) {
        super.setModelProperty(UpdatePasswordModel.UPDATING_PASSWORD, true);
    }

    public void setFetchingData(Integer newValue) {
        super.setModelProperty(UpdatePasswordModel.FETCHING_DATA_PROPERTY, newValue);
    }
    
    
}
