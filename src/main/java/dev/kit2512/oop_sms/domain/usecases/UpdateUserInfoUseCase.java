/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.domain.usecases;

import dev.kit2512.oop_sms.domain.entities.UserEntity;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserException;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserRepository;
import javax.inject.Inject;

/**
 *
 * @author macpro13
 */
public class UpdateUserInfoUseCase {
    private final UserRepository userRepository;
    
    @Inject
    public UpdateUserInfoUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public void execute(UserEntity oldUser, UserEntity newUser) throws UserException {
        userRepository.updateUser(oldUser, newUser);
    }

}
