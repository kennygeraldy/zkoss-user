package com.fif.repository;

import com.fif.entity.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository {
    public static List<User> users = new ArrayList<User>();


    static {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            users.add(new User(UUID.randomUUID().toString(), "Kenny Geraldy", "male", sdf.parse("2020-1-8"), 22, "Front-End Developer"));
            users.add(new User(UUID.randomUUID().toString(), "Jona Kentyck", "male", sdf.parse("2020-1-8"), 23, "Back-End Developer"));
            users.add(new User(UUID.randomUUID().toString(), "Kezia Amelia", "female", sdf.parse("2000-11-2"), 25, "Front-End Developer"));
            users.add(new User(UUID.randomUUID().toString(), "Unlocki Dharma", "male", sdf.parse("2010-02-2"), 26, "Front-End Developer"));
            users.add(new User(UUID.randomUUID().toString(), "Nathania Coa", "female", sdf.parse("2010-02-2"), 27, "Full-Stack Developer"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        };
    }

    public List<User> findAll() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
