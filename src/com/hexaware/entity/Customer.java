/**
 * The `Customer` class represents a customer entity with various attributes
 * such as customerID, firstName, lastName, email, phone, and address.
 * It provides methods to retrieve and set these attributes, perform validations,
 * and obtain the full name of the customer.
 * 
 * Usage:
 * ```
 * // Create a new customer
 * Customer customer = new Customer(1, "John", "Doe", "john.doe@example.com", "1234567890", "123 Main St");
 * 
 * // Access and modify customer attributes
 * customer.setPhone("9876543210");
 * 
 * // Retrieve customer details
 * System.out.println("Customer ID: " + customer.getCustomerID());
 * System.out.println("Full Name: " + customer.getFullName());
 * System.out.println("Email: " + customer.getEmail());
 * ```
 * 
 * Note: The email validation is performed using the `Validations` class.
 * Ensure proper validation before setting the email attribute.
 * 
 * @author Itisha Jain
 * @version 1.0
 * @since 2024-02-01
 */

package com.hexaware.entity;
import com.hexaware.util.Validations;

public class Customer {
    private int customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    
    // Constructor without parameters
    public Customer() {
    	
    }

    // Constructor with parameters to initialize values
    public Customer(int customerID, String firstName, String lastName, String email, String phone, String address) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // Getter and Setter for CustomerID
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    // Getter and Setter for FirstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter for LastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and Setter for Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
    	if(Validations.isValidEmail(email)) {
    		this.email = email;
    	}
    }

    // Getter and Setter for Phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter and Setter for Address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for Full Name
    public String getFullName() {
        return firstName + " " + lastName;
    }

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phone=" + phone + ", address=" + address + "]";
	}

}