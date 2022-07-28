package com.sparta.northwind.controllers;

import com.sparta.northwind.entities.Shipper;
import com.sparta.northwind.repositories.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShipperController {
	@Autowired
	private ShipperRepository repository;

	@GetMapping("/shippers")
	public List<Shipper> getShippers(){
		return repository.findAll();
	}
	@GetMapping("/shippers/{id}")
	public ResponseEntity<Shipper> getShipper(@PathVariable int id){
		Optional<Shipper> optionalShipper = repository.findById(id);
		return optionalShipper.map(shipper -> new ResponseEntity<>(shipper, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@DeleteMapping("/shippers/{id}")
	public ResponseEntity<Shipper> deleteShipper(@PathVariable int id){
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PostMapping("/shippers")
	public Shipper createShipper(@RequestBody Shipper shipper){
		return repository.save(shipper);
	}
}
