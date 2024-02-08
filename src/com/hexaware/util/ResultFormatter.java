/**
 * The `ResultFormatter` class provides a utility method for printing the rows of a ResultSet
 * in a formatted manner.
 * 
 * Usage:
 * ```
 * // Example of printing rows from a ResultSet
 * ResultSet resultSet = //... obtain ResultSet from database query
 * ResultFormatter.printRows(resultSet);
 * ```
 * 
 * Note: Ensure that the ResultSet is properly obtained from a database query.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-01
 */

package com.hexaware.util;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultFormatter {

	/**
	 * Prints the rows of a ResultSet in a formatted manner.
	 * 
	 * @param resultSet The ResultSet containing the rows to be printed.
	 */
	public static void printRows(ResultSet resultSet) {
		try {
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			if(resultSet.next()) {
				do {
					for (int i = 1; i <= columnCount; i++) {
				        String columnName = metaData.getColumnName(i);
				        Object value = resultSet.getObject(i);
				        System.out.println(columnName + ": " + value);
				    }
				    System.out.println();  // Add a newline between rows for better readability
				} while(resultSet.next());
			}
			else {
				System.out.println("No Data Returned");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}