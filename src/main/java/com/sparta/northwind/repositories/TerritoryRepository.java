package com.sparta.northwind.repositories;

import com.sparta.northwind.entities.Territory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerritoryRepository extends JpaRepository<Territory, String> {
}