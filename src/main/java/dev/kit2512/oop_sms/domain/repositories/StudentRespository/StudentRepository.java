/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.kit2512.oop_sms.domain.repositories.StudentRespository;

import dev.kit2512.oop_sms.domain.entities.StudentEntity;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author macpro13
 */
public interface StudentRepository {
    List<StudentEntity> getStudents() throws StudentException;

    List<StudentEntity> getStudents(HashMap<String, Object> filter) throws StudentException;

    StudentEntity removeStudent(StudentEntity userEntity) throws StudentException;

    StudentEntity addStudent(StudentEntity userEntity) throws StudentException;

    StudentEntity updateStudent(StudentEntity oldStudentModel, StudentEntity newStudentModel) throws StudentException;
}
