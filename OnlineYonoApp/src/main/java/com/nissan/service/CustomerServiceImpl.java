package com.nissan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.model.Customer;
import com.nissan.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	//Di Injection
	@Autowired
	ICustomerRepository custRepo;

	//Depositing Money into Customer Account
	@Transactional
	@Override
	public String depositeMoney(long accountNumber, double money) {
		Customer customer = custRepo.findCustomerByAccountNumber(accountNumber);
		customer.setBalance(customer.getBalance()+money);
		custRepo.save(customer);
		return "Amount Deposited Successfully";
	}

	//Withdraw Money from Customer Account
	@Transactional
	@Override
	public String withdrawMoney(long accountNumber, double money) {
		Customer customer = custRepo.findCustomerByAccountNumber(accountNumber);
		if(customer.getBalance()-money < customer.getMinBalance()) {
			return "Insufficient Funds! , Available Balance is : "+(customer.getBalance()-customer.getMinBalance());
		}
		else {
			customer.setBalance(customer.getBalance()-money);
			custRepo.save(customer);
			return "Amount withdrawed Successfully";
		}
	}

	//Show Balance of a Customer
	@Override
	public String showBalance(long accountNumber) {
		Customer customer = custRepo.findCustomerByAccountNumber(accountNumber);
		
		return "Your Account Total Balance is : "+(customer.getBalance())+" and your Available balance is : "+(customer.getBalance()-customer.getMinBalance());
	}

	//Transferring Money from One Account to Another account
	@Override
	public String transferMoney(long senderAccountNumber, long receiverAccountNumber, double money) {
		this.withdrawMoney(senderAccountNumber, money);
		this.depositeMoney(receiverAccountNumber, money);
		return "Amount Transfered Successfully";
	}
	
	
}
