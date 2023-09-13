package com.kennect.servlets;

import com.kennect.beans.*;
import com.kennect.dl.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.util.List;


public class PostServlet extends HttpServlet {
    private PostDAO postDAO;

    public void init() throws ServletException {
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
       try
{
  List<Post> posts = postDAO.getAllPosts();
        request.setAttribute("posts", posts);

        request.getRequestDispatcher("/post.jsp").forward(request, response);
} catch (DAOException e) {
            // Handle the exception and show an error message
            request.setAttribute("errorMessage", "Error creating the post: " + e.getMessage());
           // request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String content = request.getParameter("content");
        String userName = request.getParameter("userName");

        PostDTO postDTO = new PostDTO(content, userName);

        try {
            int postId = postDAO.createPost(postDTO);
            // Optionally, you can redirect to the post details page
            response.sendRedirect("PostDetailsServlet?postId=" + postId);
        } catch (DAOException e) {
            // Handle the exception and show an error message
            request.setAttribute("errorMessage", "Error creating the post: " + e.getMessage());
           // request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
