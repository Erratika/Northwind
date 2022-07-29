package com.sparta.northwind.controllers;

import com.sparta.northwind.entities.Product;
import com.sparta.northwind.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//TODO REFERNCE TO SUPPLIER ID and CategoryID
@RestController
public class ProductController {
	@Autowired
	private ProductRepository repository;

	@GetMapping("/products")
	public List<Product> getProducts(){
		return repository.findAll();
	}
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable int id){
		Optional<Product> optionalProduct = repository.findById(id);
		return optionalProduct.map(product -> new ResponseEntity<>(product, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@DeleteMapping("/products/delete/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable int id){
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PostMapping("/products/create")
	public Product createProduct(@RequestBody Product product){
		return repository.save(product);
	}
}
