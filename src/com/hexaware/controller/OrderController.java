package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.dao.OrderDao;
import com.hexaware.entity.Order;

public class OrderController implements OrderInterface {
	Scanner scan = new Scanner(System.in);
	OrderDao orderDao = new OrderDao();
	
	@Override
	public void calculateTotalAmount() {
		System.out.print("Enter Order ID ");
		int orderId = scan.nextInt();
		orderDao.calculateTotalAmount(orderId);
	}

	@Override
	public void getOrderDetails() {
		System.out.print("Enter Order ID ");
		int orderId = scan.nextInt();
		orderDao.showOrderDetails(orderId);
	}

	@Override
	public void updateOrderStatus() {
		Order order = new Order();
		
		System.out.print("Enter Order ID ");
		int orderId = scan.nextInt();
		order.setOrderID(orderId);
		
		System.out.print("Select Status: \n1. Processing \n2. Shipped \n3. Cancelled");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		if (choice == 1) order.setOrderStatus("PROCESSING");
		if (choice == 2) order.setOrderStatus("SHIPPED");
		if (choice == 3) order.setOrderStatus("CANCELLED");
		orderDao.updateOrderStatus(order);
	}

	@Override
	public void cancelOrder() {
		System.out.print("Enter Order ID ");
		int orderId = scan.nextInt();
		orderDao.cancelOrder(orderId);

	}


}
