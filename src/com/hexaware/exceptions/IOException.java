package com.hexaware.exceptions;

/**
 * Custom exception class for handling data persistence-related issues. This
 * exception is thrown when an error occurs during data persistence.
 */
public class DataPersistenceException extends Exception {

	/**
	 * Default constructor for the DataPersistenceException class. It prints a
	 * message to the console when the exception is instantiated.
	 */
	public DataPersistenceException() {
		System.out.println("An error occurs during data persistence");
	}

	/**
	 * Overrides the toString method to provide a custom error message.
	 *
	 * @return A string representation of the exception, indicating "An error occurs
	 *         during data persistence".
	 */
	@Override
	public String toString() {
		return "An error occurs during data persistence";
	}
}
