/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.config.exceptions.AuthenticationException;
import dev.kit2512.oop_sms.data.database.UserDao;
import dev.kit2512.oop_sms.data.database.UserDaoImpl;
import dev.kit2512.oop_sms.data.models.User;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRepository;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/**
 *
 * @author macpro13
 */

public class AuthenticationRepositoryImpl implements AuthenticationRepository {
    @Inject
    public UserDao userDao;

    @Inject
    public AuthenticationRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    private User currentUser;

    @Override
    public User getCurrentUser() {
        return currentUser;
    }
    
    private void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public User logIn(String username, String password) throws AuthenticationException {
        try {
            Map<String, Object> query = new HashMap<>();
            query.put("username", username);
            query.put("password", password);

            final User user = userDao.queryForFieldValuesArgs(query).get(0);
            return user;
        } catch (IndexOutOfBoundsException e) {
            throw new AuthenticationException("Username or password is incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthenticationException("Unknown error. Try again later");
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
    public void updatePassword(User user, String oldPassword, String newPassword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
