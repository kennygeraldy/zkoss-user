package com.fif.service;

import com.fif.entity.User;

import java.util.List;

import static com.fif.repository.UserRepository.users;

public interface UserService {
    public List<User> findAll();

    public List<User> search(String keyword);

    void deleteUser(String id);

    void addUser(String username, String gender, String birthday, Integer age, String role);
}
