package model;

public class Product {
    private int id;
    private String name;
    private String discriptional;
    private double price;
    private double productQuantity;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discriptional='" + discriptional + '\'' +
                ", price=" + price +
                ", productQuantity=" + productQuantity +
                '}';
    }

    public Product(int id, String name, String discriptional, double price, double productQuantity) {
        this.id = id;
        this.name = name;
        this.discriptional = discriptional;
        this.price = price;
        this.productQuantity = productQuantity;
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

    public String getDiscriptional() {
        return discriptional;
    }

    public void setDiscriptional(String discriptional) {
        this.discriptional = discriptional;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
