package com.ea.car_reservation.controller;

import java.awt.Dialog.ModalExclusionType;
import java.security.Principal;

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
	
@RequestMapping(value={"/", "/home", "loginauthenticate"})
	public String sayHello(Principal principal, Model model){
	String userName = null;
	if(principal != null)
	{
		userName = principal.getName();
	}
	model.addAttribute("userName", userName);
	System.out.println( "Welcome " + userName);
		return "home";	
	}
	
	@RequestMapping(value="/addCustomer",method=RequestMethod.POST)
	@ResponseBody
	public String registerCustomer(Model model, Customer customer){
		customerService.addCustomer(customer);
		return "You have been registered";
	}

	
	/*@RequestMapping ( value = "/login" , method = RequestMethod.GET)
	public String loginCustomer(){
		return "login";
	}*/
	
	@RequestMapping ( value = "/registration" , method = RequestMethod.GET)
	public String registerCustomer(){
		return "registration";
	}
}
