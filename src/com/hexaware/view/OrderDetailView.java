/**
 * The `OrderDetailView` class provides a menu-driven program for managing order details.
 * Users can interact with order details, view information, calculate subtotals, update quantities,
 * and apply discounts. The class uses the `OrderDetailsController` to handle the business logic
 * related to order details.
 * 
 * Usage:
 * ```
 * // Create an instance of OrderDetailView and run the displayMenu method to start the order details management system.
 * OrderDetailView orderDetailView = new OrderDetailView();
 * orderDetailView.displayMenu();
 * ```
 * 
 * Note: Ensure that the referenced controller (`OrderDetailsController`) is implemented and handles user input gracefully.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-01
 */

package com.hexaware.view;

import java.util.Scanner;

import com.hexaware.controller.OrderDetailsController;
import com.hexaware.controller.OrderDetailsInterface;

public class OrderDetailView {
	Scanner scan = new Scanner(System.in);
	OrderDetailsInterface orderDetails = new OrderDetailsController();

	/**
	 * Displays the menu for managing order details and handles user interactions.
	 * The user can choose options such as viewing order detail information,
	 * calculating subtotals, updating product quantities, and adding discounts.
	 */
	public void displayMenu() {
		String ch = null;
		
		do {
		    System.out.println("Enter your choice");
		    System.out.println("1. View Order Detail Info");
		    System.out.println("2. Calculate Order Detail Subtotal");
		    System.out.println("3. Update product quantity");
		    System.out.println("4. Add Discount");
		    
		    int choice = scan.nextInt();
		    
		    switch (choice) {
		        case 1: {
		            orderDetails.getOrderDetailInfo();
		            break;
		        }
		        case 2: {
		            orderDetails.calculateSubTotal();
		            break;
		        }
		        case 3: {
		            orderDetails.updateQuantity();
		            break;
		        }
		        case 4: {
		            orderDetails.addDiscount();
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