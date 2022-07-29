package com.sparta.northwind.controllers;

import com.sparta.northwind.EmployeeDto;
import com.sparta.northwind.OrderDto;
import com.sparta.northwind.entities.Employee;
import com.sparta.northwind.entities.Order;
import com.sparta.northwind.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository repository;

	@GetMapping("/employees")
	public List<EmployeeDto> getEmployees() {
		List<Employee> employees = repository.findAll();
		List<EmployeeDto> orderDtos = new ArrayList<>();
		for (Employee employee : employees) {
			orderDtos.add(new EmployeeDto(employee.getId(),
					employee.getLastName(),
					employee.getFirstName(),
					employee.getTitle(),
					employee.getTitleOfCourtesy(),
					employee.getBirthDate(),
					employee.getHireDate(),
					employee.getAddress(),
					employee.getCity(),
					employee.getRegion(),
					employee.getPostalCode(),
					employee.getCountry(),
					employee.getHomePhone(),
					employee.getExtension(),
					employee.getPhoto(),
					employee.getNotes(),
					employee.getPhotoPath(),
					employee.getSalary()));

		}
		return orderDtos;
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable int id) {
		Optional<Employee> optionalEmployee = repository.findById(id);
		return optionalEmployee.map(employee -> new ResponseEntity<>(new EmployeeDto(employee.getId(),
				employee.getLastName(),
				employee.getFirstName(),
				employee.getTitle(),
				employee.getTitleOfCourtesy(),
				employee.getBirthDate(),
				employee.getHireDate(),
				employee.getAddress(),
				employee.getCity(),
				employee.getRegion(),
				employee.getPostalCode(),
				employee.getCountry(),
				employee.getHomePhone(),
				employee.getExtension(),
				employee.getPhoto(),
				employee.getNotes(),
				employee.getPhotoPath(),
				employee.getSalary()), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/employees/delete/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/employees/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(repository.save(employee), HttpStatus.CREATED);
	}
}
