package com.teachMeSkills.lesson27.twitterServlet.web.servlet.user;

import com.teachMeSkills.lesson27.twitterServlet.entity.Role;
import com.teachMeSkills.lesson27.twitterServlet.entity.User;
import com.teachMeSkills.lesson27.twitterServlet.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/authorization", name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {

    private final UserService userService = new UserService();
    private static Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        logger.debug("Start authorization {}", login);
        User user = userService.findByLogin(login);

        if (user.getLogin() != null) {
            boolean result = user.getPassword().equals(password);
            if (result) {
                logger.debug("Success authorization {}", login);
                req.getSession().setAttribute("user", user);

                if (user.getRole().equals(Role.ADMIN)){
                    req.getSession().setAttribute("admin", user.getLogin());
                } else {
                    req.getSession().setAttribute("notAdmin", user.getLogin());
                }

                req.setAttribute("isAdded", result);
                getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
            } else {
                logger.debug("Error authorization {}", login);
                getServletContext().getRequestDispatcher("/myPostsPage.jsp").forward(req, resp);
                resp.setStatus(401);
            }
        } else {
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(req, resp);
        }

    }
}
