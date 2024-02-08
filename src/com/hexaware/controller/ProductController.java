package com.hexaware.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.ProductDao;
import com.hexaware.entity.Product;

public class ProductController implements ProductInterface {
	Scanner scan = new Scanner(System.in);
	ProductDao productDao = new ProductDao();
	List<Product> productList = new ArrayList<Product>();
	
	@Override
	public void addProduct() {
		System.out.print("Enter Product ID: ");
		int productId = scan.nextInt();

		System.out.print("Enter Product Name: ");
		String productName = scan.next();

		scan.nextLine(); // To avoid breaking input due to /n character

		System.out.print("Enter Description: ");
		String description = scan.nextLine();

		System.out.print("Enter Price: ");
		double price = scan.nextDouble();

		Product product = new Product(productId, productName, description, price);
		productDao.insertProduct(product);

	}
	
	@Override
	public void getProductDetails() {
		System.out.print("Enter Product ID ");
		int productID = scan.nextInt();
		productDao.showProductDetails(productID);
	
	}

	@Override
	public void updateProductInfo() {
		Product product = new Product();
		
		System.out.print("Enter Product ID ");
		int productId = scan.nextInt();
		product.setProductID(productId);
		
		scan.nextLine();
		
		System.out.print("Enter Description ");
		String description = scan.nextLine().trim();
		if (!description.isEmpty()) {
			product.setDescription(description);
		}
		
		System.out.print("Enter Price ");
		Double price = scan.nextDouble();
		if (!price.equals(0.0)) {
			product.setPrice(price);
		}
		productDao.updateProduct(product);
	}
	
	@Override
	public void isProductInStock() {
		System.out.print("Enter Product ID ");
		int productID = scan.nextInt();

		boolean stockCheck = productDao.isProductInStock(productID);

		if (stockCheck) {
			System.out.println("The Product " + productID + " is available in Stock!");
		} else {
			System.out.println("The Product " + productID + " is not available in Stock!");
		}

	}

	@Override
	public void getProductList() {
		productDao.showProductList();
	}

}
