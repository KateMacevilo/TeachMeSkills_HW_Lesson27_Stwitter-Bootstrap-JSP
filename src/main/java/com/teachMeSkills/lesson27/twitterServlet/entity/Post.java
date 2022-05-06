package com.teachMeSkills.lesson27.twitterServlet.entity;

import java.util.List;

public class Post {

    private int id;
    private String text;
    private User user;
    private List<Comment> commentList;
    private List<Like> likeList;

    public Post() {
    }

    public Post(int post_id, String text, User user, List<Comment> commentList, List<Like> likeList) {
        this.id = post_id;
        this.text = text;
        this.user = user;
        this.commentList = commentList;
        this.likeList = likeList;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public int getCountLikes() {
        return this.likeList.size();
    }

    public List<Like> getLikeList() {
        return likeList;
    }

    public void setLikeList(List<Like> likeList) {
        this.likeList = likeList;
    }

    @Override
    public String toString() {
        return "Post:" + '\n' +
                "idPost: " + id + '\n' +
                "user:" + user.getLogin() + '\n' +
                "text: '" + text + '\n' +
                "commentList=" + commentList + '\n' +
                "likes=" + getCountLikes() + '\n';

    }
}
