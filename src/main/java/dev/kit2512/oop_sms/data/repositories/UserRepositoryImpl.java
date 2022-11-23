package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.data.daos.UserDao.UserDao;
import dev.kit2512.oop_sms.domain.models.UserModel;
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
    public List<UserModel> getUsers() throws UserException {
        return null;
    }

    @Override
    public List<UserModel> getUsers(HashMap<String, Object> filter) throws UserException {
        return null;
    }

    @Override
    public UserModel removeUser(UserModel userEntity) throws UserException {
        return null;
    }

    @Override
    public UserModel addUser(UserModel userEntity) throws UserException {
        return null;
    }

    @Override
    public UserModel updateUser(UserModel oldUserModel, UserModel newUserModel) throws UserException {
        return null;
    }
}
