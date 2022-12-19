/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.domain.usecases;

import dev.kit2512.oop_sms.domain.entities.StudentEntity;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentException;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentRepository;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */
@Singleton
public class AddStudentUseCase {
    
    private final StudentRepository studentRepository;
   

    @Inject
    public AddStudentUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    
    public StudentEntity execute(StudentEntity newStudent) throws StudentException{
        try {
           final Integer newStudentId = studentRepository.addStudent(newStudent);
           return studentRepository.getStudent(newStudentId);
        } catch (StudentException ex) {
            throw ex;
        }
    }
    
}
