package com.sparta.northwind.controllers;

import com.sparta.northwind.entities.Customer;
import com.sparta.northwind.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer){
		return repository.save(customer);
	}
}
