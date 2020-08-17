package dao;

import model.Product;
import model.User;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);
    List<Product> getAll();
    void deleteProduct(int i);
}
