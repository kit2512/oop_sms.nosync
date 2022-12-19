/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.controllers;

import dev.kit2512.oop_sms.presentation.models.DashboardModel;
import dev.kit2512.oop_sms.presentation.models.StudentListModel;
import dev.kit2512.oop_sms.services.FileService.ExcelFileModel;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */
@Singleton
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
    
    public void elementRemoveStudentClicked(int userId) {
        super.setModelProperty(StudentListModel.REMOVING_STUDENT_PROPERTY, userId);
    }
    
    public void elementExportStudentListButtonPerformed(ExcelFileModel newValue) {
        super.setModelProperty(StudentListModel.EXPORT_STUDENT_LIST_PROPERTY, newValue);
    }
}
