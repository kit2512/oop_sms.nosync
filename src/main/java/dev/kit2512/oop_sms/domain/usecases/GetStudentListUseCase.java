/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.domain.usecases;

import dev.kit2512.oop_sms.domain.entities.StudentEntity;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentException;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentRepository;

import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */
@Singleton
public class GetStudentListUseCase {
    final private StudentRepository studentRepositroy;

    @Inject
    public GetStudentListUseCase(StudentRepository studentRepositroy) {
        this.studentRepositroy = studentRepositroy;
    }
    
    public ArrayList<StudentEntity> execute() throws StudentException {
       return new ArrayList<>(studentRepositroy.getStudents());
    }
    
    public static void main(String[] args) {
        
    }
}
