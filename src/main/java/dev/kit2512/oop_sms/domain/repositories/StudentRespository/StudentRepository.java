/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.kit2512.oop_sms.domain.repositories.StudentRespository;

import dev.kit2512.oop_sms.domain.models.StudentModel;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author macpro13
 */
public interface StudentRepository {
    List<StudentModel> getStudents() throws StudentException;

    List<StudentModel> getStudents(HashMap<String, Object> filter) throws StudentException;

    StudentModel removeUser(StudentModel userEntity) throws StudentException;

    StudentModel addUser(StudentModel userEntity) throws StudentException;

    StudentModel updateUser(StudentModel oldStudentModel, StudentModel newStudentModel) throws StudentException;
}
