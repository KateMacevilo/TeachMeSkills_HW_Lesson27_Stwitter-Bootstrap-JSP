package com.teschMeSkills.lesson27.twitterServlet.web.servlet.post;

import com.teschMeSkills.lesson27.twitterServlet.entity.Post;
import com.teschMeSkills.lesson27.twitterServlet.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/postHistory", name = "PostHistoryServlet")
public class PostHistoryServlet extends HttpServlet {

    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Post> allPostsHistory = new ArrayList<>();
        allPostsHistory = postService.getAllPosts();

        if (!allPostsHistory.isEmpty()) {
            for (Post post : allPostsHistory) {
                resp.getWriter().println(post.toString());
            }
        } else {
            resp.getWriter().println("No history yet =(");
        }
    }
}
