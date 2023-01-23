package com.spring.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.training.entities.Customer;
import com.spring.training.models.Person;
import com.spring.training.models.User;
import com.spring.training.repositories.CustomerRepository;
import com.spring.training.repositories.UserRepository;
import com.spring.training.util.UserOperationUtil;

@Service
public class AccountService {
	
	@Autowired
	private CustomerRepository custRepo;
	@Autowired
	private UserRepository jUserRepo;
	// write a method which takes person object 
	//and returns a person object 
	//by appending fname,lname with "test"
	public Person getPerson(Person fullName){
		
		jUserRepo.batchInsert(UserOperationUtil.userList(), 50);
		
		//jdbc template - user table
		List<User> uList = jUserRepo.findAll();
		System.out.println("User Count="+jUserRepo.count());
		
		System.out.println(custRepo.count());		
		List<Customer> list= custRepo.findAll();
		
		Customer cust = new Customer();
		String fname = fullName.getfName();
		cust.setFirstName(fname);
		String lname = fullName.getlName();
		cust.setLastName(lname);
		cust.setId(UserOperationUtil.getUid());
		custRepo.save(cust);
		
		for(Customer customer : list) {
			//System.out.println(customer.getId()+"----"+customer.getFirstName() +"---- "+customer.getLastName());
			
		}
		String firstName = fullName.getfName();
		String lastName = fullName.getlName();
		Person person = new Person();
		person.setfName(firstName+ "test");
		person.setlName(lastName+ "test");
		return person;
	}
}