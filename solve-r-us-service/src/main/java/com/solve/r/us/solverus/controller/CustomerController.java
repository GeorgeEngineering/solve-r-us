package com.solve.r.us.solverus.controller;

import com.solve.r.us.solverus.model.Customer;
import com.solve.r.us.solverus.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:4200"})
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Iterable<Customer> getAllCustomers() {
		Iterable<Customer> listOfCustomers = customerService.getAllCustomers();
		return listOfCustomers;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Optional<Customer> getCustomerById(@PathVariable Long id) {
		return customerService.getCustomer(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody String addCustomer(Customer customer) {
		if(customer.getId() == 0) {
			customerService.addCustomer(customer);
		}
		else {
			customerService.updateCustomer(customer);
		}
		return "true";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public @ResponseBody void updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
		this.customerService.updateCustomer(customer);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public @ResponseBody String deleteCustomer(@PathVariable("id") Long id) {
		customerService.deleteCustomer(id);
		return "true";
	}
}
