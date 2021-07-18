package controller;

import model.Product;
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

@WebServlet("/claim")
public class ClaimServlet extends HttpServlet {
    private static final ProductService productService = new ProductServiceImpl();
    private static final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("claim.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String claim = req.getParameter("claim");
        String product = req.getParameter("claimOnProduct");
        for (int i = 0; i < productService.getAll().size(); i++) {
            if(productService.getAll().get(i).getName().equals(product)){
                productService.getAll().get(i).setClaim(claim);
                System.out.println("Добавлена жалоба на продукт " + productService.getAll().get(i).getName());
                break;
            }
        }
        resp.sendRedirect("/");
    }
}
