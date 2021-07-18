package controller;

import model.User;
import service.ProductService;
import service.UserService;
import service.impl.ProductServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
    private static final ProductService productService = new ProductServiceImpl();
    private static final UserService userService = new UserServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User userFromSession = (User) req.getSession().getAttribute("user");
        if (userFromSession == null) {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            userFromSession.setBasket(new ArrayList<>());
            resp.sendRedirect("/products");
        }
    }
}
