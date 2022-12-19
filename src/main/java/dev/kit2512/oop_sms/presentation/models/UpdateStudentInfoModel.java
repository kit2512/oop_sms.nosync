/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.models;

import dev.kit2512.oop_sms.domain.entities.MajorEntity;
import dev.kit2512.oop_sms.domain.entities.StudentEntity;
import dev.kit2512.oop_sms.domain.repositories.MajorRepository.MajorException;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentException;
import dev.kit2512.oop_sms.domain.usecases.GetMajorListUseCase;
import dev.kit2512.oop_sms.domain.usecases.GetStudentInfoUseCase;
import dev.kit2512.oop_sms.domain.usecases.UpdateStudentInfoUseCase;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */
@Singleton
public class UpdateStudentInfoModel extends AbstractModel {

    GetMajorListUseCase getMajorListUseCase;
    UpdateStudentInfoUseCase updateStudentInfoUseCase;
    GetStudentInfoUseCase getStudenInfoUseCase;

    public static final String STUDENT_PROPERTY= "StudentId";
    public static final String ERROR_PROPERTY = "Error";
    public static final String MAJOR_PROPERTY = "Major";
    public static final String AVAILABLE_MAJOR_PROPERTY = "AvailableMajors";
    public static final String UPDATING_STUDENT_PROPERTY = "UpdatingStudent";
    public static final String SUCCESS_PROPERTY = "Success";
    public static final String AVAILABLE_YEARS_OF_ADMISSION_PROPERTY = "AvailableYearsOfAdmission";

    private StudentEntity oldStudent;
    private StudentEntity newStudent;
    private String error;
    

    @Inject
    public UpdateStudentInfoModel(GetMajorListUseCase getMajorListUseCase,
            UpdateStudentInfoUseCase updateStudentInfoUseCase,
            GetStudentInfoUseCase getStudenInfoUseCase) {
        this.getMajorListUseCase = getMajorListUseCase;
        this.updateStudentInfoUseCase = updateStudentInfoUseCase;
        this.getStudenInfoUseCase = getStudenInfoUseCase;
        getMajors();
    }

    public void setStudent(StudentEntity studentEntity) {
        this.oldStudent = studentEntity;
        this.newStudent = oldStudent.clone();
    }
    
    public void setMajor(MajorEntity newValue) {
        final var oldValue = this.newStudent.getMajor();
        this.newStudent.setMajor(newValue);
        this.firePropertyChange(MAJOR_PROPERTY, oldValue, newValue);
        this.setAvailableYearsOfAdmisison(newValue.getYearOfEstablishment());
    }
    
    public void setAvailableYearsOfAdmisison(Integer newValue) {
        final var oldValue = this.newStudent.getMajor().getYearOfEstablishment();
        this.firePropertyChange(AVAILABLE_YEARS_OF_ADMISSION_PROPERTY, oldValue, newValue);
    }
    
    public void setUpdatingStudent(Boolean newValue) {
        final var oldValue = !newValue;
        if (newValue) {
            try {
                updateStudentInfoUseCase.execute(oldStudent, newStudent);
                this.firePropertyChange(SUCCESS_PROPERTY,oldValue, newValue);
            } catch (StudentException ex) {
                Logger.getLogger(UpdateStudentInfoModel.class.getName()).log(Level.SEVERE, null, ex);
                setError(ex.getLocalizedMessage());
            }
        }
    }
    
    private void setError(String newValue) {
        final var oldValue = this.error;
        this.error = newValue;
        this.firePropertyChange(ERROR_PROPERTY, oldValue, newValue);
    }
    
    private void getMajors() {
        final List<MajorEntity> majors;
        try {
            majors = getMajorListUseCase.execute();
            this.firePropertyChange(AVAILABLE_MAJOR_PROPERTY, null, majors);

        } catch (MajorException ex) {
            Logger.getLogger(UpdateStudentInfoModel.class.getName()).log(Level.SEVERE, null, ex);
            setError(ex.getLocalizedMessage());
        }
    }
    
   
}
