package com.solve.r.us.solverus.service;

import com.solve.r.us.solverus.model.Customer;
import com.solve.r.us.solverus.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("customerService")
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Transactional
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Transactional
	public Optional<Customer> getCustomer(Long id) {
		return customerRepository.findById(id);
	}

	@Transactional
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Transactional
	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Transactional
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
}
