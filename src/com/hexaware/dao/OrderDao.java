/**
 * The `OrderDao` class provides data access operations related to orders
 * in the database. It includes methods for showing order details, updating
 * order status, calculating total order amount, and canceling an order.
 * 
 * Usage:
 * ```
 * // Example of showing order details
 * OrderDao orderDao = new OrderDao();
 * orderDao.showOrderDetails(101);
 * 
 * // Example of updating order status
 * Order order = new Order();
 * order.setOrderID(101);
 * order.setOrderStatus("SHIPPED");
 * orderDao.updateOrderStatus(order);
 * 
 * // Example of calculating total order amount
 * orderDao.calculateTotalAmount(101);
 * 
 * // Example of canceling an order
 * orderDao.cancelOrder(101);
 * ```
 * 
 * Note: Ensure to close the connection after using the methods to release resources.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-01
 */

package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.Order;
import com.hexaware.util.DbConnection;
import com.hexaware.util.ResultFormatter;

public class OrderDao {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	/**
	 * Shows the details of a specific order.
	 * 
	 * @param orderId The ID of the order for which details are to be shown.
	 */
	public void showOrderDetails(int orderId) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT Orders.*, firstname, lastname, email FROM Orders JOIN Customers ON Customers.customerID = Orders.customerID WHERE orderID = ?");
			preparedStatement.setInt(1, orderId);
			resultSet = preparedStatement.executeQuery();
			ResultFormatter.printRows(resultSet);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
		        if (connection != null) connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	}
	
	/**
	 * Updates the status of a specific order.
	 * 
	 * @param order The order object containing updated status and order ID.
	 */
	public void updateOrderStatus(Order order) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("UPDATE Orders SET orderStatus = ? WHERE orderID = ?");
			preparedStatement.setString(1, order.getOrderStatus());
			preparedStatement.setInt(2, order.getOrderID());
			int totalRows = preparedStatement.executeUpdate();
			System.out.println(totalRows+" rows affected!");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
		        if (connection != null) connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	}
	
	/**
	 * Calculates the total amount of a specific order.
	 * 
	 * @param orderId The ID of the order for which the total amount is to be
	 *                calculated.
	 */
	public void calculateTotalAmount(int orderId) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT SUM(Price * Quantity) AS TotalAmount FROM OrderDetails D JOIN Products P ON D.productID = P.productID WHERE D.orderID = ?");
			preparedStatement.setInt(1, orderId);
			resultSet = preparedStatement.executeQuery();
			ResultFormatter.printRows(resultSet);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
		        if (connection != null) connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	}	

	/**
	 * Cancels a specific order by updating its status to "CANCELLED".
	 * 
	 * @param orderId The ID of the order to be canceled.
	 */
	public void cancelOrder(int orderId) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("UPDATE Orders SET orderStatus = ? WHERE orderID = ?");
			preparedStatement.setString(1, "CANCELLED");
			preparedStatement.setInt(2, orderId);
			int totalRows = preparedStatement.executeUpdate();
			System.out.println(totalRows + " rows affected!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
