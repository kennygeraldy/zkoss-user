package com.fif.service.Impl;

import com.fif.entity.User;
import com.fif.service.UserService;

import java.util.LinkedList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private List<User> userList = new LinkedList<User>();

    private int id = 1;

    public UserServiceImpl() {
        userList.add(
                new User(id++,
                        "KGeraldy",
                        "male",
                        "2001-26-11",
                        22,
                        "Front-End Developer"));
        userList.add(
                new User(id++,
                        "JBond",
                        "male",
                        "2000-26-08",
                        24,
                        "Back-End Developer"));
        userList.add(
                new User(id++,
                        "KelvinsC",
                        "male",
                        "1998-28-01",
                        26,
                        "Full-Stack Developer"));


    }

    public List<User> findAll() {
        return userList;
    }

    public List<User> search(String keyword) {
        List<User> result = new LinkedList<User>();
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
}
