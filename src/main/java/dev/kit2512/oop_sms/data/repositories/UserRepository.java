package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.data.database.UserDao;

import javax.inject.Inject;

public class UserRepository {
    private final UserDao userDao;

    @Inject
    public UserRepository(UserDao userDao) {
        this.userDao = userDao;
    }
}
