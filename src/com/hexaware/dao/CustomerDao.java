/**
 * The `CustomerDao` class provides data access operations related to customers
 * in the database. It includes methods for inserting a new customer, calculating
 * the total number of orders for a customer, showing details of a specific customer,
 * updating customer information, and showing details of all customers.
 * 
 * Usage:
 * ```
 * // Example of inserting a new customer
 * CustomerDao customerDao = new CustomerDao();
 * Customer newCustomer = new Customer(101, "John", "Doe", "john.doe@example.com", "1234567890", "123 Main St");
 * customerDao.insertCustomer(newCustomer);
 * 
 * // Example of calculating total orders for a customer
 * customerDao.calculateTotalOrders(101);
 * 
 * // Example of showing details of a specific customer
 * customerDao.showCustomerDetails(101);
 * 
 * // Example of updating customer information
 * Customer updatedCustomer = new Customer(101, null, null, "new.email@example.com", "new.phone.number", "new.address");
 * customerDao.updateCustomer(updatedCustomer);
 * 
 * // Example of showing details of all customers
 * customerDao.showCustomer();
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

import com.hexaware.entity.Customer;
import com.hexaware.util.DbConnection;
import com.hexaware.util.ResultFormatter;

public class CustomerDao {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	/**
	 * Inserts a new customer into the database.
	 * 
	 * @param customer The customer object to be inserted.
	 */
	public void insertCustomer(Customer customer) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement(
					"insert into Customers(customerID, firstname, lastname, email, phone, address) values(?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, customer.getCustomerID());
			preparedStatement.setString(2, customer.getFirstName());
			preparedStatement.setString(3, customer.getLastName());
			preparedStatement.setString(4, customer.getEmail());
			preparedStatement.setString(5, customer.getPhone());
			preparedStatement.setString(6, customer.getAddress());
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
	 * Calculates the total number of orders for a specific customer.
	 * 
	 * @param customerId The ID of the customer for whom total orders are to be
	 *                   calculated.
	 */
	public void calculateTotalOrders(int customerId) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement(
					"SELECT count(*) as Total_Orders FROM orders joins Customers on orders.customerID = Customers.customerID WHERE Customers.customerID = ?");
			System.out.println(customerId);
			preparedStatement.setInt(1, customerId);
			resultSet = preparedStatement.executeQuery();
			ResultFormatter.printRows(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Shows the details of a specific customer.
	 * 
	 * @param customerID The ID of the customer whose details are to be shown.
	 */
	public void showCustomerDetails(int customerID) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM Customers WHERE customerID = ?");
			System.out.println(customerID);
			preparedStatement.setInt(1, customerID);
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
	 * Updates the information of an existing customer in the database.
	 * 
	 * @param customer The customer object with updated information.
	 */
	public void updateCustomer(Customer customer) {
		try {
			connection = DbConnection.getDbConnection();
			// Initialize StringBuilder to dynamically build the update query
			StringBuilder updateQuery = new StringBuilder("UPDATE Customers SET ");
	        
	        // Check each field and add it to the update query if it's not null
	        if (customer.getEmail() != null) {
	            updateQuery.append("email = ?, ");
	        }
	        if (customer.getPhone() != null) {
	            updateQuery.append("phone = ?, ");
	        }
	        if (customer.getAddress() != null) {
	            updateQuery.append("address = ?, ");
	        }
	        
	        // Remove the trailing comma and space from the query
	        updateQuery.setLength(updateQuery.length() - 2);
	        
	        // Add the WHERE clause to identify the customer to update
	        updateQuery.append(" WHERE customerID = ?");
	        
	        // Prepare the statement using the dynamically built query
	        preparedStatement = connection.prepareStatement(updateQuery.toString());
	        
	        // Set parameters based on the provided values
	        int parameterIndex = 1;
	        if (customer.getEmail() != null) {
	            preparedStatement.setString(parameterIndex++, customer.getEmail());
	        }
	        if (customer.getPhone() != null) {
	            preparedStatement.setString(parameterIndex++, customer.getPhone());
	        }
	        if (customer.getAddress() != null) {
	            preparedStatement.setString(parameterIndex++, customer.getAddress());
	        }
	        
	        // Set the WHERE clause parameter
	        preparedStatement.setInt(parameterIndex, customer.getCustomerID());

			
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
	 * Shows the details of all customers in the database.
	 */
	public void showCustomer() {
		try {
			connection = DbConnection.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from Customers");
//			while(resultSet.next()) {
//				System.out.println("Customer ID : "+ resultSet.getInt(1));
//				System.out.println("First Name : "+ resultSet.getString(2));
//				System.out.println("Last Name : "+ resultSet.getString(3));
//				System.out.println("Email: "+resultSet.getString(4));
//				System.out.println("Phone: "+resultSet.getString(5));
//				System.out.println("Address: "+resultSet.getString(6));
//			}
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

