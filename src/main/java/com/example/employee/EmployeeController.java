package com.example.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	@Autowired
	EmployeeService empSer;

//	@PostMapping(value = "/insertAll1")
//	public String addEmployee(@RequestBody Employee e) {
//		return empSer.addEmployee(e);
//	}

	@PostMapping(value = "/insert")
	public String addEmployee(@RequestBody Employee e) throws AgeException, Exception {
		return empSer.addEmployee(e);
	}

	@PostMapping(value = "/insertall")
	public String addEmployeeList(@RequestBody List<Employee> e1) {
		return empSer.addEmployeeList(e1);
	}

	@GetMapping(value = "/detail/{n1}")
	public Employee get(@PathVariable int n1) {
		return empSer.get(n1);
	}

	@GetMapping(value = "/alldetail")
	public List<Employee> getList() {
		return empSer.getList();
	}

	@GetMapping(value = "/remain/{n1}")
	public String detail(@PathVariable int n1) {
		return empSer.detail(n1);
	}

	@GetMapping(value = "/getBySalary/{salary}")
	public List<Employee> getBySalary(@PathVariable int salary) {
		return empSer.getBySalary(salary);
	}

//	@GetMapping(value="/getByName/{salary}")
//	public List<String> getByName(@PathVariable int salary) {
//		return empSer.getByName(salary);
//	}
	@GetMapping(value = "/getByName/{name}")
	public List<Employee> getByName(@PathVariable String name) throws NameNotFoundException, Exception {
		return empSer.getByName(name);
	}

	@GetMapping(value = "/getCount/{gender}")
	public Long getCount(@PathVariable String gender) {
		return empSer.getCount(gender);
	}

	@GetMapping(value = "/getCount1/{salary}")
	public Long getCount1(@PathVariable int salary) {
		return empSer.getCount1(salary);
	}

	@GetMapping(value = "/getMenDetail/{gender}")
	public List<Employee> getMenDetail(@PathVariable String gender) {
		return empSer.getMenDetail(gender);
	}

	@GetMapping(value = "/getDetail/{salary1}/{salary2}")
	public List<Employee> getDetail(@PathVariable int salary1, @PathVariable int salary2) {
		return empSer.getDetail(salary1, salary2);
	}
	@GetMapping(value = "/getByGender/{gender}")
	public List<Employee> getByGender(@PathVariable String gender) throws GenderException, Exception {
		return empSer.getByGender(gender);
	}
	@GetMapping(value = "/getBySalary1/{a}")
	public List<Employee> getBySalary1(@PathVariable int a)  {
		return empSer.getBySalary1(a);
	}

}
