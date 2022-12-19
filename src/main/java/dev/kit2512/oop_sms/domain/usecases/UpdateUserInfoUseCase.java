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
    
    public void execute(UserEntity oldUser, UserEntity userEntity) throws UserException {
        try {
            userRepository.updateUser(userEntity);
        } catch (UserException ex) {
            userRepository.updateUser(oldUser);
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
