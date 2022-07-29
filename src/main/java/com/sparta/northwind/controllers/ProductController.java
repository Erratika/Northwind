package com.sparta.northwind.controllers;

import com.sparta.northwind.dtos.EmployeeDto;
import com.sparta.northwind.dtos.ProductDto;
import com.sparta.northwind.entities.Customer;
import com.sparta.northwind.entities.Employee;
import com.sparta.northwind.entities.Product;
import com.sparta.northwind.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TODO REFERNCE TO SUPPLIER ID and CategoryID
@RestController
public class ProductController {
	@Autowired
	private ProductRepository repository;

	@GetMapping("/products")
	public List<ProductDto> getProducts() {
		List<Product> products = repository.findAll();
		List<ProductDto> orderDtos = new ArrayList<>();
		for (Product product : products) {
			orderDtos.add(new ProductDto(product.getId(), product.getProductName(), product.getQuantityPerUnit(), product.getUnitPrice(), product.getUnitsInStock(), product.getUnitsOnOrder(), product.getReorderLevel(), product.getDiscontinued()));

		}
		return orderDtos;
	}


	@GetMapping("/products/{id}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable int id) {
		Optional<Product> optionalProduct = repository.findById(id);
		if (optionalProduct.isPresent()){
			Product product = optionalProduct.get();
			ProductDto productDto = new ProductDto(product.getId(), product.getProductName(), product.getQuantityPerUnit(), product.getUnitPrice(), product.getUnitsInStock(), product.getUnitsOnOrder(), product.getReorderLevel(), product.getDiscontinued());
			return  new ResponseEntity<>(productDto,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable int id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
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
