package org.hackathon.packapp.containerbank.service.impl;

import java.util.Collection;

import org.hackathon.packapp.containerbank.model.Customer;
import org.hackathon.packapp.containerbank.repository.CustomerRepository;
import org.hackathon.packapp.containerbank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public Customer findCustomerById(int id) throws DataAccessException {
		return customerRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Customer> findCustomerByLastName(String lastName) throws DataAccessException {
		return customerRepository.findByLastName(lastName);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) throws DataAccessException {
		customerRepository.save(customer);
	}
}
