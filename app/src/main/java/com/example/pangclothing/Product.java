package com.example.pangclothing;

public class Product {
    private String productName;
    private String description;
    private double price;
    private String imagePath;
//    private String key;
    public Product() {
        // Default constructor required for calls to DataSnapshot.getValue(Product.class)
    }

    public Product(String productName, String description, double price, String image_path) {
//        this.key = key;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.imagePath = image_path;
    }
    public String getProductName() { return productName; }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath;
    }

}
