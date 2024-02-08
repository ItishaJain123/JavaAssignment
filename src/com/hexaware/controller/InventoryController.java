package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.dao.InventoryDao;

public class InventoryController implements InventoryInterface {
	Scanner scan = new Scanner(System.in);
	InventoryDao inventoryDao = new InventoryDao();
	
	@Override
	public void getProduct() {
		System.out.println("Enter Inventory ID ");
		int inventoryId = scan.nextInt();
		
		inventoryDao.showProduct(inventoryId);

	}
	
	@Override
	public void getStockQuantity() {
		System.out.println("Enter Product ID ");
		int productId = scan.nextInt();
		
		inventoryDao.showStockQuantity(productId);

	}

	@Override
	public void addToInventory() {
		System.out.println("Enter Product ID ");
		int productId = scan.nextInt();
		
		System.out.println("Enter quantity ");
		int quantity = scan.nextInt();
				
		inventoryDao.updateAddQuantity(productId, quantity);
	}

	@Override
	public void removeFromInventory() {
		System.out.println("Enter Product ID ");
		int productId = scan.nextInt();
		
		
		System.out.println("Enter quantity ");
		int quantity = scan.nextInt();		
		
		inventoryDao.updateRemoveQuantity(productId, quantity);
	}

	@Override
	public void updateStockQuantity() {
		System.out.println("Enter Inventory ID ");
		int inventoryId = scan.nextInt();
		
		System.out.println("Enter quantity ");
		int quantity = scan.nextInt();
		
		inventoryDao.updateStockQuantity(inventoryId, quantity);
	}

	@Override
	public void isProductAvailable() {
		System.out.println("Enter Product ID ");
		int productId = scan.nextInt();
		
		System.out.println("Enter quantity to check ");
		int quantity = scan.nextInt();	
		
		int availableQuantity = inventoryDao.showAvailableQuantity(productId);
		
		if( availableQuantity >= quantity) {
			System.out.println("Product is available!");
		}else {
			System.out.println("Selected quantity is not available!");
		}
		
	}

	@Override
	public void getInventoryValue() {
		int totalValue = inventoryDao.showInventoryValue();
		System.out.println("Total Inventory Value: Rs. "+totalValue);
	}

	@Override
	public void listLowStockProducts() {
		System.out.println("Enter low quantity threshold ");
		int threshold = scan.nextInt();
		inventoryDao.showLowStockProducts(threshold);

	}

	@Override
	public void listOutOfStockProducts() {
		inventoryDao.showOutOfStockProdcuts();

	}

	@Override
	public void listAllProducts() {
		inventoryDao.showAllProducts();
	}
}