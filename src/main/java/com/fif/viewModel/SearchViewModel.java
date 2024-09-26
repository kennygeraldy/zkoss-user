package com.fif.viewModel;

import com.fif.entity.User;
import com.fif.services.UserService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import java.util.Date;
import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class SearchViewModel {
    @WireVariable
    private UserService userService;

    private String keyword;

    private List<User> userList;

    private User selectedUser;

    private String username;

    private String gender;

    private Date birthday;

    private Integer age;

    private String role;



    @Init
    public void init() {
        keyword = "";
        userList = new ListModelList<>();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            userService.addUser(new User("Kenny Geraldy", "male", sdf.parse("2020-1-8"), 22, "Front-End Developer"));
//            userService.addUser(new User("Jona Kentyck", "male", sdf.parse("2020-1-8"), 23, "Back-End Developer"));
//            userService.addUser(new User("Kezia Amelia", "female", sdf.parse("2000-11-2"), 25, "Front-End Developer"));
//            userService.addUser(new User("Unlocki Dharma", "male", sdf.parse("2010-02-2"), 26, "Front-End Developer"));
//            userService.addUser(new User("Nathania Coa", "female", sdf.parse("2010-02-2"), 27, "Full-Stack Developer"));
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        };
        userList.addAll(userService.getUsers());
    }

    @Command
    @NotifyChange("userList")
    public void delete() {
        if (selectedUser == null) throw new RuntimeException("Please select a user before delete");

        userService.deleteUser(selectedUser);
        userList.remove(selectedUser);
        selectedUser = null;

        System.out.println("User deleted successfully.");
    }

    @Command
    @NotifyChange("userList")
    public void add() {
        User newUser = new User(username, gender, birthday, age, role);
        userService.addUser(newUser);
        userList.add(newUser);
        Executions.sendRedirect("output-table.zul");

    }

    @Command
    @NotifyChange({"userList", "selectedUser"})
    public void update() {
        if (selectedUser == null) throw new RuntimeException("Please select a user before update");
        userService.updateUser(selectedUser);
        System.out.println(userService);
    }

    @Command
    @NotifyChange("personList")
    public void search() {
        selectedUser = null;
        userList.clear();
        userList.addAll(userService.searchPersonsByKeyword(keyword));
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

    public Date getBirthday() {
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

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setRole(String role) {
        this.role = role;
    }

}