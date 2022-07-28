package com.sparta.northwind.repositories;

import com.sparta.northwind.entities.Customercustomerdemo;
import com.sparta.northwind.entities.CustomercustomerdemoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomercustomerdemoRepository extends JpaRepository<Customercustomerdemo, CustomercustomerdemoId> {
}