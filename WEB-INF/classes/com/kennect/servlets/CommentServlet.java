package com.kennect.servlets;

import com.kennect.beans.*;
import com.kennect.dl.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;


public class CommentServlet extends HttpServlet {
    private CommentDAO commentDAO;

    public void init() throws ServletException {
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int postId = Integer.parseInt(request.getParameter("postId"));

        try {
            List<Comment> comments = commentDAO.getAllCommentsByPostId(postId);
            request.setAttribute("comments", comments);
            request.getRequestDispatcher("/comments.jsp").forward(request, response);
        } catch (DAOException e) {
            // Handle the exception and show an error message
            request.setAttribute("errorMessage", "Error retrieving comments: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        String userName = request.getParameter("userName");
        int postId = Integer.parseInt(request.getParameter("postId"));

        CommentDTO commentDTO = new CommentDTO(content, userName, postId);

        try {
            int commentId = commentDAO.createComment(commentDTO);
            // Optionally, you can redirect to the post details page
            response.sendRedirect("PostDetailsServlet?postId=" + postId);
        } catch (DAOException e) {
            // Handle the exception and show an error message
            request.setAttribute("errorMessage", "Error creating the comment: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
