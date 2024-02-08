/**
 * The `ProductDao` class provides data access operations related to products
 * in the database. It includes methods for inserting a product, showing product details,
 * updating product information, checking product availability, and showing a list of products.
 * 
 * Usage:
 * ```
 * // Example of inserting a product
 * ProductDao productDao = new ProductDao();
 * Product newProduct = new Product(101, "New Product", "Description of the new product", 49.99);
 * productDao.insertProduct(newProduct);
 * 
 * // Example of showing product details
 * productDao.showProductDetails(101);
 * 
 * // Example of updating product information
 * Product productToUpdate = new Product(101, null, "Updated description", 59.99);
 * productDao.updateProduct(productToUpdate);
 * 
 * // Example of checking product availability
 * boolean isAvailable = productDao.isProductInStock(101);
 * System.out.println("Is product available: " + isAvailable);
 * 
 * // Example of showing a list of products
 * List<Product> productList = productDao.showProductList();
 * for (Product product : productList) {
 *     System.out.println(product);
 * }
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
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.Product;
import com.hexaware.util.DbConnection;
import com.hexaware.util.ResultFormatter;

public class ProductDao {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	/**
	 * Inserts a new product into the database.
	 * 
	 * @param product The product object to be inserted.
	 */
	public void insertProduct(Product product) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement(
					"INSERT INTO Products(ProductID, ProductName, Descriptions, Price) VALUES (?, ?, ?, ?)");

			preparedStatement.setInt(1, product.getProductID());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setDouble(4, product.getPrice());

			int totalRows = preparedStatement.executeUpdate();
			System.out.println(totalRows + " rows affected!");

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
	 * Shows the details of a specific product.
	 * 
	 * @param productID The ID of the product for which details are to be shown.
	 */
	public void showProductDetails(int productID) {
		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM Products WHERE ProductID = ?");
			preparedStatement.setInt(1, productID);
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
	 * Updates the information of a specific product.
	 * 
	 * @param product The product object containing updated information and product
	 *                ID.
	 */
	public void updateProduct(Product product) {
		try {
			connection = DbConnection.getDbConnection();
			// Initialize StringBuilder to dynamically build the update query
			StringBuilder updateQuery = new StringBuilder("UPDATE Products SET ");

			// Check each field and add it to the update query if it's not null
			if (product.getDescription() != null) {
				updateQuery.append("Descriptions = ?, ");
			}

			if (product.getPrice() != 0) {
				updateQuery.append("Price = ?, ");
			}

			// Remove the trailing comma and space from the query
			updateQuery.setLength(updateQuery.length() - 2);

			// Add the WHERE clause to identify the product to update
			updateQuery.append(" WHERE ProductID = ?");

			// Prepare the statement using the dynamically built query
			preparedStatement = connection.prepareStatement(updateQuery.toString());

			// Set parameters based on the provided values
			int parameterIndex = 1;
			if (product.getDescription() != null) {
				preparedStatement.setString(parameterIndex++, product.getDescription());
			}

			if (product.getPrice() != 0) {
				preparedStatement.setDouble(parameterIndex++, product.getPrice());
			}

			// Set the WHERE clause parameter
			preparedStatement.setInt(parameterIndex, product.getProductID());

			int totalRows = preparedStatement.executeUpdate();
			System.out.println(totalRows + " rows affected!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close resources in the finally block
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Checks whether a specific product is in stock or not.
	 * 
	 * @param productID The ID of the product to check for availability.
	 * @return True if the product is in stock, false otherwise.
	 */
	public boolean isProductInStock(int productID) {
		int quantityInStock = 0;

		try {
			connection = DbConnection.getDbConnection();
			preparedStatement = connection.prepareStatement(
					"SELECT inventory.quantityInStock FROM Products join inventory on Products.ProductID = inventory.ProductID WHERE Products.ProductID = ?");
			preparedStatement.setInt(1, productID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				quantityInStock = resultSet.getInt(1);
			}
//			ResultFormatter.printRows(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return quantityInStock > 0;
	}

	/**
	 * Shows a list of all products in the database.
	 * 
	 * @return List of products in the database.
	 */
	public List<Product> showProductList() {
		List<Product> productList = new ArrayList<Product>();
		try {
			connection = DbConnection.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from Products");
			ResultFormatter.printRows(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productList;
	}
}
