package com.kennect.beans;

public class Comment {
    private int id;
    private String content;
    private String userName;
    private int postId;

    public Comment() {
    }

    public Comment(String content, String userName, int postId) {
        this.content = content;
        this.userName = userName;
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
