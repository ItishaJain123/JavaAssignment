package com.hexaware.exceptions;

/**
 * Custom exception class for handling insufficient stock-related issues. This
 * exception is thrown when stock is not available for a particular operation.
 */
public class InsufficientStockException extends Exception {

	/**
	 * Default constructor for the InsufficientStockException class. It prints a
	 * message to the console when the exception is instantiated.
	 */
	public InsufficientStockException() {
		System.out.println("Stock not available");
	}

	/**
	 * Overrides the toString method to provide a custom error message.
	 *
	 * @return A string representation of the exception, indicating "Stock not
	 *         available".
	 */
	@Override
	public String toString() {
		return "Stock not available";
	}
}
