package be.vdab.dao;

import java.util.List;

import javax.persistence.LockModeType;

import be.vdab.entities.Employee;

public class EmployeeDAO extends AbstractDAO{
	public Employee read(long id){
		return getEntityManager().find(Employee.class, id);
	}	
	
	
	public Employee readWithLock(long id){
		return getEntityManager().find(Employee.class, id, LockModeType.PESSIMISTIC_READ);
	}	
	
	public List<Employee> findBoss(long id){
		return getEntityManager().createNamedQuery("Employee.findStaff",Employee.class)
				.setParameter("id", read(id).getBoss().getId())
				.getResultList();
	}
	
	public void save(Employee employee){
		getEntityManager().persist(employee);
	}


}
