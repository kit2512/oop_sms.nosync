/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.kit2512.oop_sms.domain.repositories.StudentRespository;

import dev.kit2512.oop_sms.domain.models.StudentModel;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserException;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author macpro13
 */
public interface StudentRepository {
    List<StudentModel> getUsers() throws UserException;

    List<StudentModel> getUsers(HashMap<String, Object> filter) throws UserException;

    StudentModel removeUser(StudentModel userEntity) throws UserException;

    StudentModel addUser(StudentModel userEntity) throws UserException;

    StudentModel updateUser(StudentModel oldStudentModel, StudentModel newStudentModel) throws StudentException;
}
