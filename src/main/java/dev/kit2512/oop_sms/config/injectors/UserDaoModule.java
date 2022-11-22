/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.config.injectors;
import dagger.Module;
import dagger.Provides;
import dev.kit2512.oop_sms.data.database.UserDao;
import dev.kit2512.oop_sms.data.repositories.AuthenticationRepositoryImpl;
import dev.kit2512.oop_sms.domain.repositories.AuthenticationRepository;

import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */

@Module
public class UserDaoModule {
    private final UserDao userDao;


    public UserDaoModule(UserDao userDao) {
        this.userDao = userDao;
    }
    
    @Provides
    @Singleton
    public UserDao userDao() {
        return this.userDao;
    }


    @Provides
    @Singleton
    public AuthenticationRepository authenticationRepository(UserDao userDao) {
        return new AuthenticationRepositoryImpl(userDao);
    }



}
