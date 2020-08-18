package controller;

import model.Product;
import model.User;
import service.ProductService;
import service.UserService;
import service.impl.ProductServiceImpl;
import service.impl.UserServiceImpl;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class AllProductServlet extends HttpServlet {
    private static final ProductService productService = new ProductServiceImpl();
    private static final UserService userService = new UserServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User userFromSession = (User) req.getSession().getAttribute("user");
        List<Product> allProducts = productService.getAll();
        req.setAttribute("allProducts", allProducts);
        if (userFromSession != null && userFromSession.getBasket() != null) {
            req.setAttribute("basket", userFromSession.getBasket());
        }
        req.getRequestDispatcher("products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //int delete = Integer.parseInt(req.getParameter("delete"));
        // productService.deleteProduct(delete);
        User userFromSession = (User) req.getSession().getAttribute("user");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String discriptional = req.getParameter("discriptional");
        double productQuantity = Double.parseDouble(req.getParameter("productQuantity"));
        userService.addBasket(new Product(0, name, discriptional, price, productQuantity),userFromSession);
        resp.sendRedirect("/products");
    }
}
