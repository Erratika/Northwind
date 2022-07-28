package com.sparta.northwind.controllers;

import com.sparta.northwind.entities.Supplier;
import com.sparta.northwind.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SupplierController {
	@Autowired
	private SupplierRepository repository;

	@GetMapping("/suppliers")
	public List<Supplier> getSuppliers(){
		return repository.findAll();
	}
	@GetMapping("/suppliers/{id}")
	public ResponseEntity<Supplier> getSupplier(@PathVariable int id){
		Optional<Supplier> optionalSupplier = repository.findById(id);
		return optionalSupplier.map(supplier -> new ResponseEntity<>(supplier, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@DeleteMapping("/suppliers/{id}")
	public ResponseEntity<Supplier> deleteSupplier(@PathVariable int id){
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PostMapping("/suppliers")
	public Supplier createSupplier(@RequestBody Supplier supplier){
		return repository.save(supplier);
	}
}
