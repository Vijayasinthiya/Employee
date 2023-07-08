package com.example.employee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service

public class EmployeeService {
	@Autowired
	EmployeeDao empDao;

//	public String addEmployee(Employee e) {
//		return empDao.addEmployee(e);
//	}

	public String addEmployee(Employee e) throws AgeException, Exception {
//		try {
		if (e.getAge() < 18) {
			throw new AgeException("The age is uneligible");
		} else {
			return empDao.addEmployee(e);
		}
//		} catch (Exception d) {
//			return "avoid under Age";
//		}
	}

	public String addEmployeeList(List<Employee> e1) {
		return empDao.addEmployeeList(e1);
	}

	public Employee get(int n1) {
		return empDao.get(n1);
	}

	public List<Employee> getList() {
		return empDao.addList();
	}

	public String detail(int n1) {
		return empDao.detail(n1);
	}

	public List<Employee> getBySalary(int salary) {
		List<Employee> allEmployee = empDao.getAllEmployee();
		return allEmployee.stream().filter((x) -> x.getSalary() > salary).collect(Collectors.toList());
	}

//	public List<String> getByName(int salary) {
//		List<Employee> allEmployee = empDao.getAllEmployee();
//		return allEmployee.stream().filter((x) -> x.getSalary() > salary).map(x -> x.getName())
//				.collect(Collectors.toList());
//	}
	public List<Employee> getByName(String name) throws NameNotFoundException, Exception {
		if (empDao.getByName(name).isEmpty()) {
			throw new NameNotFoundException("Name not in List");
		}
		else {
			return empDao.getByName(name);
		}
	}

	public Long getCount(String gender) {
		List<Employee> allEmployee = empDao.getAllEmployee();
		return allEmployee.stream().filter((x) -> x.getGender().equals("male")).count();
	}

	public Long getCount1(int salary) {
		List<Employee> allEmployee = empDao.getAllEmployee();
		return allEmployee.stream().filter((x) -> x.getSalary() == salary).count();
	}

	public List<Employee> getMenDetail(String gender) {
		List<Employee> allEmployee = empDao.getAllEmployee();
		return allEmployee.stream().filter((x) -> x.getGender().equals("male")).collect(Collectors.toList());
	}

	public List<Employee> getDetail(int salary1, int salary2) {
		return empDao.getDetail(salary1, salary2);
	}

	public List<Employee> getByGender(String gender) throws GenderException, Exception {
		if (empDao.getByGender(gender).isEmpty()) {
			throw new GenderException("Detail not in List");
		} 
		else {
			return empDao.getByGender(gender);
		}
	}
	public List<Employee> getBySalary1( int a)  {
		return empDao.getBySalary1(a);
	}
}
