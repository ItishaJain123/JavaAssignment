/**
 * The `DbConnection` class provides a utility for establishing a connection to the database
 * based on the information provided in the "db.properties" file.
 * 
 * Usage:
 * ```
 * // Example of getting a database connection
 * Connection connection = DbConnection.getDbConnection();
 * // Use the 'connection' object for database operations
 * // ...
 * // Close the connection when done to release resources
 * connection.close();
 * ```
 * 
 * Note: Ensure that the "db.properties" file is properly configured with the database connection details.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-01
 */

package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	static Connection connection;

	/**
	 * Retrieves a database connection based on the information provided in the
	 * "db.properties" file.
	 * 
	 * @return A Connection object representing the established database connection.
	 */
	public static Connection getDbConnection() {
		String fileName = "db.properties";
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(fileName);
			properties.load(fileInputStream);

			String url = properties.getProperty("db.url");
			String username = properties.getProperty("db.username");
			String password = properties.getProperty("db.password");

			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
