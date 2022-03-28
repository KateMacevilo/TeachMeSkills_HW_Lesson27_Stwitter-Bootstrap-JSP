package com.teschMeSkills.lesson27.twitterServlet.web.servlet.post;

import com.teschMeSkills.lesson27.twitterServlet.entity.*;
import com.teschMeSkills.lesson27.twitterServlet.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/post", name = "PostServlet")
public class PostServlet extends HttpServlet {

    private final PostService postService = new PostService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idPost = postService.getPostId();
        String text = req.getParameter("text");
        User user = (User) req.getSession().getAttribute("user");

        Post post = new Post(idPost, text, user, new ArrayList<Comment>(), new ArrayList<Like>());
        boolean isAdded = postService.addPost(post);

        if (isAdded) {
            resp.getWriter().println("Post added " + post.toString());
        } else {
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");

        List<Post> allPosts = new ArrayList<>();
        if (user.getRole() == Role.ADMIN) {
            allPosts = postService.getAllPosts();
        } else {
            allPosts = postService.getAllPostsByLogin(user.getLogin());
        }


        if (allPosts.isEmpty()) {
            resp.getWriter().println("No posts yet");
            resp.setStatus(204);

        } else {
            req.setAttribute("allPosts", allPosts);
//            for (Post post : allPosts) {
//                resp.getWriter().println(post.toString());
//            }
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idPost = Integer.parseInt(req.getParameter("idPost"));
        User user = (User) req.getSession().getAttribute("user");
        boolean isDeleted = false;

        if (user.getRole().equals(Role.ADMIN)) {
            String loginUser = postService.getLoginByIdPost(idPost);
            isDeleted = postService.deletePost(idPost, loginUser);
        } else {
            isDeleted = postService.deletePost(idPost, user.getLogin());
        }

        if (isDeleted) {
            resp.getWriter().println("Post was deleted");
        } else {
            resp.getWriter().println("Error, no access");
            resp.setStatus(400);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idPost = Integer.parseInt(req.getParameter("idPost"));
        String text = req.getParameter("text");
        User user = (User) req.getSession().getAttribute("user");
        boolean isEdit = false;

        if (user.getRole().equals(Role.ADMIN)) {
            String loginUser = postService.getLoginByIdPost(idPost);
            isEdit = postService.editPost(idPost, text, loginUser);
        } else {
            isEdit = postService.editPost(idPost, text, user.getLogin());
        }

        if (isEdit) {
            resp.getWriter().println("Post was edited");
        } else {
            resp.getWriter().println("Error, no access");
            resp.setStatus(400);
        }

    }
}
