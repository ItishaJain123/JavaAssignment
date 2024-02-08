/**
 * The `Inventory` class represents the inventory information of a product, including
 * the inventory ID, associated product, quantity in stock, and the date of the last stock update.
 * It provides methods to retrieve and set these attributes, ensuring proper validation for
 * quantity in stock to be non-negative.
 * 
 * Usage:
 * ```
 * // Create a new inventory
 * Inventory inventory = new Inventory(1, new Product("123", "Laptop", 999.99), 50, new Date());
 * 
 * // Access and modify inventory attributes
 * inventory.setQuantityInStock(60);
 * 
 * // Retrieve inventory details
 * System.out.println("Inventory ID: " + inventory.getInventoryID());
 * System.out.println("Product Name: " + inventory.getProduct().getProductName());
 * System.out.println("Quantity in Stock: " + inventory.getQuantityInStock());
 * System.out.println("Last Stock Update: " + inventory.getLastStockUpdate());
 * ```
 * 
 * Note: Ensure proper validation for quantity in stock to be non-negative before setting the attribute.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-01
 */

package com.hexaware.entity;

import java.util.Date;

public class Inventory {
    private int inventoryID;
    private Product product;
    private int quantityInStock;
    private Date lastStockUpdate;

    // Constructor
    public Inventory(int inventoryID, Product product, int quantityInStock, Date lastStockUpdate) {
        this.inventoryID = inventoryID;
        this.product = product;
        this.quantityInStock = quantityInStock;
        this.lastStockUpdate = lastStockUpdate;
    }
    
    public Inventory() {}

    // Getter and Setter for InventoryID
    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    // Getter and Setter for Product
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // Getter and Setter for QuantityInStock
    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
    	if (quantityInStock >= 0) {
    		this.quantityInStock = quantityInStock;	
    	}
    }

    // Getter and Setter for LastStockUpdate
    public Date getLastStockUpdate() {
        return lastStockUpdate;
    }

    public void setLastStockUpdate(Date lastStockUpdate) {
        this.lastStockUpdate = lastStockUpdate;
    }

	@Override
	public String toString() {
		return "Inventory [inventoryID=" + inventoryID + ", product=" + product.getProductName() + ", quantityInStock=" + quantityInStock
				+ ", lastStockUpdate=" + lastStockUpdate + "]";
	}
}