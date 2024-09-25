package com.fif.services.impl;

import com.fif.entity.Log;
import com.fif.entity.User;
import com.fif.repository.UserRepository;
import com.fif.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service("userService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.queryAll();
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }

    public List<User> searchPersonsByKeyword(String keyword) {
        return userRepository.searchByKeyword(keyword);
    }
//    private UserRepository userRepository;
//
//    public UserServiceImpl() {
//        this.userRepository = new UserRepository();
//    }
//
//    @Override
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    public List<User> search(String keyword) {
//        List<User> result = new LinkedList<User>();
//        List<User> userList = userRepository.findAll();
//        if(keyword==null || "".equals(keyword)) {
//            result = userList;
//        } else {
//            for (User u: userList) {
//                if(u.getUsername().toLowerCase().contains(keyword.toLowerCase())) {
//                    result.add(u);
//                }
//            }
//        }
//
//        return result;
//    }
//
//    @Override
//    public void deleteUser(Long userId) {
//        UserRepository.users.removeIf(user -> user.getId() == userId);
//    }
//
//    @Override
//    public void addUser(String username, String gender, Date birthday, Integer age, String role) {
//        User newUser = new User(1L , username, gender, birthday, age, role);
//        userRepository.addUser(newUser);
//    }
//
//    @Override
//    public void updateUser(User updatedUser) {
//        userRepository.findAll().stream()
//                .filter(user -> user.getId().equals(updatedUser.getId()))
//                .findFirst()
//                .ifPresent(existingUser -> {
//                    existingUser.setUsername(updatedUser.getUsername());
//                    existingUser.setGender((updatedUser.getGender()));
//                    existingUser.setAge(updatedUser.getAge());
//                    existingUser.setBirthday(updatedUser.getBirthday());
//                    existingUser.setRole(updatedUser.getRole());
//                });
//    }
}
