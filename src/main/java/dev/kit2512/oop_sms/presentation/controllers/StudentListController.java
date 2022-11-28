/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.controllers;

import dev.kit2512.oop_sms.presentation.models.DashboardModel;
import dev.kit2512.oop_sms.presentation.models.StudentListModel;
import javax.inject.Inject;

/**
 *
 * @author macpro13
 */
public class StudentListController extends AbstractController {
    /**
     *
     * @param studentListModel
     */
    @Inject
    public StudentListController(StudentListModel studentListModel) {
        super();
        super.addModel(studentListModel);
    }

    public void elementFetchingStudentListChanged(boolean newValue) {
        setModelProperty(DashboardModel.FETCHING_STUDENT_LIST_PROPERTY, newValue);
    }
}
