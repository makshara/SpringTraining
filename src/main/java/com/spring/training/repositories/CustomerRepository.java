package com.spring.training.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.training.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String>{
	List<Customer> findByLastName(String lastName);

	  List<Customer> findAll();
}
