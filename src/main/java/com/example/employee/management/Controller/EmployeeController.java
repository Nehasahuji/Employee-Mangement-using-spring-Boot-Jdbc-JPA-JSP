package com.example.employee.management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.employee.management.Entity.Employee;
import com.example.employee.management.Service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public String ViewHomePage(Model model) {
		model.addAttribute("listEmployee", employeeService.getAllRecords());
		return "index";
	}

	@GetMapping("/ShowNewEmployeeForm")
	public String ShowNewEmployeeForm(Model model) {// create a model attribute to form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/ShowFormForUpdate/{id}")
	public String ShowFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		System.out.print("inside this block");
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";

	}
	
	@GetMapping("/DeleteById/{id}")
	public String DeleteById(@PathVariable (value="id") long id) {
		employeeService.deleteEmployeeById(id);
		return("redirect:/");
	}

}