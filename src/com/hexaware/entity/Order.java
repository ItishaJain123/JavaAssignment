/**
 * The `Order` class represents an order made by a customer, including
 * the order ID, associated customer, order date, total amount, and order status.
 * It provides methods to retrieve and set these attributes, ensuring proper validation
 * for total amount to be positive and for valid order statuses.
 * 
 * Usage:
 * ```
 * // Create a new order
 * Order order = new Order(1, new Customer(101, "John", "Doe", "john.doe@example.com", "1234567890", "123 Main St"),
 *                           new Date(), 150.00, "PROCESSING");
 * 
 * // Access and modify order attributes
 * order.setTotalAmount(200.00);
 * order.setOrderStatus("SHIPPED");
 * 
 * // Retrieve order details
 * System.out.println("Order ID: " + order.getOrderID());
 * System.out.println("Customer: " + order.getCustomer().getFullName());
 * System.out.println("Order Date: " + order.getOrderDate());
 * System.out.println("Total Amount: $" + order.getTotalAmount());
 * System.out.println("Order Status: " + order.getOrderStatus());
 * ```
 * 
 * Note: Ensure proper validation for total amount to be positive and for valid order statuses
 * before setting the corresponding attributes.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-01
 */

package com.hexaware.entity;

import java.util.Date;

public class Order {
    private int orderID;
    private Customer customer;
    private Date orderDate;
    private double totalAmount;
    private String orderStatus;
    
    // Constructor
    public Order() {}

    // Parameterized Constructor
    public Order(int orderID, Customer customer, Date orderDate, double totalAmount, String orderStatus) {
        this.orderID = orderID;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
    }

	// Getter and Setter for OrderID
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		if (totalAmount > 0) {
			this.totalAmount = totalAmount;
		}
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		if (orderStatus.equals("PROCESSING") || orderStatus.equals("SHIPPED") || orderStatus.equals("CANCELLED")){
			this.orderStatus = orderStatus;			
		}
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", customer=" + customer + ", orderDate=" + orderDate + ", totalAmount="
				+ totalAmount + "]";
	}
}