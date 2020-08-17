package dao.impl;

import dao.ProductDao;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static List<Product> productList = new ArrayList<Product>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getAll() {
        return productList;
    }

    @Override
    public void deleteProduct(int i) {
        for (int j = 0; j < productList.size(); j++) {
            if (productList.get(j).getId()==i){
                productList.remove(productList.get(j));
            }
        }
    }
}
