package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.model.Customer;
import com.nissan.repository.ICustomerRepository;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	ICustomerRepository custRepo;

	
	//show all customer
	@Override
	public List<Customer> getAllCustomers() {
		return (List<Customer>)custRepo.findAll();
	}

	// add new Customer
	@Transactional
	@Override
	public Customer addCustomer(Customer customer) {
		long accountNumber = this.accountNumberGenerator();
		customer.setAccountNumber(accountNumber);
		int atmPin = this.atmPinGenerator();
		customer.setAtmPin(atmPin);
		return custRepo.save(customer);
	}


	//update Customer
	@Transactional
	@Override
	public Customer updateCustomer(Customer customer) {
		return custRepo.save(customer);
	}


	//delete Customer
	@Transactional
	@Override
	public Customer deleteCustomer(long accountNumber) {
		Customer customer = custRepo.findCustomerByAccountNumber(accountNumber);
		customer.setActive(false);
		return custRepo.save(customer);
	}
	
	//search by account number
	@Override
	public Customer findByAccountNumber(long accountNumber) {
		Customer customer = custRepo.findCustomerByAccountNumber(accountNumber);
		return customer;
	}
	
	
	
	
	//custome methods
	//Auto Generate Account Number - 9 digits
	private long accountNumberGenerator() {
		return (long)(Math.random()*(999999999-100000000+1)+100000000);
	}
	
	//Auto Generate Atm pin  - 4 digits
	private int atmPinGenerator() {
		return (int)(Math.random()*(9999-1000+1)+1000);
	}

}
