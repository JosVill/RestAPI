package com.javacourse.course.controllers;

import com.javacourse.course.models.User;
import com.javacourse.course.dao.UserDao;
import com.javacourse.course.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        if (userDao.verifyCredentials(user)) {

        }
        return "FAIL";
    }
}
