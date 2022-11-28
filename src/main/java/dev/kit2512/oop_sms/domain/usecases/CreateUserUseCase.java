package dev.kit2512.oop_sms.domain.usecases;

import dev.kit2512.oop_sms.domain.entities.UserEntity;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRespository.AuthenticationRepository;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserException;

import javax.inject.Inject;

public class CreateUserUseCase implements BaseUseCase<UserEntity> {
    protected final AuthenticationRepository authenticationRepository;

    @Inject
    public CreateUserUseCase(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    @Override
    public UserEntity execute() throws UserException {
        throw new UserException("Not implemented");
    }
}
