package com.fif.repository;

import com.fif.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository {
    public static List<User> users = new ArrayList<User>();

    static {
        users.add(new User(UUID.randomUUID().toString(), "Kenny Geraldy", "male", "2020-1-8", 22, "Front-End Developer"));
        users.add(new User(UUID.randomUUID().toString(), "Jona Kentyck", "male", "2020-1-8", 23, "Back-End Developer"));
        users.add(new User(UUID.randomUUID().toString(), "Kezia Amelia", "female", "2000-11-2", 25, "Front-End Developer"));
        users.add(new User(UUID.randomUUID().toString(), "Unlocki Dharma", "male", "2010-02-2", 26, "Front-End Developer"));
        users.add(new User(UUID.randomUUID().toString(), "Nathania Coa", "female", "2002-09-2", 27, "Full-Stack Developer"));
    }

    public List<User> findAll() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
