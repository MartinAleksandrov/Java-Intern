package com.FitnessAppApplication.FitnessAppApplication.Services;

import com.FitnessAppApplication.FitnessAppApplication.Models.UserRecord;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserServiceImpl implements UserService {

    private static volatile UserServiceImpl instance;
    private final Map<Long,UserRecord> userRecords;
    private long id = 1;

    private UserServiceImpl() {
        userRecords = new HashMap<>();
    }

    @Override
    public UserRecord addUser(UserRecord user) {
        UserRecord newUser = new UserRecord(id++, user.name(), user.age(), user.goal());
        userRecords.put(newUser.id(), newUser);
        return newUser;
    }

    @Override
    public Optional<UserRecord> getUserById(Long id) {

        Optional<UserRecord> userRecord =
                userRecords.containsKey(id) ? Optional.of(userRecords.get(id)) : Optional.empty();
        return userRecord;
    }

    @Override
    public List<UserRecord> getAllUsers() {
        return new ArrayList<>(userRecords.values());
    }

    @Override
    public boolean deleteUser(Long id) {
        if (!userRecords.containsKey(id)) {
            return false;
        }
        userRecords.remove(id);
        return true;
    }


    public static UserServiceImpl getInstance() {
        if (instance == null) {
            synchronized (UserServiceImpl.class) {
                if (instance == null) {
                    instance = new UserServiceImpl();
                }
            }
        }
        return instance;
    }
}
