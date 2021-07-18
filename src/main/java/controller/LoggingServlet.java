package controller;

import factory.UserServiceFactory;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/login")
public class LoggingServlet extends HttpServlet {
    private static final UserService userService = UserServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Optional<User> optUser = userService.findUserByEmail(email);
        if (!userService.findUserByEmail(email).isPresent()) {
            req.setAttribute("error3", "You are not registred");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            if (optUser.isPresent() && optUser.get().getPassword().equals(password)) {
                HttpSession session = req.getSession();
                session.setAttribute("user", optUser.get());
                if (optUser.get().getRole().equals("admin")) {
                    resp.sendRedirect("/users");
                } else {
                    resp.sendRedirect("/products");
                }
            } else {
                resp.sendRedirect("/");
            }
        }
    }
}
