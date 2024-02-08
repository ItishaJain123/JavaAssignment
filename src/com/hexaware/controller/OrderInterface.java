package com.hexaware.controller;

/**
 * Interface for managing order-related operations.
 */
public interface OrderInterface {

	/**
	 * Calculates and displays the total amount of an order.
	 */
	public void calculateTotalAmount();

	/**
	 * Retrieves and displays details of a specific order.
	 */
	public void getOrderDetails();

	/**
	 * Updates the status of a specific order.
	 */
	public void updateOrderStatus();

	/**
	 * Cancels a specific order.
	 */
	public void cancelOrder();
}
