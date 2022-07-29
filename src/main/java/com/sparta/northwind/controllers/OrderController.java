package com.sparta.northwind.controllers;

import com.sparta.northwind.OrderDto;
import com.sparta.northwind.entities.Employee;
import com.sparta.northwind.OrderDto;
import com.sparta.northwind.entities.Order;
import com.sparta.northwind.repositories.OrderRepository;
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
//TODO Reference to CustomerID, EmployeeID and ShipVia.
@RestController
public class OrderController {
	@Autowired
	private OrderRepository repository;

	@GetMapping("/orders")
	public List<OrderDto> getOrders() {
		List<Order> orderEntities = repository.findAll();
		List<OrderDto> orderDtos = new ArrayList<>();
		for (Order order : orderEntities) {
			orderDtos.add(new OrderDto(order.getId(),
					order.getOrderDate(),
					order.getRequiredDate(),
					order.getShippedDate(),
					order.getFreight(),
					order.getShipName(),
					order.getShipAddress(),
					order.getShipCity(),
					order.getShipRegion(),
					order.getShipPostalCode(),
					order.getShipCountry()));

		}
		return orderDtos;
	}
	@GetMapping("/orders/{id}")
	public ResponseEntity<OrderDto> getOrder(@PathVariable int id) {
		Optional<Order> optionalOrder = repository.findById(id);
		return optionalOrder.map(order -> new ResponseEntity<>(new OrderDto(order.getId(),
				order.getOrderDate(),
				order.getRequiredDate(),
				order.getShippedDate(),
				order.getFreight(),
				order.getShipName(),
				order.getShipAddress(),
				order.getShipCity(),
				order.getShipRegion(),
				order.getShipPostalCode(),
				order.getShipCountry()), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Order> deleteOrder(@PathVariable int id) {
		if (repository.existsById(id)){
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}



	@PostMapping("/orders")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		return new ResponseEntity<>(repository.save(order),HttpStatus.CREATED);
	}
	@PutMapping(value = "/orders/{id}", consumes = {"application/json"})
	public ResponseEntity<Order> updateOrder(@PathVariable int id, @RequestBody Order newOrder) {
		Optional<Order> optionalOrder = repository.findById(id);

		if (optionalOrder.isPresent()) {
			newOrder.setId(id);
			repository.save(newOrder);

			return new ResponseEntity<>(newOrder, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PatchMapping(value = "/orders/{id}", consumes = {"application/json"})
	public ResponseEntity<Order> patchOrder(@PathVariable int id, @RequestBody Map<String, Object> fields) {
		Optional<Order> optionalOrder = repository.findById(id);
		if (optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			// Map key is field name, v is value
			fields.forEach((k, v) -> {
				// use reflection to get field k on manager and set it to value v
				Field field = ReflectionUtils.findField(Order.class, k);
				if (field != null) {
					field.setAccessible(true);
					ReflectionUtils.setField(field, order, v);
				}

			});
			repository.save(order);
			return new ResponseEntity<>(order, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
}
