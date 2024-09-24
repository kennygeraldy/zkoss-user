package com.fif.service.Impl;

import com.fif.entity.User;
import com.fif.repository.UserRepository;
import com.fif.service.UserService;

import java.util.*;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepository();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> search(String keyword) {
        List<User> result = new LinkedList<User>();
        List<User> userList = userRepository.findAll();
        if(keyword==null || "".equals(keyword)) {
            result = userList;
        } else {
            for (User u: userList) {
                if(u.getUsername().toLowerCase().contains(keyword.toLowerCase())) {
                    result.add(u);
                }
            }
        }
        return result;
    }

    @Override
    public void deleteUser(String userId) {
        UserRepository.users.removeIf(user -> user.getId() == userId);
    }

    @Override
    public void addUser(String username, String gender, String birthday, Integer age, String role) {
        User newUser = new User(UUID.randomUUID().toString(), username, gender, birthday, age, role);
        userRepository.addUser(newUser);
    }

}
