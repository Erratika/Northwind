package com.sparta.northwind.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwind.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {

    @Test
    void checkProductExists(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Product result = mapper.readValue(new URL("http://localhost:8080/products/1"), Product.class);
            Assertions.assertNotEquals(0, result.getProductName().length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}