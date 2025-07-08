package com.FitnessAppApplication.FitnessAppApplication.Controllers;

import com.FitnessAppApplication.FitnessAppApplication.Models.UserRecord;
import com.FitnessAppApplication.FitnessAppApplication.Services.UserService;
import com.FitnessAppApplication.FitnessAppApplication.Services.UserServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Scope("prototype")
@Profile("dev")
public class UserController {

    @Autowired(required = false)
    private final UserService userService = UserServiceImpl.getInstance();



    @PostMapping
    public UserRecord createUser(@RequestBody UserRecord user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public Optional<UserRecord> getById(@PathVariable long id) {

        Optional<UserRecord> userRecord = userService.getUserById(id);
        return userRecord;
    }

    @GetMapping("/all")
    public List<UserRecord> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        if (!userService.deleteUser(id)) {
            return "User not found";
        }
        return "User deleted";
    }

}