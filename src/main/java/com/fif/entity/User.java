package com.fif.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "User")
public class User implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Date birthday;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String role;

    public User() {}

    public User(String username, String gender, Date birthday, Integer age, String role) {
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getId() {
        return id;
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
}
