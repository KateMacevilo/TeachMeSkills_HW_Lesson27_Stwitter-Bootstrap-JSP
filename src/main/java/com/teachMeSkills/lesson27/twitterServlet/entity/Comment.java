package com.teachMeSkills.lesson27.twitterServlet.entity;

public class Comment {

    private int id;
    private String text;
    private String userLogin;

    public Comment(int id, String text, String userLogin) {
        this.id = id;
        this.text = text;
        this.userLogin = userLogin;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return userLogin;
    }

    public void setUser(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "Comment: " + '\n' +
                "comment_id=" + id + '\n' +
                "text='" + text + '\n' +
                "userLogin=" + userLogin + '\n';
    }
}
