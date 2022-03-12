package com.javacourse.course.controllers;

import com.javacourse.course.models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value = "test")
    public List<String> test() {
        return List.of("Apple", "banana", "kiwi") ;
    }

    @RequestMapping(value = "users")
    public List<User> GetUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setId(123L);
        user1.setName("Joe");
        user1.setLastname("Doe");
        user1.setEmail("joedoe@example.com");
        user1.setPhone("234566543");

        User user2 = new User();
        user2.setId(234L);
        user2.setName("Sam");
        user2.setLastname("Samsung");
        user2.setEmail("sam@example.com");
        user2.setPhone("4526663724");

        User user3 = new User();
        user3.setId(456L);
        user3.setName("Jon");
        user3.setLastname("Jon");
        user3.setEmail("jonjon@example.com");
        user3.setPhone("4662637822");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }


}
