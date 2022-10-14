package com.nissan.service;

import com.nissan.model.Customer;

public interface ICustomerService {
	
	//Depositing Money into Customer Account
	String depositeMoney(long accountNumber,double money);
	
	//Withdraw Money from Customer Account
	String withdrawMoney(long accountNumber,double money);
	
	//Show Balance of a Customer
	String showBalance(long accountNumber);
	
	//Transferring Money from One Account to Another account
	String transferMoney(long senderAccountNumber, long receiverAccountNumber, double money);
}
