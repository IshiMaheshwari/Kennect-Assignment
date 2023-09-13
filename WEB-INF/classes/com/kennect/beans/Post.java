package com.kennect.beans;

public class Post {
    private int id;
    private String content;
    private String userName;

    public Post() {
    }

    public Post(String content, String userName) {
        this.content = content;
        this.userName = userName;
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
}
