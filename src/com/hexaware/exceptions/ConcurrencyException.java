package com.hexaware.exceptions;

/**
 * Custom exception class for handling concurrency-related issues.
 * This exception is thrown when multiple users simultaneously attempt to update the same order.
 */
public class ConcurrencyException extends Exception {

    /**
     * Default constructor for the ConcurrencyException class.
     * It prints a message to the console when the exception is instantiated.
     */
    public ConcurrencyException() {
        System.out.println("Multiple users simultaneously attempt to update the same order");
    }

    /**
     * Overrides the toString method to provide a custom error message.
     *
     * @return A string representation of the exception, indicating
     * "Multiple users simultaneously attempt to update the same order".
     */
    @Override
    public String toString() {
        return "Multiple users simultaneously attempt to update the same order";
    }
}
