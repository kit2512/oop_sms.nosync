/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.kit2512.oop_sms.domain.repositories.AuthenticationRespository;


import dev.kit2512.oop_sms.domain.entities.UserEntity;

/**
 *
 * @author macpro13
 */
public interface AuthenticationRepository {
    UserEntity getCurrentUser();

    UserEntity logIn(String username, String password) throws AuthenticationException;

    void logOut();
    
    boolean isLoggedIn();
    
    void updatePassword(UserEntity userEntity, String oldPassword, String newPassword) throws AuthenticationException;
}