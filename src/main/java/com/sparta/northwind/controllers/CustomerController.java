package com.sparta.northwind.controllers;

import com.sparta.northwind.entities.Customer;
import com.sparta.northwind.entities.Employee;
import com.sparta.northwind.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository repository;

	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return repository.findAll();
	}
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable String id){
		Optional<Customer> optionalCustomer = repository.findById(id);
		return optionalCustomer.map(customer -> new ResponseEntity<>(customer, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable String id){
		if (repository.existsById(id)){
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/customers")
	public ResponseEntity<Customer> createEmployee(@RequestBody Customer customer) {
		return new ResponseEntity<>(repository.save(customer), HttpStatus.CREATED);
	}
	@PutMapping(value = "/customers/{id}", consumes = {"application/json"})
	public ResponseEntity<Customer> updateEmployee(@PathVariable String id, @RequestBody Customer customer) {
		Optional<Customer> optionalCustomer = repository.findById(id);

		if (optionalCustomer.isPresent()) {
			customer.setId(id);
			repository.save(customer);

			return new ResponseEntity<>(customer, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PatchMapping(value = "/customers/{id}", consumes = {"application/json"})
	public ResponseEntity<Customer> patchCustomer(@PathVariable String id, @RequestBody Map<String, Object> fields) {
		Optional<Customer> optionalEmployee = repository.findById(id);
		if (optionalEmployee.isPresent()) {
			Customer customer = optionalEmployee.get();
			// Map key is field name, v is value
			fields.forEach((k, v) -> {
				// use reflection to get field k on manager and set it to value v
				Field field = ReflectionUtils.findField(Customer.class, k);
				if (field != null) {
					field.setAccessible(true);
					ReflectionUtils.setField(field, customer, v);
				}

			});
			repository.save(customer);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
}
