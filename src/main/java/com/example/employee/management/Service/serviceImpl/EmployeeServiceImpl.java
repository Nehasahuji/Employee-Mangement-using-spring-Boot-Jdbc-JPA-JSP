package com.example.employee.management.Service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.management.Entity.Employee;
import com.example.employee.management.Repository.EmployeeRepository;
import com.example.employee.management.Service.EmployeeService;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllRecords() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee emp) {
		employeeRepository.save(emp);
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException("Employee not found for :: " + id);
		}

		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		employeeRepository.deleteById(id);
	}

}
