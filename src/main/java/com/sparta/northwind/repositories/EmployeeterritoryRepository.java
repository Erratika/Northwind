package com.sparta.northwind.repositories;

import com.sparta.northwind.entities.Employeeterritory;
import com.sparta.northwind.entities.EmployeeterritoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeterritoryRepository extends JpaRepository<Employeeterritory, EmployeeterritoryId> {
}