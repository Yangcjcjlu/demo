package com.yang.service;

import com.yang.model.User;

public class UserServiceImpl implements UserService {

    private static User user = null;

    @Override
    public User createUser(String firstName, String lastName, int age) {
        user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        return user;
    }

    @Override
    public User queryUser() {
       return user;
    }
}
