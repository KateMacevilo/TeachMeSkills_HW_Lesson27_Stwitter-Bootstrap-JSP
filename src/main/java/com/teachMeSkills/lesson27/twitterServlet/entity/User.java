package com.teachMeSkills.lesson27.twitterServlet.entity;

public class User {

    private int id;
    private String name;
    private String login;
    private String password;
    private Role role;


    public User(int id, String name, String login, String password, Role role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User:" + '\n' +
                "idUser =" + id + '\n' +
                "name='" + name + '\n' +
                "login='" + login + '\n' +
                "password='" + password + '\n' +
                "role=" + role + '\n';
    }
}
