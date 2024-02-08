package com.hexaware.exceptions;

/**
 * Custom exception class for handling authentication-related issues. This
 * exception is thrown when authentication fails due to invalid user
 * credentials.
 */
public class AuthenticationException extends Exception {

	/**
	 * Default constructor for the AuthenticationException class. It prints a
	 * message to the console when the exception is instantiated.
	 */
	public AuthenticationException() {
		System.out.println("AuthenticationException");
	}

	/**
	 * Overrides the toString method to provide a custom error message.
	 *
	 * @return A string representation of the exception, indicating "Invalid User
	 *         Credentials!"
	 */
	@Override
	public String toString() {
		return "Invalid User Credentials!";
	}
}
