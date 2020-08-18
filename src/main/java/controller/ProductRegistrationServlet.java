package controller;

import model.Product;
import model.User;
import service.ProductService;
import service.impl.ProductServiceImpl;
import utils.ProductIdGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/addProduct")
public class ProductRegistrationServlet extends HttpServlet {
    private static final ProductService productService = new ProductServiceImpl();
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addProduct.jsp").forward(req,resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = ProductIdGenerator.getNextId();
        String name = req.getParameter("name");
        String discriptional = req.getParameter("discriptional");
        if (name.length()!=0 && discriptional.length()!=0
                && req.getParameter("price").length()!=0
                && req.getParameter("productQuantity").length()!=0){
            double price = Double.parseDouble(req.getParameter("price"));
            double productQuantity =Double.parseDouble(req.getParameter("productQuantity"));
            Product product = new Product(id,name,discriptional,price,productQuantity);
            productService.addProduct(product);
            System.out.println("Кладем продукт в бд");
            System.out.println(product);
            System.out.println("айди статик:" + id);
            resp.sendRedirect("/products");
        }else{
            req.setAttribute("name",name);
            req.setAttribute("discriptional",discriptional);
            req.setAttribute("error2","You have not completed all the fields");
            req.getRequestDispatcher("addProduct.jsp").forward(req,resp );
        }
    }
}
