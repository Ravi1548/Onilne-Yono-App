package com.nissan.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.Customer;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Integer> {

	
	//custom methods
	
	//search by account number
	@Query("FROM Customer WHERE accountNumber = ?1 AND isActive = true")
	Customer findCustomerByAccountNumber(long accountNumber);
	
}
