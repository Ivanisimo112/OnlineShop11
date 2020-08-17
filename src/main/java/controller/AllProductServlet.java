package controller;
import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

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


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> allProducts = productService.getAll();
        req.setAttribute("allProducts",allProducts);
        req.getRequestDispatcher("products.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int delete = Integer.parseInt(req.getParameter("delete"));
        productService.deleteProduct(delete);
        resp.sendRedirect("/products");
    }
}
