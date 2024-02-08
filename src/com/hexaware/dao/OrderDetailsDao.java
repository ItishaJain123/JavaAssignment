/**
 * The `OrderDetailsDao` class provides data access operations related to order details
 * in the database. It includes methods for showing order details, calculating sub-total,
 * updating quantity, and adding a discount to order details.
 * 
 * Usage:
 * ```
 * // Example of showing order details
 * OrderDetailsDao orderDetailsDao = new OrderDetailsDao();
 * orderDetailsDao.showOrderDetails(501);
 * 
 * // Example of calculating sub-total
 * orderDetailsDao.calculateSubTotal(501);
 * 
 * // Example of updating quantity
 * OrderDetail orderDetail = new OrderDetail();
 * orderDetail.setOrderDetailID(501);
 * orderDetail.setQuantity(5);
 * orderDetailsDao.updateQuantity(orderDetail);
 * 
 * // Example of adding discount
 * orderDetailsDao.addDiscount(501, 10);
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

import com.hexaware.entity.OrderDetail;
import com.hexaware.util.DbConnection;
import com.hexaware.util.ResultFormatter;

public class OrderDetailsDao {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	/**
	 * Shows the details of a specific order detail.
	 * 
	 * @param orderDetailId The ID of the order detail for which details are to be
	 *                      shown.
	 */
	public void showOrderDetails(int orderDetailId) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT OrderDetails.*, productname FROM OrderDetails JOIN Products ON OrderDetails.productID = Products.productID WHERE orderDetailId = ?");
			preparedStatement.setInt(1, orderDetailId);
			resultSet = preparedStatement.executeQuery();
			ResultFormatter.printRows(resultSet);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Calculates the sub-total of a specific order detail.
	 * 
	 * @param orderDetailId The ID of the order detail for which the sub-total is to
	 *                      be calculated.
	 */
	public void calculateSubTotal(int orderDetailId) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT (price*quantity) AS SubTotal FROM OrderDetails JOIN Products ON OrderDetails.productID = Products.productID WHERE orderDetailId = ?");
			preparedStatement.setInt(1, orderDetailId);
			resultSet = preparedStatement.executeQuery();
			ResultFormatter.printRows(resultSet);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Updates the quantity of a specific order detail.
	 * 
	 * @param orderDetail The order detail object containing updated quantity and
	 *                    order detail ID.
	 */
	public void updateQuantity(OrderDetail orderDetail) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("UPDATE OrderDetails SET quantity = ? WHERE orderDetailId = ?");
			preparedStatement.setInt(1, orderDetail.getQuantity());
			preparedStatement.setInt(2, orderDetail.getOrderDetailID());
			int totalRows = preparedStatement.executeUpdate();
			System.out.println(totalRows+" rows affected!");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Adds a discount to the sub-total of a specific order detail.
	 * 
	 * @param orderDetailId   The ID of the order detail to which the discount is to
	 *                        be added.
	 * @param discountPercent The percentage of discount to be applied.
	 */
	public void addDiscount(int orderDetailId, int discountPercent) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT (price*quantity)* ? AS DiscountedSubTotal FROM OrderDetails JOIN Products ON OrderDetails.productID = Products.productID WHERE orderDetailId = ?");
			
			double discount = discountPercent/100.00;
			System.out.println(discount);
			preparedStatement.setDouble(1, 1-discount);
			preparedStatement.setInt(2, orderDetailId);
			resultSet = preparedStatement.executeQuery();
			ResultFormatter.printRows(resultSet);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
