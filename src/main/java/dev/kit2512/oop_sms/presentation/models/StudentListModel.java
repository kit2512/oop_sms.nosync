/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.models;

import dev.kit2512.oop_sms.domain.entities.StudentEntity;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentException;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentRepository;
import dev.kit2512.oop_sms.domain.usecases.ExportExcelUseCase;
import dev.kit2512.oop_sms.services.FileService.ExcelFileModel;
import dev.kit2512.oop_sms.services.FileService.FileServiceException;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macpro13
 */
@Singleton
public class StudentListModel extends AbstractModel{

    public static final String EXPORT_STUDENT_LIST_PROPERTY = "ExportStudentList";

    public static final String EXPORT_STUDENT_LIST_SUCCESSFUL_PROPERTY = "ExportStudentListSuccessful";

    private List<StudentEntity> studentList = new ArrayList<>();

    private StudentRepository studentRepository;

    private Boolean isFetchingStudentList = false;
    
    private Integer removingStudentId = null;

    private String errorMessage;
    
    private ExportExcelUseCase exportExcelUseCase;
    
    private ExcelFileModel exportStudentList = null;

    public static final String ERROR_MESSAGE_PROPERTY = "ErrorMessage";

    public static final String STUDENT_LIST_PROPERTY = "StudentList";

    public static final String FETCHING_STUDENT_LIST_PROPERTY = "FetchingStudentList";
    
    public static final String REMOVING_STUDENT_PROPERTY = "RemovingStudentId";

    @Inject
    public StudentListModel(StudentRepository studentRepository, ExportExcelUseCase exportExcelUseCase) {
        this.studentRepository = studentRepository;
        this.exportExcelUseCase = exportExcelUseCase;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        String oldValue = this.errorMessage;
        this.errorMessage = errorMessage;
        super.firePropertyChange(ERROR_MESSAGE_PROPERTY, oldValue, oldValue);
    }

    public List<StudentEntity> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentEntity> studentList) {
        List<StudentEntity> oldValue = this.studentList;
        this.studentList = studentList;
        super.firePropertyChange(STUDENT_LIST_PROPERTY, oldValue, studentList);
    }

    public boolean isFetchingStudentList() {
        return isFetchingStudentList;
    }

    public void setFetchingStudentList(Boolean fetchingStudentList) {
        boolean oldValue = this.isFetchingStudentList;
        isFetchingStudentList = fetchingStudentList;
        super.firePropertyChange(FETCHING_STUDENT_LIST_PROPERTY, oldValue, fetchingStudentList);
        try {
            setStudentList(studentRepository.getStudents());
            super.firePropertyChange(FETCHING_STUDENT_LIST_PROPERTY, fetchingStudentList, !fetchingStudentList);
        } catch (StudentException ex) {
            super.firePropertyChange(FETCHING_STUDENT_LIST_PROPERTY, true, false);
            setErrorMessage(ex.getMessage());
        }
    }
    
    public void setRemovingStudentId(Integer userId) {
        final Integer oldValue = this.removingStudentId;
        this.removingStudentId = userId;
        super.firePropertyChange(REMOVING_STUDENT_PROPERTY, oldValue, userId);
        try {
            studentRepository.removeStudent(userId);
        } catch (StudentException ex) {
            setErrorMessage(ex.getMessage());
            this.removingStudentId = null;
            super.firePropertyChange(REMOVING_STUDENT_PROPERTY, userId, null);
            this.setFetchingStudentList(true);
        }
    }
    
    public void setExportStudentList(ExcelFileModel newValue) {
        final var oldValue = this.exportStudentList;
        this.exportStudentList = newValue;
        this.firePropertyChange(StudentListModel.EXPORT_STUDENT_LIST_PROPERTY, oldValue, newValue);
        try {
            exportExcelUseCase.execute(newValue);
            this.firePropertyChange(StudentListModel.EXPORT_STUDENT_LIST_PROPERTY, newValue, oldValue);
            this.firePropertyChange(StudentListModel.EXPORT_STUDENT_LIST_SUCCESSFUL_PROPERTY, false, true);
        } catch (FileServiceException ex) {
            this.setErrorMessage(ex.getMessage());
            this.firePropertyChange(EXPORT_STUDENT_LIST_PROPERTY,newValue, oldValue);
            this.firePropertyChange(EXPORT_STUDENT_LIST_SUCCESSFUL_PROPERTY, true, false);
        }
    }
}
