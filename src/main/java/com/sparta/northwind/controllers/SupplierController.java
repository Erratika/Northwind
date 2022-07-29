package com.sparta.northwind.controllers;

import com.sparta.northwind.entities.Shipper;
import com.sparta.northwind.entities.Supplier;
import com.sparta.northwind.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
//		To Add self links.
//		Optional<Supplier> optionalSupplier = repository.findById(id);
//		if (optionalSupplier.isPresent()){
//			Supplier supplier = optionalSupplier.get();
//			supplier.add(linkTo(methodOn(SupplierController.class).getSupplier(id)).withSelfRel());
//			return new ResponseEntity<>(supplier,HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	@DeleteMapping("/suppliers/{id}")
	public ResponseEntity<Supplier> deleteSupplier(@PathVariable int id){
		if (repository.existsById(id)){
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/suppliers")
	public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier){
		return new ResponseEntity<>(repository.save(supplier), HttpStatus.CREATED);
	}
	@PutMapping(value = "/suppliers/{id}", consumes = {"application/json"})
	public ResponseEntity<Supplier> updateEmployee(@PathVariable int id, @RequestBody Supplier supplier) {
		Optional<Supplier> optionalSupplier = repository.findById(id);

		if (optionalSupplier.isPresent()) {
			supplier.setId(id);
			repository.save(supplier);

			return new ResponseEntity<>(supplier, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
}
