package com.fif.viewModel;

import com.fif.entity.User;
import com.fif.service.Impl.UserServiceImpl;
import com.fif.service.UserService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

import java.util.List;
import java.util.UUID;

public class SearchViewModel {

    private String keyword;

    private List<User> userList = new ListModelList<User>();

    private User selectedUser;

    private UserService userService = new UserServiceImpl();

    private String username;

    private String gender;

    private String birthday;

    private Integer age;

    private String role;

    @Command
    public void search() {
        userList.clear();
        userList.addAll(userService.search(keyword));

        UUID.randomUUID().toString();
    }

    public SearchViewModel() {
        userList.addAll(userService.findAll());
    }

    @Command
    @NotifyChange("userList")
    public void delete() {
        if (selectedUser == null) throw new RuntimeException("Please select a user before delete");

        userService.deleteUser(selectedUser.getId());
        userList.remove(selectedUser);
        selectedUser = null;

        System.out.println("User deleted successfully.");
    }

    @Command
    @NotifyChange("userList")
    public void add() {
        userService.addUser(username, gender, birthday, age, role);
        System.out.println(username);
        System.out.println(userService);

    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public UserService getUserService() {
        return userService;
    }

    public String getUsername() {
        return username;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public Integer getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setRole(String role) {
        this.role = role;
    }

}