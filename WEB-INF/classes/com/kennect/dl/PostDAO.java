package com.kennect.dl;

import com.kennect.beans.Post;
import java.sql.*;
import java.util.*;

public class PostDAO {
    private Connection connection;

    public PostDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Post> getAllPosts() throws DAOException {
        List<Post> posts = new ArrayList<>();
        try {
            String query = "SELECT * FROM posts";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getInt("id"));
                post.setContent(resultSet.getString("content"));
                post.setUserName(resultSet.getString("userName"));
                posts.add(post);
            }
        } catch (SQLException e) {
            throw new DAOException("Error while fetching all posts: " + e.getMessage());
        }
        return posts;
    }

   

    public int createPost(PostDTO postDTO) throws DAOException {
        try {
            String query = "INSERT INTO posts (content, userName) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, postDTO.getContent());
            preparedStatement.setString(2, postDTO.getUserName());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1); // Return the ID of the newly created post.
            } else {
                throw new DAOException("Creating post failed, no ID obtained.");
            }
        } catch (SQLException e) {
            throw new DAOException("Error while creating post: " + e.getMessage());
        }
    }

    public void addComment(int postId, CommentDTO commentDTO) throws DAOException {
        try {
            String query = "INSERT INTO comments (content, userName, postId) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, commentDTO.getContent());
            preparedStatement.setString(2, commentDTO.getUserName());
            preparedStatement.setInt(3, postId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error while adding comment: " + e.getMessage());
        }
    }
}
