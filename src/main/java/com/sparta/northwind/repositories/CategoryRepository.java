package com.sparta.northwind.repositories;

import com.sparta.northwind.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}