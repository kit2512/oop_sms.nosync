package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.data.daos.UserDao.UserDao;
import dev.kit2512.oop_sms.data.models.UserModel;
import dev.kit2512.oop_sms.domain.entities.UserEntity;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserException;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserRepository;
import java.sql.SQLException;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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
    public UserEntity updateUser(UserEntity newUserEntity) throws UserException {
        try {
            userDao.update(new UserModel(newUserEntity));
        } catch (SQLException ex) {
            throw new UserException(ex.getLocalizedMessage());
        }
        return newUserEntity;
    }

    @Override
    public UserEntity getUser(Integer userId) throws UserException {
        try {
            return userDao.queryForEq("user_id", userId).get(0).mapToEntity();
        } catch (SQLException ex) {
            throw new UserException(ex.getLocalizedMessage());
        }
        
    }
}
