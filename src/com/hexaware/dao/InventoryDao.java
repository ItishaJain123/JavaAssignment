/**
 * The `InventoryDao` class provides data access operations related to inventory
 * in the database. It includes methods for showing product details, stock quantity,
 * updating quantity (adding, removing, setting), showing available quantity,
 * calculating inventory value, showing low stock products, showing out-of-stock products,
 * and showing all products.
 * 
 * Usage:
 * ```
 * // Example of showing product details
 * InventoryDao inventoryDao = new InventoryDao();
 * inventoryDao.showProduct(101);
 * 
 * // Example of showing stock quantity
 * inventoryDao.showStockQuantity(101);
 * 
 * // Example of updating quantity by adding
 * inventoryDao.updateAddQuantity(101, 10);
 * 
 * // Example of updating quantity by removing
 * inventoryDao.updateRemoveQuantity(101, 5);
 * 
 * // Example of updating quantity by setting a specific value
 * inventoryDao.updateStockQuantity(101, 20);
 * 
 * // Example of showing available quantity
 * int availableQuantity = inventoryDao.showAvailableQuantity(101);
 * System.out.println("Available Quantity: " + availableQuantity);
 * 
 * // Example of calculating inventory value
 * int totalInventoryValue = inventoryDao.showInventoryValue();
 * System.out.println("Total Inventory Value: $" + totalInventoryValue);
 * 
 * // Example of showing low stock products
 * inventoryDao.showLowStockProducts(10);
 * 
 * // Example of showing out-of-stock products
 * inventoryDao.showOutOfStockProdcuts();
 * 
 * // Example of showing all products
 * inventoryDao.showAllProducts();
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

import com.hexaware.entity.Inventory;
import com.hexaware.util.DbConnection;
import com.hexaware.util.ResultFormatter;

public class InventoryDao {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	Inventory Inventory = new Inventory();

	/**
	 * Shows the details of a specific product in the inventory.
	 * 
	 * @param inventoryId The ID of the inventory for which details are to be shown.
	 */
	public void showProduct(int InventoryId) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement(
					"SELECT Inventory.productId, Products.productname FROM Inventory JOIN Products ON Products.productId = Inventory.productId WHERE Inventory.InventoryId = ?");
			preparedStatement.setInt(1, InventoryId);
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
	 * Shows the stock quantity of a specific product in the inventory.
	 * 
	 * @param productId The ID of the product for which stock quantity is to be
	 *                  shown.
	 */
	public void showStockQuantity(int productId) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT SUM(quantityinstock) AS ProductStock FROM Inventory WHERE productId = ?");
			preparedStatement.setInt(1, productId);
			resultSet = preparedStatement.executeQuery();
			ResultFormatter.printRows(resultSet);
		}catch(SQLException e) {
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
	 * Updates the quantity of a specific product in the inventory by adding.
	 * 
	 * @param productId The ID of the product for which quantity is to be updated.
	 * @param quantity  The quantity to be added.
	 */
	public void updateAddQuantity(int productId, int quantity) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("UPDATE Inventory SET quantityinstock = quantityinstock+? WHERE productId = ?");
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, productId);
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
	 * Updates the quantity of a specific product in the inventory by removing.
	 * 
	 * @param productId The ID of the product for which quantity is to be updated.
	 * @param quantity  The quantity to be removed.
	 */
	public void updateRemoveQuantity(int productId, int quantity) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("UPDATE Inventory SET quantityinstock = quantityinstock-? WHERE productId = ?");
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, productId);
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
	 * Updates the quantity of a specific product in the inventory by setting a
	 * specific value.
	 * 
	 * @param inventoryId The ID of the inventory for which quantity is to be
	 *                    updated.
	 * @param quantity    The quantity to be set.
	 */
	public void updateStockQuantity(int InventoryId, int quantity) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("UPDATE Inventory SET quantityinstock = ? WHERE productId = ?");
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, InventoryId);
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
	 * Shows the available quantity of a specific product in the inventory.
	 * 
	 * @param productId The ID of the product for which available quantity is to be
	 *                  shown.
	 * @return The available quantity of the product.
	 */
	public int showAvailableQuantity(int productId) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT SUM(quantityinstock) FROM Inventory WHERE productId = ?");
			preparedStatement.setInt(1, productId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	/**
	 * Calculates the total value of the entire inventory.
	 * 
	 * @return The total value of the inventory.
	 */
	public int showInventoryValue() {
		int totalInventoryValue = 0;
		try {
			connection = DbConnection.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT SUM(quantityinstock*price) FROM Inventory JOIN Products ON Inventory.productId = Products.productId");
			if(resultSet.next()) {
				totalInventoryValue = resultSet.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalInventoryValue;
	}
	
	/**
	 * Shows products in the inventory that have stock below a specified threshold.
	 * 
	 * @param threshold The threshold value for low stock.
	 */
	public void showLowStockProducts(int threshold) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement(
					"SELECT InventoryId, Inventory.productId, productname FROM Inventory JOIN Products ON Products.productId = Inventory.InventoryId WHERE quantityInStock <= ?");
			preparedStatement.setInt(1, threshold);
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
	 * Shows products in the inventory that are out of stock.
	 */
	public void showOutOfStockProdcuts() {
		try {
			connection = DbConnection.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT DISTINCT(Inventory.productId), productname FROM Inventory JOIN Products ON Products.productId = Inventory.InventoryId WHERE quantityInStock = 0");
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
	 * Shows details of all products in the inventory.
	 */
	public void showAllProducts() {
		try {
			connection = DbConnection.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT DISTINCT(Inventory.productId), productname FROM Inventory JOIN Products ON Products.productId = Inventory.InventoryId");
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
