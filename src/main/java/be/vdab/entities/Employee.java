package be.vdab.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import be.vdab.valueobjects.Address;

@Entity
@Table(name = "employees")
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	private String lastName;
	private String firstName;
	private String title;
	private String titleOfCourtesy;
	private Date birth;
	private Date hired;
	@Embedded
	private Address address;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reportsTo")
	private Employee boss;	
	
	@OneToMany(mappedBy = "boss")
	private Set<Employee> staff;

	public long getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getName(){
		return getFirstName() +  ' ' + getLastName();
	}

	public String getTitle() {
		return title;
	}

	public String getTitleOfCourtesy() {
		return titleOfCourtesy;
	}

	public Date getBirth() {
		return birth;
	}

	public Date getHired() {
		return hired;
	}

	public Address getAddress() {
		return address;
	}

	public Employee getBoss() {
		return boss;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
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
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + "]";
	}

	public void setBoss(Employee boss) {
		this.boss = boss;
	}

	public Set<Employee> getStaff() {
		return staff;
	}
	
	
}
