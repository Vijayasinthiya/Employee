package com.example.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository

public class EmployeeDao {
	@Autowired
	EmployeeRepository empRep;

//	public String addEmployee(Employee e)  {
//		empRep.save(e);
//		return "Success";
//	}

	public String addEmployee(Employee e) throws AgeException, Exception {
		empRep.save(e);
		return "Success";
	}

	public List<Employee> getByName(String name) throws NameNotFoundException, Exception {
		return empRep.getByname(name);
	}

	public String addEmployeeList(List<Employee> e1) {
		empRep.saveAll(e1);
		return "Success All";
	}

	public Employee get(int n1) {
		return empRep.findById(n1).get();
	}

	public List<Employee> addList() {
		return empRep.findAll();
	}

	public String detail(int n1) {
		empRep.deleteById(n1);
		return "Success";
	}

	public List<Employee> getAllEmployee() {
		return empRep.findAll();
	}

	public List<Employee> getDetail(int salary1, int salary2) {
		return empRep.getBySalary(salary1, salary2);
	}
	public List<Employee> getByGender(String gender) throws GenderException, Exception {
		return empRep.getByGenderDetail(gender);
	}

}
