/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.domain.usecases;

import dev.kit2512.oop_sms.domain.entities.StudentEntity;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentException;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentRepository;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */
@Singleton
public class GetStudentInfoUseCase {
    public StudentRepository studentRepository;
    
    
    @Inject
    public GetStudentInfoUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public StudentEntity execute(Integer userId) throws StudentException {
        try {
            return studentRepository.getStudent(userId);
        } catch (StudentException ex) {
            Logger.getLogger(GetStudentInfoUseCase.class.getName()).log(Level.SEVERE, null, ex);
            throw new StudentException(ex.getLocalizedMessage());
        }
    }
}
