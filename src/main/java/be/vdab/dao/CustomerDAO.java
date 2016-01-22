package be.vdab.dao;

import java.util.List;

import be.vdab.entities.Customer;


public class CustomerDAO extends AbstractDAO{
	/*
	public List<Customer> findByCountry(Country country){
		return getEntityManager().createNamedQuery("Customer.findByCountry", Customer.class)
				.setParameter("country", country)
				.getResultList();
	}
	*/
	
	public List<Customer> findByName(String name){
		return getEntityManager().createNamedQuery("Customer.findByName", Customer.class)
				.setHint("javax.persistence.loadgraph",getEntityManager().createEntityGraph("Customer.WithCountry"))
				.setParameter("name", name)
				.getResultList();
	}

}
