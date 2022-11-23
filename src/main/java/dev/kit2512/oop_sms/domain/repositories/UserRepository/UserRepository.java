/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.kit2512.oop_sms.domain.repositories.UserRepository;


import dev.kit2512.oop_sms.domain.models.UserModel;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author macpro13
 */
public interface UserRepository {
    List<UserModel> getUsers() throws UserException;

    List<UserModel> getUsers(HashMap<String, Object> filter) throws UserException;

    UserModel removeUser(UserModel userEntity) throws UserException;
    
    UserModel addUser(UserModel userEntity) throws UserException;
    
    UserModel updateUser(UserModel oldUserModel, UserModel newUserModel) throws UserException;
}
