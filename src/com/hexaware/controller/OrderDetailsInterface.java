package com.hexaware.controller;

/**
 * Interface for managing order details-related operations.
 */
public interface OrderDetailsInterface {

	/**
	 * Calculates and displays the subtotal of an order detail.
	 */
	public void calculateSubTotal();

	/**
	 * Retrieves and displays details of a specific order detail.
	 */
	public void getOrderDetailInfo();

	/**
	 * Updates the quantity of a specific order detail.
	 */
	public void updateQuantity();

	/**
	 * Adds a discount to a specific order detail.
	 */
	public void addDiscount();
}
