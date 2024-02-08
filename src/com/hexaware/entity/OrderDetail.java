/**
 * The `OrderDetail` class represents the details of a product within an order,
 * including the order detail ID, associated order, product, and quantity.
 * It provides methods to retrieve and set these attributes, ensuring proper validation
 * for the quantity to be positive.
 * 
 * Usage:
 * ```
 * // Create a new order detail
 * OrderDetail orderDetail = new OrderDetail(1, new Order(101, new Customer(), new Date(), 150.00, "PROCESSING"),
 *                                           new Product("123", "Laptop", 999.99), 2);
 * 
 * // Access and modify order detail attributes
 * orderDetail.setQuantity(3);
 * 
 * // Retrieve order detail details
 * System.out.println("Order Detail ID: " + orderDetail.getOrderDetailID());
 * System.out.println("Order ID: " + orderDetail.getOrder().getOrderID());
 * System.out.println("Product Name: " + orderDetail.getProduct().getProductName());
 * System.out.println("Quantity: " + orderDetail.getQuantity());
 * ```
 * 
 * Note: Ensure proper validation for quantity to be positive before setting the attribute.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-01
 */

package com.hexaware.entity;

public class OrderDetail{

	private int orderDetailID;
    private Order order;
    private Product product;
    private int quantity;

    // Constructor
    public OrderDetail(int orderDetailID, Order order, Product product, int quantity) {
        this.orderDetailID = orderDetailID;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public OrderDetail() {}

	// Getter and Setter for OrderDetailID
    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    // Getter and Setter for Order
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    // Getter and Setter for Product
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // Getter and Setter for Quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
        	this.quantity = quantity;        	
        }
    }
    
    @Override
	public String toString() {
		return "OrderDetail [orderDetailID=" + orderDetailID + ", order=" + order + ", product=" + product
				+ ", quantity=" + quantity + "]";
	}
}