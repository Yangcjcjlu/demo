package com.yang.service;

import com.yang.model.User;

public interface UserService {
    User createUser(String firstName, String lastName, int age);

    User queryUser();
}
