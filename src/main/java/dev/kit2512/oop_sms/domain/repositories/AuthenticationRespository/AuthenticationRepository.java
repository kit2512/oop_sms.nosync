/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.kit2512.oop_sms.domain.repositories.AuthenticationRespository;

import dev.kit2512.oop_sms.data.models.User;

/**
 *
 * @author macpro13
 */
public interface AuthenticationRepository {
    User getCurrentUser();
    
    User logIn(String username, String password) throws AuthenticationException;
    
    void logOut();
    
    boolean isLoggedIn();
    
    void updatePassword(User user, String oldPassword, String newPassword);
}