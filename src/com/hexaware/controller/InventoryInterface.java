package com.hexaware.controller;

/**
 * Interface for managing inventory-related operations.
 */
public interface InventoryInterface {

	/**
	 * Retrieves and displays details of a specific product in the inventory.
	 */
	public void getProduct();

	/**
	 * Retrieves and displays the current quantity of a specific product in stock.
	 */
	public void getStockQuantity();

	/**
	 * Adds a specified quantity of the product to the inventory.
	 */
	public void addToInventory();

	/**
	 * Removes a specified quantity of the product from the inventory.
	 */
	public void removeFromInventory();

	/**
	 * Updates the stock quantity of a product to a new value.
	 */
	public void updateStockQuantity();

	/**
	 * Checks if a specified quantity of the product is available in the inventory.
	 */
	public void isProductAvailable();

	/**
	 * Calculates the total value of the products in the inventory based on their
	 * prices and quantities.
	 */
	public void getInventoryValue();

	/**
	 * Lists products with quantities below a specified threshold, indicating low
	 * stock.
	 */
	public void listLowStockProducts();

	/**
	 * Lists products that are out of stock.
	 */
	public void listOutOfStockProducts();

	/**
	 * Lists all products in the inventory, along with their quantities.
	 */
	public void listAllProducts();
}
