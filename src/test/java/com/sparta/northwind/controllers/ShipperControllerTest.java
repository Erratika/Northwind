package com.sparta.northwind.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwind.entities.Shipper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class ShipperControllerTest {
    @Test
    void checkShipperExists() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Shipper result = mapper.readValue(new URL("http://localhost:8080/shippers/1"), Shipper.class);
            Assertions.assertNotEquals(0, result.getCompanyName().length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}