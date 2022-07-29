package com.sparta.northwind.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwind.entities.Customer;
import com.sparta.northwind.repositories.CustomerRepository;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;


import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerTest {
    @Autowired
    private CustomerRepository repository;
    @Test
    void checkCustomerExists(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Customer result = mapper.readValue(
                    new URL("http://localhost:8080/customers/ALFKI"),Customer.class);
            Assertions.assertNotEquals(null, result.getPhone());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void checkCreateCustomer(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Customer result = new Customer();
            result.setId("TTCBB");
            result.setCompanyName("Testing Company");
            result.setContactName("Testy McTesterson");
            result.setContactTitle("Testing Lead");

            URL createUrl =  new URL("http://localhost:8080/customers/");
            HttpURLConnection conn = (HttpURLConnection) createUrl.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            /*RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            JSONObject customerJsonObject = new JSONObject();
            HttpEntity<String> request = new HttpEntity<String>(customerJsonObject.toString(), headers);*/

            /*ResponseEntity<String> responseEntityStr = restTemplate.postForEntity(createUrl.toURI(), request, String.class);
            JsonNode root = mapper.readTree(responseEntityStr.getBody());
            Assertions.assertNotNull(responseEntityStr.getBody());
            Assertions.assertNotNull(root.path("name").asText());*/

            /*String resultJsonString = restTemplate.postForObject(createUrl.toURI(), request, String.class);
            JsonNode root = mapper.readTree(resultJsonString);
            Assertions.assertNotNull(resultJsonString);
            Assertions.assertNotNull(root);*/


            Assertions.assertNotEquals(null, result);

            System.out.println(result.getId());
            System.out.println(result.getCompanyName());
            System.out.println(result.getContactTitle());
            System.out.println(result.getContactTitle());




        } catch (IOException e) {
            throw new RuntimeException(e);
        } /*catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }*/
    }

}