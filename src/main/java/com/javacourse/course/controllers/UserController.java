package com.javacourse.course.controllers;

import com.javacourse.course.dao.UserDao;
import com.javacourse.course.models.User;
import com.javacourse.course.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "test")
    public List<String> test() {
        return List.of("Apple", "banana", "kiwi") ;
    }

    @RequestMapping(value = "api/users")
    public List<User> GetUsers(@RequestHeader(value = "Authorization") String token) {
        if (!validateToken(token)) {
            return null;
        }

        return userDao.getUsers();
    }

    private boolean validateToken(String token) {
        String userId = jwtUtil.getKey(token);
        return userId != null;
   }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void DeleteUser(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) {

        if (validateToken(token)) {
            return;
        }
        userDao.deleted(id);
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void RegisterUser(@RequestBody User user) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        @Deprecated
        String hash = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);

        userDao.register(user);
    }
}
