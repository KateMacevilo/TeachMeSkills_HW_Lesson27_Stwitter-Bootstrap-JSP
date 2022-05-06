package com.teachMeSkills.lesson27.twitterServlet.web.servlet.post;

import com.teachMeSkills.lesson27.twitterServlet.entity.Post;
import com.teachMeSkills.lesson27.twitterServlet.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/postHistory", name = "PostHistoryServlet")
public class PostHistoryServlet extends HttpServlet {

    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Post> allPostsHistory = postService.getAllPosts();

        if (!allPostsHistory.isEmpty()) {
            req.setAttribute("noPosts", false);
            req.setAttribute("allPosts", allPostsHistory);
            getServletContext().getRequestDispatcher("/myPostsPage.jsp").forward(req, resp);
        } else {
            req.setAttribute("noPosts", true);
            getServletContext().getRequestDispatcher("/myPostsPage.jsp").forward(req, resp);
        }
    }
}
