package com.mongodb.testMongoProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.testMongoProject.entities.Customer;
import com.mongodb.testMongoProject.repositories.CustomerRepository;

@RestController
@CrossOrigin
//@RequestMapping("/mongo")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping(method= RequestMethod.POST, value="/customers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer addCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
		return customer;
	}
	
	@GetMapping(value = "/customers")
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	@GetMapping(value = "/customers/{id}")
	public Customer getCustomer(@PathVariable String id){
		return customerRepository.findById(id).get();
	}
}
