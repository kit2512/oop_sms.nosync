package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.config.UserFilterEnum;
import dev.kit2512.oop_sms.data.database.UserDao;
import dev.kit2512.oop_sms.data.models.User;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserException;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserRepository;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final UserDao userDao;

    @Inject
    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUsers() throws UserException {
        try {
            return userDao.queryForAll();
        } catch (SQLException e) {
            throw new UserException("Error getting users");
        }
    }

    @Override
    public List<User> getUsers(HashMap<String, Object> filter) throws  UserException{
        try {
            return userDao.queryForFieldValues(filter);
        } catch (SQLException e) {
            throw new UserException("Error getting users");
        }
    }

    @Override
    public User removeUser(User user) throws UserException{
        try {
            userDao.delete(user);
            return user;
        } catch (SQLException e) {
            throw new UserException("Unable to delete user." + e.getMessage());
        }
    }

    @Override
    public User addUser(User user) throws UserException{
        try {
            userDao.create(user);
        } catch (SQLException e) {
            throw new UserException("Unable to add user." + e.getMessage());
        }
        return user;
    }

    @Override
    public User updateUser(User oldUser, User newUser) {
        return newUser;
    }
}
