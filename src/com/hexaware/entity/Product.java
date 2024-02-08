/**
 * The `Product` class represents a product in the inventory, including
 * the product ID, product name, description, and price.
 * It provides methods to retrieve and set these attributes, ensuring proper validation
 * for the price to be positive.
 * 
 * Usage:
 * ```
 * // Create a new product
 * Product product = new Product(1, "Laptop", "High-performance laptop with advanced features", 999.99);
 * 
 * // Access and modify product attributes
 * product.setPrice(1099.99);
 * 
 * // Retrieve product details
 * System.out.println("Product ID: " + product.getProductID());
 * System.out.println("Product Name: " + product.getProductName());
 * System.out.println("Description: " + product.getDescription());
 * System.out.println("Price: Rs" + product.getPrice());
 * ```
 * 
 * Note: Ensure proper validation for the price to be positive before setting the attribute.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-01
 */

package com.hexaware.entity;

public class Product {
    private int productID;
    private String productName;
    private String description;
    private double price;

    // Constructor without parameters
    public Product() {}

	// Parameterized Constructor
    public Product(int productID, String productName, String description, double price) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    // Getter and Setter for ProductID
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    // Getter and Setter for ProductName
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter and Setter for Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for Price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		}
    }
    
    @Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + "]";
	}
}