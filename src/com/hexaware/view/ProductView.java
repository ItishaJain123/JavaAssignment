/**
 * The `ProductView` class provides a menu-driven program for managing products.
 * Users can interact with product-related functionalities, such as adding products,
 * viewing product details, updating product information, checking product availability,
 * and viewing the list of all products.
 * The class uses the `ProductController` to handle the business logic related to products.
 * 
 * Usage:
 * ```
 * // Create an instance of ProductView and run the displayMenu method to start the product management system.
 * ProductView productView = new ProductView();
 * productView.displayMenu();
 * ```
 * 
 * Note: Ensure that the referenced controller (`ProductController`) is implemented and handles user input gracefully.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-01
 */

package com.hexaware.view;

import java.util.Scanner;

import com.hexaware.controller.ProductController;
import com.hexaware.controller.ProductInterface;

public class ProductView {
	Scanner scan = new Scanner(System.in);
	ProductInterface product = new ProductController();
	
	/**
	 * Displays the menu for managing products and handles user interactions. The
	 * user can choose options such as adding products, viewing product details,
	 * updating product information, checking product availability, and viewing the
	 * list of all products.
	 */
	public void displayMenu() {
		String ch = null;
		
		do {
		    System.out.println("Enter your choice");
		    System.out.println("1. Add Product");
		    System.out.println("2. View Product Details");
		    System.out.println("3. Update Product");
		    System.out.println("4. Is Product in Stock");
			System.out.println("5. View All Products");
		    int choice = scan.nextInt();
		    
		    switch (choice) {
			case 1:
		            product.addProduct(); 
		            break;
				case 2:
		            product.getProductDetails();
		            break;
				case 3:
		            product.updateProductInfo();
		            break;
				case 4:
		            product.isProductInStock();
		            break;
				case 5:
					product.getProductList();
					break;
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
