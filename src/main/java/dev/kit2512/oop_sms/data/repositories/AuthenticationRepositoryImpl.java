/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.data.models.UserModel;
import dev.kit2512.oop_sms.domain.entities.UserEntity;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRespository.AuthenticationException;
import dev.kit2512.oop_sms.data.daos.UserDao.UserDao;
import dev.kit2512.oop_sms.data.daos.UserDao.UserDaoImpl;
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

    private UserEntity currentUser;

    @Override
    public UserEntity getCurrentUser() {
        return currentUser;
    }
    
    private void setCurrentUser(UserEntity currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public UserEntity logIn(String username, String password) throws AuthenticationException {
        try {
            Map<String, Object> query = new HashMap<>();
            query.put("user_username", username);
            query.put("user_password", password);

            final UserModel userModel = userDao.queryForFieldValuesArgs(query).get(0);

            if (userModel != null) {
                setCurrentUser(userModel.mapToEntity());
                return getCurrentUser();
            } else {
                throw new AuthenticationException("Invalid username or password");
            }

        } catch (IndexOutOfBoundsException e) {
            throw new AuthenticationException("Username or password is incorrect");
        } catch (AuthenticationException | SQLException e) {
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
    public void updatePassword(UserEntity userModel, String oldPassword, String newPassword) throws AuthenticationException{

        final UserModel userEntity = new UserModel(userModel);
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
