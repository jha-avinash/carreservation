package com.ea.car_reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ea.car_reservation.domain.Customer;
import com.ea.car_reservation.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value={"/"})
	public String sayHello(){
		System.out.println("Welcome");
		return "registration";	
	}
	
	@RequestMapping(value="/addCustomer",method=RequestMethod.POST)
	@ResponseBody
	public String registerCustomer(Model model, Customer customer){
		customerService.addCustomer(customer);
		return "You have been registered.";
	}
}