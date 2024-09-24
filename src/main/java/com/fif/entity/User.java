package com.fif.entity;

public class User {

    private String id;

    private String username;

    private String gender;

    private String birthday;

    private Integer age;

    private String role;

    public User(String id, String username, String gender, String birthday, Integer age, String role) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
        this.role = role;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getId() {
        return id;
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
}
