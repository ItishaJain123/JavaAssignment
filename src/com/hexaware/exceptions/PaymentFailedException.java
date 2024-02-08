package com.hexaware.exceptions;

/**
 * Custom exception class for handling payment-related issues. This exception is
 * thrown when a payment is declined.
 */
public class PaymentFailedException extends Exception {

	/**
	 * Default constructor for the PaymentFailedException class. It prints a message
	 * to the console when the exception is instantiated.
	 */
	public PaymentFailedException() {
		System.out.println("Payment is declined.");
	}

	/**
	 * Overrides the toString method to provide a custom error message.
	 *
	 * @return A string representation of the exception, indicating "Payment is
	 *         declined".
	 */
	@Override
	public String toString() {
		return "Payment is declined";
	}
}
