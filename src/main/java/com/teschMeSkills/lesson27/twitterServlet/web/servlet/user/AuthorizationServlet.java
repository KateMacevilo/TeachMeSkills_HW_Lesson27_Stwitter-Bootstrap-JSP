package com.teschMeSkills.lesson27.twitterServlet.web.servlet.user;

import com.teschMeSkills.lesson27.twitterServlet.entity.User;
import com.teschMeSkills.lesson27.twitterServlet.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/authorization", name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = userService.findByLogin(login);

        if (user.getLogin() != null) {

            if (user.getPassword().equals(password)) {
                req.getSession().setAttribute("user", user);
                resp.getWriter().println("Success");
            } else {
                resp.getWriter().println("Wrong Password!");
                resp.setStatus(401);
            }
        } else {
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(req, resp);
        }

    }
}
