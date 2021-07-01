package com.example.employee.management.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee.management.Entity.Employee;

@Service
public interface EmployeeService {

	public List<Employee> getAllRecords();

	public void saveEmployee(Employee emp);

	public Employee getEmployeeById(long id);

	public void deleteEmployeeById(long id);

}
