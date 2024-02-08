package com.hexaware.exceptions;

/**
 * Custom exception class for handling authorization-related issues. This
 * exception is thrown when authorization fails due to incorrect credentials.
 */
public class AuthorizationException extends Exception {

	/**
	 * Constructor for the AuthorizationException class. It prints a message to the
	 * console when the exception is instantiated.
	 */
	public AuthorizationException() {
		System.out.println("User Not Found ");
	}

	/**
	 * Overrides the toString method to provide a custom error message.
	 *
	 * @return A string representation of the exception, indicating "Incorrect
	 *         credentials".
	 */
	@Override
	public String toString() {
		return "Incorrect credentials";
	}
}
