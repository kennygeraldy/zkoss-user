package com.fif.services.impl;

import com.fif.entity.User;
import com.fif.repository.UserRepository;
import com.fif.services.UserService;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

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
    public void addUser(String username, String gender, Date birthday, Integer age, String role) {
        User newUser = new User(UUID.randomUUID().toString(), username, gender, birthday, age, role);
        userRepository.addUser(newUser);
    }

    @Override
    public void updateUser(User updatedUser) {
        userRepository.findAll().stream()
                .filter(user -> user.getId().equals(updatedUser.getId()))
                .findFirst()
                .ifPresent(existingUser -> {
                    existingUser.setUsername(updatedUser.getUsername());
                    existingUser.setGender((updatedUser.getGender()));
                    existingUser.setAge(updatedUser.getAge());
                    existingUser.setBirthday(updatedUser.getBirthday());
                    existingUser.setRole(updatedUser.getRole());
                });
    }

}
