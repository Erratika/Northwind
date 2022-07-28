package com.sparta.northwind.controllers;

import com.sparta.northwind.entities.Employee;
import com.sparta.northwind.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository repository;

	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return repository.findAll();
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id){
		Optional<Employee> optionalEmployee = repository.findById(id);
		return optionalEmployee.map(employee -> new ResponseEntity<>(employee, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee){
		return repository.save(employee);
	}
}
