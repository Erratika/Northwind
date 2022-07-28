package com.sparta.northwind.controllers;

import com.sparta.northwind.entities.Order;
import com.sparta.northwind.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//TODO Reference to CustomerID, EmployeeID and ShipVia.
@RestController
public class OrderController {
	@Autowired
	private OrderRepository repository;

	@GetMapping("/orders")
	public List<Order> getOrders(){
		return repository.findAll();
	}
	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable int id){
		Optional<Order> optionalOrder = repository.findById(id);
		return optionalOrder.map(order -> new ResponseEntity<>(order, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Order> deleteOrder(@PathVariable int id){
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PostMapping("/orders")
	public Order createOrder(@RequestBody Order order){
		return repository.save(order);
	}
}
