package com.javacourse.course.dao;

import com.javacourse.course.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void deleted(Long id);

    void register(User user);

    boolean verifyCredentials(User user);
}
