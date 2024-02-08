/**
 * The `CustomerView` class provides a text-based menu interface for customer-related operations.
 * Users can register a new customer, view customer details, update customer information, and view a list of all customers.
 * 
 * Usage:
 * ```
 * // Create an instance of CustomerView
 * CustomerView customerView = new CustomerView();
 * 
 * // Display the menu to the user
 * customerView.displayMenu();
 * ```
 * 
 * Note: Ensure that appropriate controller methods are implemented and 
 * handle user input gracefully.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-01
 */

package com.hexaware.view;

import java.util.Scanner;

import com.hexaware.controller.CustomerController;
import com.hexaware.controller.CustomerInterface;

public class CustomerView {
	Scanner scan = new Scanner(System.in);
	CustomerInterface customerController = new CustomerController();

	/**
	 * Displays the main menu for customer-related operations and processes user
	 * input.
	 */
	public void displayMenu() {
		String ch = null;
		
		do {
			System.out.println("Enter your choice");
			System.out.println("1. Register");
			System.out.println("2. View Customer Details");
			System.out.println("3. Update Customer");
			System.out.println("4. View All Customers");

			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				customerController.addCustomer();
				break;
			case 2:
				customerController.getCustomerDetails();
				break;
			case 3:
				customerController.updateCustomerInfo();
				break;
			case 4:
				customerController.getCustomerList();
				break;
			default:
				System.out.println("Choose a proper choice");
				break;
			}
			System.out.println("Do you want to continue? Y | y");
			ch = scan.next();

		} while (ch.equals("Y") || ch.equals("y"));
	}
}
