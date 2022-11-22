/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.kit2512.oop_sms.domain.repositories;

import dev.kit2512.oop_sms.config.UserFilterEnum;
import dev.kit2512.oop_sms.data.models.User;
import java.util.ArrayList;

/**
 *
 * @author macpro13
 */
public interface UserRepository {
    ArrayList<User> getUsers();
    
    ArrayList<User> getUsers(UserFilterEnum filter);
    
    User removeUser(User user);
    
    User addUser(User user);
    
    User updateUser(User user);
}
