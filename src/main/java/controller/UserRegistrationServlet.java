package controller;

import factory.UserServiceFactory;
import model.User;
import org.w3c.dom.ls.LSOutput;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register")
public class UserRegistrationServlet extends HttpServlet {

    private static final UserService userService = UserServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req,resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeatPassword");
        if (password.equals(repeatPassword)){
            User user = new User(1L,email,password,"user");
            userService.addUser(user);
            System.out.println("Кладем юзера в бд");
            System.out.println(user);
            resp.sendRedirect("/products");
        }else{
            req.setAttribute("error","Your passwords not equals");
            req.setAttribute("email",email);
            req.getRequestDispatcher("register.jsp").forward(req,resp );
        }
    }
}
