package com.hexaware.exceptions;

/**
 * Custom exception class for handling SQL-related issues. This exception is
 * thrown when executing a SQL query and the database is offline.
 */
public class SqlException extends Exception {

	/**
	 * Default constructor for the SqlException class. It prints a message to the
	 * console when the exception is instantiated.
	 */
	public SqlException() {
		System.out.println("When executing a SQL query and the database is offline.");
	}

	/**
	 * Overrides the toString method to provide a custom error message.
	 *
	 * @return A string representation of the exception, indicating "When executing
	 *         a SQL query and the database is offline".
	 */
	@Override
	public String toString() {
		return "When executing a SQL query and the database is offline";
	}
}
