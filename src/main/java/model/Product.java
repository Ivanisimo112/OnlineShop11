package model;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private double productQuantity;
    private String claim;



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discriptional='" + description + '\'' +
                ", price=" + price +
                ", productQuantity=" + productQuantity +
                '}';
    }

    public Product(int id, String name, String description, double price, double productQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.productQuantity = productQuantity;
    }

    public String getClaim() {
        return claim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                Double.compare(product.productQuantity, productQuantity) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(claim, product.claim);
    }


    public void setClaim(String claim) {
        this.claim = claim;
    }

    public double getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(double productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
