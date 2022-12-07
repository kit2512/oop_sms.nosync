/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.controllers;

import dev.kit2512.oop_sms.presentation.models.InfoModel;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */
@Singleton
public class InfoController extends AbstractController {
    
    @Inject
    public InfoController(InfoModel infoModel) {
        super();
        this.addModel(infoModel);
    }
    
    public void elementUserIdChanged(Integer userId) {
        super.setModelProperty(InfoModel.USER_ID, userId);
    }
    
    public void elementClosingChanged(Boolean newValue) {
        super.setModelProperty(InfoModel.CLOSE_PROPERTY, newValue);
    }
}
