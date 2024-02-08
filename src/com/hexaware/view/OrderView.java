/**
 * The `OrderView` class provides a menu-driven program for managing orders.
 * Users can interact with order-related functionalities, such as calculating total amounts,
 * viewing order details, updating order status, and canceling orders.
 * The class uses the `OrderController` to handle the business logic related to orders.
 * 
 * Usage:
 * ```
 * // Create an instance of OrderView and run the displayMenu method to start the order management system.
 * OrderView orderView = new OrderView();
 * orderView.displayMenu();
 * ```
 * 
 * Note: Ensure that the referenced controller (`OrderController`) is implemented and handles user input gracefully.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-01
 */

package com.hexaware.view;

import java.util.Scanner;

import com.hexaware.controller.OrderController;
import com.hexaware.controller.OrderInterface;

public class OrderView {
	Scanner scan = new Scanner(System.in);
	OrderInterface order = new OrderController();
	
	/**
	 * Displays the menu for managing orders and handles user interactions. The user
	 * can choose options such as calculating total amounts, viewing order details,
	 * updating order status, and canceling orders.
	 */
	public void displayMenu() {
		String ch = null;
		
		do {
		    System.out.println("Enter your choice");
			System.out.println("1. Calculate Total Amount For an Order");
			System.out.println("2. View Order Details");
			System.out.println("3. Update Order Status");
			System.out.println("4. Cancel an Order");
		    
		    int choice = scan.nextInt();
		    
		    switch (choice) {
		        case 1: {
					order.calculateTotalAmount();
		            break;
		        }
		        case 2: {
					order.getOrderDetails();
		            break;
		        }
		        case 3: {
					order.updateOrderStatus();
		        	break;
		        }
				case 4: {
					order.cancelOrder();
					break;
				}
		        default: {
		            System.out.println("Choose a proper choice");
		            break;
		        }
		    }
		    
		    System.out.println("Do you want to continue? Y | y");
		    ch = scan.next();

		} while (ch.equals("Y") || ch.equals("y"));
	}
}