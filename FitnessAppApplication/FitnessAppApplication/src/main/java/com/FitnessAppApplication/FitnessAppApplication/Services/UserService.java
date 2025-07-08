package com.FitnessAppApplication.FitnessAppApplication.Services;

import com.FitnessAppApplication.FitnessAppApplication.Models.UserRecord;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserRecord addUser(UserRecord user);
    Optional<UserRecord> getUserById(Long id);
    List<UserRecord> getAllUsers();
    boolean deleteUser(Long id);
}
