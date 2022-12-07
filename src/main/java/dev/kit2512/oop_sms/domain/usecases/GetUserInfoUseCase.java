/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.domain.usecases;

import dev.kit2512.oop_sms.domain.entities.UserEntity;
import dev.kit2512.oop_sms.domain.repositories.StaffRepository.StaffRepository;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentException;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentRepository;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserException;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserRepository;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */
@Singleton
public class GetUserInfoUseCase {
    private UserRepository userRepository;
    
    private StudentRepository studentRepository;
    
    private StaffRepository staffRepository;
    
    @Inject
    public GetUserInfoUseCase(UserRepository userRepository, StudentRepository studentRepository, StaffRepository staffRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.staffRepository = staffRepository;
    }
    
    public UserEntity execute(Integer userId) throws UserException {
        final UserEntity user = userRepository.getUser(userId);
        if (user.getUserRole().equals(UserEntity.UserRole.STUDENT)) {
            try {
                return studentRepository.getStudent(userId);
            } catch (StudentException ex) {
                throw new UserException("Failed to get student info");
            }
        }
        if (user.getUserRole().equals(UserEntity.UserRole.STAFF)) {
            return staffRepository.getStaff(userId);
        }
        return user;
    }
}
