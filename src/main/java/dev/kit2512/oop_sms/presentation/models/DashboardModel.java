/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.models;

import dev.kit2512.oop_sms.domain.entities.StudentEntity;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentException;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author macpro13
 */
public class DashboardModel extends AbstractModel {
    private List<StudentEntity> studentList = new ArrayList<>();
    
    private StudentRepository studentRepository;

    private Boolean isFetchingStudentList = false;
    
    private String errorMessage;
    
    public static final String ERROR_MESSAGE_PROPERTY = "ErrorMessage";

    public static final String STUDENT_LIST_PROPERTY = "StudentList";

    public static final String FETCHING_STUDENT_LIST_PROPERTY = "FetchingStudentList";
    
    @Inject
    public DashboardModel(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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
        } catch (StudentException ex) {
            super.firePropertyChange(FETCHING_STUDENT_LIST_PROPERTY, true, false);
            ex.printStackTrace();
            setErrorMessage(ex.getMessage());
        }
    }
}
