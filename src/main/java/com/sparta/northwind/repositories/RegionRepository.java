package com.sparta.northwind.repositories;

import com.sparta.northwind.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer> {
}