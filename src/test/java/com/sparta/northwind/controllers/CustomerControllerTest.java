package com.sparta.northwind.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwind.entities.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerTest {

    @Test
    void checkCustomerExists(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Customer result = mapper.readValue(
                    new URL("http://localhost:8080/customers/ALFKI"),Customer.class);
            Assertions.assertNotEquals(0, result.getPhone());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
      @Test
    void extraDummyTest(){
        Assertions.assertEquals(0,0);
    }

}