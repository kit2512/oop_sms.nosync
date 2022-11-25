/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.controllers;

import dev.kit2512.oop_sms.presentation.models.AbstractModel;
import dev.kit2512.oop_sms.presentation.models.DashboardModel;

import javax.inject.Inject;

/**
 *
 * @author macpro13
 */
public class DashboardController extends AbstractController {

    @Inject DashboardController(DashboardModel dashBoardModel) {
        super();
        addModel(dashBoardModel);
    }

    public void elementFetchingStudentListChanged(boolean newValue) {
        setModelProperty(DashboardModel.FETCHING_STUDENT_LIST_PROPERTY, newValue);
    }
}
