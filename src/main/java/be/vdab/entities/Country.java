package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;	
	private String name;
	
	@OneToMany(mappedBy = "country")
	@OrderBy("name")
	private Set<Customer> customers;
	
	public Country(String name) {
		this.name = name;
	}
	
	protected Country(){}
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}		
	
	public Set<Customer> getCustomers() {
		return Collections.unmodifiableSet(customers);
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	
}
