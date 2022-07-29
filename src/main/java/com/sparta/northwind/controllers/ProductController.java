package com.sparta.northwind.controllers;

import com.sparta.northwind.entities.Customer;
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
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable int id){
		if (repository.existsById(id)){
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		return new ResponseEntity<>(repository.save(product), HttpStatus.CREATED);
	}

	@PutMapping(value = "/products/{id}", consumes = {"application/json"})
	public ResponseEntity<Product> updateEmployee(@PathVariable int id, @RequestBody Product product) {
		Optional<Product> optionalProduct = repository.findById(id);

		if (optionalProduct.isPresent()) {
			product.setId(id);
			repository.save(product);

			return new ResponseEntity<>(product, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
}
