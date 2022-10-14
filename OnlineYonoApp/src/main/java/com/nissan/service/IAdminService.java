package com.nissan.service;

import java.util.List;

import com.nissan.model.Customer;

public interface IAdminService {

	// add customer
	Customer addCustomer(Customer customer);
	
	//update user
	Customer updateCustomer(Customer customer);
	
	//deleting user
	Customer deleteCustomer(long accountNumber);
		
	//display all customers
	List<Customer> getAllCustomers();
		
	//search by account number
	Customer findByAccountNumber(long accountNumber);
}
