package com.teschMeSkills.lesson27.twitterServlet.web.servlet.user;

import com.teschMeSkills.lesson27.twitterServlet.entity.Role;
import com.teschMeSkills.lesson27.twitterServlet.entity.User;
import com.teschMeSkills.lesson27.twitterServlet.service.UserService;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int userId = userService.getIdUser();
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("radioRole");

        User user = new User();
        user.setIdUser(userId);
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);

        if (role.contains("admin")) {
            user.setRole(Role.ADMIN);
        } else {
            user.setRole(Role.USER);
        }

        boolean isAdded = userService.addUser(user);
        req.setAttribute("isAdded", isAdded);
        if (isAdded) {
            resp.sendRedirect("/authorization.jsp");
           // getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
            resp.setStatus(400);
        }

    }
}
