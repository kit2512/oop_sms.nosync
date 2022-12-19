/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.kit2512.oop_sms.domain.repositories.UserRepository;


import dev.kit2512.oop_sms.domain.entities.UserEntity;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author macpro13
 */
public interface UserRepository {
    List<UserEntity> getUsers() throws UserException;

    List<UserEntity> getUsers(HashMap<String, Object> filter) throws UserException;
    
    UserEntity getUser(Integer userId) throws UserException;

    UserEntity removeUser(UserEntity userEntity) throws UserException;
    
    UserEntity addUser(UserEntity userEntity) throws UserException;
    
    UserEntity updateUser(UserEntity newUserEntity) throws UserException;
}
