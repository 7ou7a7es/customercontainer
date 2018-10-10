package org.hackathon.packapp.containerbank.service;

import java.util.Collection;

import org.hackathon.packapp.containerbank.model.Customer;
import org.springframework.dao.DataAccessException;

public interface CustomerService {

	Customer findCustomerById(int id) throws DataAccessException;

	void saveCustomer(Customer customer) throws DataAccessException;

	Collection<Customer> findCustomerByLastName(String lastName) throws DataAccessException;
}
