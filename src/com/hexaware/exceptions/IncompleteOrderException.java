package com.hexaware.exceptions;

/**
 * Custom exception class for handling incomplete order-related issues.
 * This exception is thrown when an order detail lacks a product reference.
 */
public class IncompleteOrderException extends Exception {

    /**
     * Default constructor for the IncompleteOrderException class.
     * It prints a message to the console when the exception is instantiated.
     */
    public IncompleteOrderException() {
        System.out.println("Order detail lacks a product reference.");
    }

    /**
     * Overrides the toString method to provide a custom error message.
     *
     * @return A string representation of the exception, indicating
     * "Order detail lacks a product reference."
     */
    @Override
    public String toString() {
        return "Order detail lacks a product reference.";
    }
}
