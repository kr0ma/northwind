package be.vdab.services;

import java.util.ArrayList;
import java.util.List;

import be.vdab.dao.EmployeeDAO;
import be.vdab.entities.Employee;

public class EmployeeService {
	private final EmployeeDAO employeeDAO = new EmployeeDAO();
	
	public Employee read(long id){
		return employeeDAO.read(id);
	}	
	
	public List<Employee> findBosses(long id){
		List<Employee> bosses = new ArrayList<>();
		Employee employee = this.read(id).getBoss();		
		while (employee != null && employee.getBoss() != null){			
			bosses.add(employee.getBoss());
			employee = this.read(bosses.get(bosses.size() - 1).getId());			
		}			
		System.out.println(bosses);
		return bosses;		
	}
	
	public boolean changeBoss(long id, long bossId){
		employeeDAO.beginTransaction();
		Employee employee = employeeDAO.readWithLock(id);
		Employee boss = employeeDAO.read(bossId);
		if (this.findBosses(id).contains(boss)){
			employee.setBoss(boss);
			employeeDAO.save(employee);
			employeeDAO.commit();
			return true;
		} else {
			return false;
		}
	}
	
	
}
