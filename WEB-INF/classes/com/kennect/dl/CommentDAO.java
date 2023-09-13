package com.kennect.dl;

import com.kennect.beans.Comment;

import java.sql.*;
import java.util.*;

public class CommentDAO {
    private final Connection connection;

    public CommentDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Comment> getAllCommentsByPostId(int postId) throws DAOException {
        List<Comment> comments = new ArrayList<>();
        try {
            String query = "SELECT * FROM comments WHERE postId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, postId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setId(resultSet.getInt("id"));
                comment.setContent(resultSet.getString("content"));
                comment.setUserName(resultSet.getString("userName"));
                comments.add(comment);
            }
        } catch (SQLException e) {
            throw new DAOException("Error while getting comments by post ID");
        }
        return comments;
    }

    
    public int createComment(CommentDTO commentDTO) throws DAOException {
        try {
            String query = "INSERT INTO comments (content, userName, postId) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, commentDTO.getContent());
            preparedStatement.setString(2, commentDTO.getUserName());
            preparedStatement.setInt(3, commentDTO.getPostId());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1); // Return the ID of the newly created comment
            } else {
                throw new DAOException("Failed to create a comment, no ID obtained.");
            }
        } catch (SQLException e) {
            throw new DAOException("Error while creating a comment");
        }
    }
}
