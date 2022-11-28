package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.data.daos.UserDao.UserDao;
import dev.kit2512.oop_sms.domain.entities.UserEntity;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserException;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserRepository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private UserDao userDao;

    @Inject
    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserEntity> getUsers() throws UserException {
        return null;
    }

    @Override
    public List<UserEntity> getUsers(HashMap<String, Object> filter) throws UserException {
        return null;
    }

    @Override
    public UserEntity removeUser(UserEntity userEntity) throws UserException {
        return null;
    }

    @Override
    public UserEntity addUser(UserEntity userEntity) throws UserException {
        return null;
    }

    @Override
    public UserEntity updateUser(UserEntity oldUserEntity, UserEntity newUserEntity) throws UserException {
        return null;
    }
}
