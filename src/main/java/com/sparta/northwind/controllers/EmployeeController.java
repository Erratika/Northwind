package com.sparta.northwind.controllers;

import com.sparta.northwind.EmployeeDto;
import com.sparta.northwind.entities.Employee;
import com.sparta.northwind.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

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

	@PutMapping(value = "/employees/{id}", consumes = {"application/json"})
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee newEmployee) {
		Optional<Employee> optionalEmployee = repository.findById(id);

		if (optionalEmployee.isPresent()) {
			newEmployee.setId(id);
			repository.save(newEmployee);

			return new ResponseEntity<>(newEmployee, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PatchMapping(value = "/employees/{id}", consumes = {"application/json"})
	public ResponseEntity<Employee> patchEmployee(@PathVariable int id, @RequestBody Map<String, Object> fields) {
		Optional<Employee> optionalEmployee = repository.findById(id);
		if (optionalEmployee.isPresent()) {
			Employee employee = optionalEmployee.get();
			// Map key is field name, v is value
			fields.forEach((k, v) -> {
				// use reflection to get field k on manager and set it to value v
				Field field = ReflectionUtils.findField(Employee.class, k);
				if (field != null) {
					field.setAccessible(true);
					ReflectionUtils.setField(field, employee, v);
				}

			});
			repository.save(employee);
			return new ResponseEntity<>(employee, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
}
