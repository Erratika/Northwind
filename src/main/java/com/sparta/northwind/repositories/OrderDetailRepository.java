package com.sparta.northwind.repositories;

import com.sparta.northwind.entities.OrderDetail;
import com.sparta.northwind.entities.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
}