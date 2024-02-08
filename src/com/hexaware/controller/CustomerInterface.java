package com.hexaware.controller;

/**
 * Interface for managing customer-related operations.
 */
public interface CustomerInterface {

    /**
     * Adds a new customer to the system.
     */
    public void addCustomer();

    /**
     * Calculates the total orders for a specific customer.
     */
    public void calculateTotalOrders();

    /**
     * Retrieves and displays details of a specific customer.
     */
    public void getCustomerDetails();

    /**
     * Updates the information of an existing customer.
     */
    public void updateCustomerInfo();

    /**
     * Retrieves and displays a list of all customers.
     */
    public void getCustomerList();
}
