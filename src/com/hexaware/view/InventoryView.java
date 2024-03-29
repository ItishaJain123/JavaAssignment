/**
 * The `InventoryView` class provides a text-based menu interface for 
 * inventory-related operations.
 * Users can view product details in the inventory, check product quantity in stock, add 
 * and remove product quantities,
 * update stock quantities, check product availability, view total inventory value, 
 * view a list of low stock and out-of-stock products,
 * and view a list of all products.
 * 
 * Usage:
 * ```
 * // Create an instance of InventoryView
 * InventoryView inventoryView = new InventoryView();
 * 
 * // Display the menu to the user
 * inventoryView.displayMenu();
 * ```
 * 
 * Note: Ensure that appropriate controller methods are 
 * implemented and handle user input gracefully.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-01
 */

package com.hexaware.view;

import java.util.Scanner;

import com.hexaware.controller.InventoryController;
import com.hexaware.controller.InventoryInterface;

public class InventoryView {
	InventoryInterface inventory = new InventoryController();
	Scanner scan = new Scanner(System.in);

	/**
	 * Displays the main menu for inventory-related operations and processes user
	 * input.
	 */
	public void displayMenu() {
		
		String input = null;
		
		do {
		    System.out.println("Enter your choice");
		    System.out.println("1. View Product in inventory");
		    System.out.println("2. View Product Quantity in Stock");
		    System.out.println("3. Add Quantity of Product");
		    System.out.println("4. Remove Quantity of Product");
		    System.out.println("5. Update Quantity");
		    System.out.println("6. Check Product Availability");
		    System.out.println("7. View Total Inventory Value");
		    System.out.println("8. View List Low Stock Products");
		    System.out.println("9. View Out of Stock Products");
		    System.out.println("10. View List of All Products");


		    int choice = scan.nextInt();
		    
		    switch (choice) {
		        case 1: {
		            inventory.getProduct();
		            break;
		        }
		        case 2:{
		        	inventory.getStockQuantity();
		        	break;
		        }
		        case 3:{
		        	inventory.addToInventory();
		        	break;
		        }
		        case 4:{
		        	inventory.removeFromInventory();
		        	break;
		        }
		        case 5:{
		        	inventory.updateStockQuantity();
		        	break;
		        }
		        case 6:{
		        	inventory.isProductAvailable();
		        	break;
		        }
		        case 7:{
		        	inventory.getInventoryValue();
		        	break;
		        }
		        case 8:{
		        	inventory.listLowStockProducts();
		        	break;
		        }
		        case 9:{
		        	inventory.listOutOfStockProducts();
		        	break;
		        }
		        case 10:{
		        	inventory.listAllProducts();
		        	break;
		        }
		        default: {
		            System.out.println("Choose a proper choice");
		            break;
		        }
		    }
		    
		    System.out.println("Do you want to continue? Y | y");
		    input = scan.next();

		} while (input.equals("Y") || input.equals("y"));
	}
}