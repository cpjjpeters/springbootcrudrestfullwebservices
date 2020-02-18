package be.belfius.sbcrudrw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.belfius.sbcrudrw.exception.ResourceNotFoundException;
import be.belfius.sbcrudrw.model.Employee;
import be.belfius.sbcrudrw.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// all
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	// create
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee entity) {
		return employeeRepository.save(entity);
	}
	
	//get employee by id
	@GetMapping("employees/{id}")
	// public Employee findById(@PathVariable(value = "id") long id){
	// return employeeRepository.findById(id);
	//}
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") long id) throws ResourceNotFoundException{
		Employee employee = employeeRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Employee not found for this id :: "+id));
		return ResponseEntity.ok().body(employee);
	}
	// update
	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") long id
			,@RequestBody Employee employeeDetails )throws ResourceNotFoundException{
		Employee employee = employeeRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Employee not found for this id :: "+id));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		employeeRepository.save(employee);
		return ResponseEntity.ok().body(employee);
	}
	
	//delete
	@DeleteMapping("/employees/{id}")
	public ResponseEntity deleteEmployee(@PathVariable(value = "id") long id) throws ResourceNotFoundException{
		Employee employee = employeeRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Employee not found for this id :: "+id));
		employeeRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	

}
