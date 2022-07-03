package com.solve.r.us.solverus.controller;

import com.solve.r.us.solverus.model.Customer;
import com.solve.r.us.solverus.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody String goToHomePage() {
		return "redirect:/getAllCustomers";
	}

	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Iterable<Customer> getAllCustomers() {

		Iterable<Customer> listOfCustomers = customerService.getAllCustomers();
		return listOfCustomers;
	}

	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Optional<Customer> getCustomerById(@PathVariable Long id) {
		return customerService.getCustomer(id);
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody String addCustomer(Customer customer) {
		if(customer.getId()==0)
		{
			customerService.addCustomer(customer);
		}
		else
		{	
			customerService.updateCustomer(customer);
		}

		return "true";
	}

	@RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Optional<Customer> updateCustomer(@PathVariable("id") Long id) {
		return this.customerService.getCustomer(id);
	}

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody String deleteCustomer(@PathVariable("id") Long id) {
		customerService.deleteCustomer(id);
		return "true";

	}	
}
