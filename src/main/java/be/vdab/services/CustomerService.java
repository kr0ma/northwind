package be.vdab.services;

import java.util.List;

import be.vdab.dao.CustomerDAO;
import be.vdab.entities.Customer;

public class CustomerService {

	private final CustomerDAO customerDAO = new CustomerDAO();
	
	/*
	public List<Customer> findByCountry(Country country){
		return customerDAO.findByCountry(country);
	}
	*/
	
	public List<Customer> findByName(String name){
		return customerDAO.findByName(name);
	}
}
