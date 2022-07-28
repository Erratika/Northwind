package com.sparta.northwind.repositories;

import com.sparta.northwind.entities.Customerdemographic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerdemographicRepository extends JpaRepository<Customerdemographic, String> {
}