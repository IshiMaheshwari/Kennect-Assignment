package com.kennect.dl;

public class CommentDTO {
    private String content;
    private String userName;
    private int postId;

    public CommentDTO() {
    }

    public CommentDTO(String content, String userName, int postId) {
        this.content = content;
        this.userName = userName;
        this.postId = postId;
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
