package com.example.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value = "select * from employee where salary>=? AND salary<=?", nativeQuery = true)
	public List<Employee> getBySalary(int salary1, int salary2);

	@Query(value = "select * from Employee where name like ?", nativeQuery = true)
	public List<Employee> getByname(String name);
	@Query(value = "select * from Employee where gender like ?", nativeQuery = true)
	public List<Employee> getByGenderDetail(String gender);


}
