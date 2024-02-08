/**
 * The `Validations` class provides methods for validating email and phone number formats.
 * 
 * Usage:
 * ```
 * // Example of email validation
 * String email = "example@email.com";
 * if (Validations.isValidEmail(email)) {
 *     System.out.println("Email is valid.");
 * } else {
 *     System.out.println("Email is not valid.");
 * }
 * 
 * // Example of phone number validation
 * String phone = "1234567890";
 * if (Validations.isValidPhone(phone)) {
 *     System.out.println("Phone number is valid.");
 * } else {
 *     System.out.println("Phone number is not valid.");
 * }
 * ```
 * 
 * Note: Ensure that you handle the `InvalidDataException` appropriately when it is thrown.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-01
 */

package com.hexaware.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hexaware.exceptions.InvalidDataException;

public class Validations {
	
	/**
	 * Validates the format of an email address.
	 * 
	 * @param email The email address to be validated.
	 * @return true if the email address is valid, false otherwise.
	 */
	public static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

		try {
			// Create a pattern object
			Pattern pattern = Pattern.compile(emailRegex);
	        
	        // Create a matcher object
	        Matcher matcher = pattern.matcher(email);
	        
	        if (matcher.matches()) {
	        	return true;
	        }else 
				throw new InvalidDataException();
		}
        catch(InvalidDataException e) {
			System.out.println("Enter a valid email");
		}
		return false;
	}
	
	/**
	 * Validates the format of a phone number.
	 * 
	 * @param phone The phone number to be validated.
	 * @return true if the phone number is valid, false otherwise.
	 */
	public static boolean isValidPhone(String phone) {
		String phoneRegex = "^\\d{10}$";
		try {
			Pattern pattern = Pattern.compile(phoneRegex);
			Matcher matcher = pattern.matcher(phone);
			if (matcher.matches()) {
	        	return true;
	        }else 
				throw new InvalidDataException();
		}
        catch(InvalidDataException e) {
			System.out.println("Enter a valid phone number");
		}
				
		return false;
	}
	
	
	
	
	
}
