package com.mongodb.testMongoProject.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.testMongoProject.entities.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{

}
