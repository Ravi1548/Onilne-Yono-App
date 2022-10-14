package com.nissan.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

	@RequestMapping("/")
	public String showAllCustomers() {
		return "Welcome Online YONO App. \n\n add '/customer' for customer API Menu \n add '/admin' for Administrator API Menu";
	}
}
