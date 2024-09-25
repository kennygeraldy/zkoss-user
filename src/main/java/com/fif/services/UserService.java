package com.fif.services;

import com.fif.entity.Log;
import com.fif.entity.User;

import java.util.Date;
import java.util.List;

public interface UserService {

    User addUser(User user);

    List<User> getUsers();

    void deleteUser(User user);

    void updateUser(User user);

    public List<User> searchPersonsByKeyword(String keyword);
//
//    public List<User> search(String keyword);
//
//    void deleteUser(Long id);
//
//    void addUser(String username, String gender, Date birthday, Integer age, String role);
//
//    void updateUser(User user);
}
