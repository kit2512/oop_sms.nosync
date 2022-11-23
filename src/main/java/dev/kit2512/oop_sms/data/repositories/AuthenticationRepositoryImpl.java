/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.domain.models.UserModel;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRespository.AuthenticationException;
import dev.kit2512.oop_sms.data.daos.UserDao.UserDao;
import dev.kit2512.oop_sms.data.daos.UserDao.UserDaoImpl;
import dev.kit2512.oop_sms.data.entities.UserEntity;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRespository.AuthenticationRepository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/**
 *
 * @author macpro13
 */

public class AuthenticationRepositoryImpl implements AuthenticationRepository {
    private UserDao userDao;


    @Inject
    public AuthenticationRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    private UserModel currentUser;

    @Override
    public UserModel getCurrentUser() {
        return currentUser;
    }
    
    private void setCurrentUser(UserModel currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public UserModel logIn(String username, String password) throws AuthenticationException {
        try {
            Map<String, Object> query = new HashMap<>();
            query.put("user_username", username);
            query.put("user_password", password);

            final UserEntity userEntity = userDao.queryForFieldValuesArgs(query).get(0);

            if (userEntity != null) {
                setCurrentUser(userEntity.mapToModel());
                return getCurrentUser();
            } else {
                throw new AuthenticationException("Invalid username or password");
            }

        } catch (IndexOutOfBoundsException e) {
            throw new AuthenticationException("Username or password is incorrect");
        } catch (Exception e) {
            throw new AuthenticationException(e.getMessage());
        }
    }

    @Override
    public void logOut() {
        setCurrentUser(null);
        setUserDao(null);
    }

    @Override
    public boolean isLoggedIn() {
        return currentUser != null;
    }

    @Override
    public void updatePassword(UserModel userModel, String oldPassword, String newPassword) throws AuthenticationException{

        final UserEntity userEntity = new UserEntity(userModel);
        if (userEntity.getUserPassword().equals(oldPassword)) {
            userEntity.setUserPassword(newPassword);
            try {
                userDao.update(userEntity);
            } catch (SQLException e) {
                throw new AuthenticationException("Unable to update password");
            }
        }
    }
    
}
