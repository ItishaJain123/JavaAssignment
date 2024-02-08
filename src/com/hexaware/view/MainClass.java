/**
 * The `MainClass` serves as the main entry point for the TechShop management system.
 * It presents a menu-driven program allowing users to navigate through different modules,
 * including Customer Management, Product Management, Order Management, Order Details, and Inventory.
 * Users can select a module by entering the corresponding number and interact with the system's functionalities.
 * The program runs in a loop, allowing users to continue using the system until they choose to exit.
 * 
 * Usage:
 * ```
 * // Run the main method to start the TechShop management system
 * public static void main(String[] args) {
 *     MainClass mainClass = new MainClass();
 *     mainClass.startTechShop();
 * }
 * ```
 * 
 * Note: Ensure that the referenced views and controllers are implemented and handle user input gracefully.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-01
 */

package com.hexaware.view;

import java.util.Scanner;

public class MainClass {
	static Scanner scan = new Scanner(System.in);
	
	/**
	 * The main method serves as the entry point for the TechShop management system.
	 * It initializes the system and provides a menu-driven program to interact with
	 * different modules.
	 *
	 * @param args The command-line arguments (not used in this application).
	 */
	public static void main(String[] args) {
		System.out.println("===============================================================");
		System.out.println("===============================================================");
		System.out.println("==================== WELCOME TO MY TECHSHOP ===================");
		System.out.println("===============================================================");
		System.out.println("===============================================================");
		
//		HERE I'M CREATING MENU DRIVERN PROGRAM USING DO-WHILE LOOP
		String input = null;
		do {
			System.out.println("Select a Module ");
			System.out.println("1. Customer Management");
			System.out.println("2. Product Management");
			System.out.println("3. Order Management");
			System.out.println("4. Order Details");
			System.out.println("5. Inventory");
			
			int choice = scan.nextInt();
			switch (choice) {
			case 1: {
				CustomerView customerView = new CustomerView();
				customerView.displayMenu();
				break;
			}
			case 2: {
				ProductView productView = new ProductView();
				productView.displayMenu();
				break;
			}
			case 3: {
				OrderView orderView = new OrderView();
				orderView.displayMenu();
				break;
			}
			case 4: {
				OrderDetailView orderDetailView = new OrderDetailView();
				orderDetailView.displayMenu();
				break;
			}
			case 5: {
				InventoryView inventoryView = new InventoryView();
				inventoryView.displayMenu();
				break;
			}
			default: {
				System.out.println("Choose a proper choice");
				break;
			}
			}
			System.out.println("To Continue - Press 'C' | 'c'");
			input = scan.next();
			
		} while (input.equals("c") || input.equals("C"));
		
		System.out.println("===============================================================");
		System.out.println("===============================================================");
		System.out.println("================== THANKS FOR USING OUR SYSTEM=================");
		System.out.println("===============================================================");
		System.out.println("===============================================================");
	}
	
}
