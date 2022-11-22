/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.kit2512.oop_sms.domain.repositories.UserRepository;

import dev.kit2512.oop_sms.config.UserFilterEnum;
import dev.kit2512.oop_sms.data.models.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author macpro13
 */
public interface UserRepository {
    List<User> getUsers() throws UserException;

    List<User> getUsers(HashMap<String, Object> filter) throws UserException;

    User removeUser(User user) throws UserException;
    
    User addUser(User user) throws UserException;
    
    User updateUser(User oldUser, User newUser) throws UserException;
}
