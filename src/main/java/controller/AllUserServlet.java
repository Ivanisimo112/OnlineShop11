package controller;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class AllUserServlet extends HttpServlet {
    private static final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUsers = userService.getAll();

        User userFromSession = (User)req.getSession().getAttribute("user");
        if(userFromSession!=null && (userFromSession.getRole().equals("admin"))){
            req.setAttribute("allUsers",allUsers);
            req.getRequestDispatcher("users.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("403.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long delete = Long.valueOf(req.getParameter("delete"));
        userService.deleteUser(delete);
        resp.sendRedirect("/users");
    }
}
