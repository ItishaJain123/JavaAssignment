package com.hexaware.exceptions;

/**
 * Custom exception class for handling invalid data-related issues.
 * This exception is thrown when invalid data is encountered.
 */
public class InvalidDataException extends Exception {

    /**
     * Default constructor for the InvalidDataException class.
     * It prints a generic message to the console when the exception is instantiated.
     */
    public InvalidDataException() {
        System.out.println("Enter valid data");
    }

    /**
     * Constructor for the InvalidDataException class with a custom message.
     * It prints a message to the console when the exception is instantiated with specific details.
     *
     * @param message A specific message indicating the reason for the invalid data.
     */
    public InvalidDataException(String message) {
        System.out.println("Enter valid data: " + message);
    }

    /**
     * Overrides the toString method to provide a custom error message.
     *
     * @return A string representation of the exception, indicating "Given data not valid".
     */
    @Override
    public String toString() {
        return "Given data not valid";
    }
}
