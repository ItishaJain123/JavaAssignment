package com.hexaware.controller;

/**
 * Interface for managing product-related operations.
 */
public interface ProductInterface {

	/**
	 * Adds a new product to the system.
	 */
	public void addProduct();

	/**
	 * Retrieves and displays details of a specific product.
	 */
	public void getProductDetails();

	/**
	 * Updates the information of an existing product.
	 */
	public void updateProductInfo();

	/**
	 * Checks if a specific product is currently in stock.
	 */
	public void isProductInStock();

	/**
	 * Retrieves and displays a list of all products.
	 */
	public void getProductList();
}
