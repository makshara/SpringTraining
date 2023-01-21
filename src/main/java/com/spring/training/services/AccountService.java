package com.spring.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.training.entities.Customer;
import com.spring.training.models.Person;
import com.spring.training.models.User;
import com.spring.training.repositories.CustomerRepository;
import com.spring.training.repositories.JdbcUserRepository;

@Service
public class AccountService {
	
	@Autowired
	private CustomerRepository custRepo;
	@Autowired
	private JdbcUserRepository jUserRepo;
	// write a method which takes person object 
	//and returns a person object 
	//by appending fname,lname with "test"
	public Person getPerson(Person fullName){
		//jdbc template - user table
		List<User> uList = jUserRepo.findAll();
		System.out.println(uList);
		System.out.println("User Count="+jUserRepo.count());
		
		System.out.println(custRepo.count());		
		List<Customer> list= custRepo.findAll();
		for(Customer customer : list) {
			System.out.println(customer.getId()+""+customer.getFirstName() +"---- "+customer.getLastName());
			
		}
		String firstName = fullName.getfName();
		String lastName = fullName.getlName();
		Person person = new Person();
		person.setfName(firstName+ "test");
		person.setlName(lastName+ "test");
		return person;
	}
}