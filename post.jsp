<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.kennect.beans.Post, com.kennect.beans.Comment" %>
<!DOCTYPE html>
<html>
<head>
    <title>Post</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container">
        <h1>Post</h1>
        <div class="post">
            <%
                // Get the post and its comments from your Java code
                Post post = (Post) request.getAttribute("post");
                List<Comment> comments = (List<Comment>) request.getAttribute("comments");
            %>
            <h2><%= post.getUserName() %></h2>
            <p><%= post.getMessage() %></p>
        </div>
        <div class="comments">
            <h2>Comments</h2>
            <%
                for (Comment comment : comments) {
            %>
            <div class="comment">
                <h3><%= comment.getUserName() %></h3>
                <p><%= comment.getMessage() %></p>
            </div>
            <%
                }
            %>
            <!-- Form to add a new comment -->
            <form action="addCommentServlet" method="POST">
                <input type="hidden" name="postId" value="<%= post.getId() %>">
                <label for="commentMessage">Add a comment:</label>
                <textarea id="commentMessage" name="commentMessage" required></textarea>
                <input type="text" id="commentName" name="commentName" placeholder="Your Name" required>
                <button type="submit">Submit Comment</button>
            </form>
        </div>
    </div>
</body>
</html>
