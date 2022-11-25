/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.controllers;

import dev.kit2512.oop_sms.presentation.models.LoginModel;

import javax.inject.Inject;

/**
 *
 * @author macpro13
 */
public class LoginController extends AbstractController {

    public LoginController() {
        super();
    }

    @Inject
    public LoginController(LoginModel model) {
        super();
        this.addModel(model);
    }

    public void elementPasswordChanged(String newValue) {
        setModelProperty(LoginModel.PASSWORD_PORPERTY, newValue);
    }
    
    public void elementUserNameChanged(String newValue) {
        setModelProperty(LoginModel.USERNAME_PROPERTY, newValue);
    }
    
    public void elementLoginButtonPressed() {
        setModelProperty(LoginModel.IS_LOADING_PROPERTY, true);
    }
}
