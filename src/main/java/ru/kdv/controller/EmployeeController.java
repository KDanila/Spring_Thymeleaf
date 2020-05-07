package ru.kdv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kdv.Service.EmployeeService;
import ru.kdv.model.Employee;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> theEmployees = employeeService.findAll();
		theModel.addAttribute("employees", theEmployees);
		return "list-employees";
	}

	@GetMapping("/addForm")
	public String addForm(Model model){
		model.addAttribute("employee", new Employee());
		return "add-form";
	}

	@GetMapping("/updateEmployee")
	public String updateEmployee(@RequestParam("employeeId") int id, Model model){
		model.addAttribute("employee", employeeService.findById(id));
		return "add-form";
	}

	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int id, Model model){
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee){
		employeeService.save(employee);
		return "redirect:/employees/list";
	}

}









