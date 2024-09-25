package com.fif.services;

import com.fif.entity.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    public List<User> findAll();

    public List<User> search(String keyword);

    void deleteUser(String id);

    void addUser(String username, String gender, Date birthday, Integer age, String role);

    void updateUser(User user);
}
