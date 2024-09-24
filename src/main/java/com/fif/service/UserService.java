package com.fif.service;

import com.fif.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public List<User> search(String keyword);
}
