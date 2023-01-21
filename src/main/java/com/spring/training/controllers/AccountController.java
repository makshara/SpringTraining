package com.spring.training.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.training.models.Person;
import com.spring.training.services.AccountService;

@RestController
@RequestMapping(value="/Account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
    @GetMapping(value = "/getUserList")
	public String[] getUserList(){
    	String userList[] = {"a","b","c","d","e","f","g","h","i"};
    	return userList;
	}
    
    @GetMapping(value = "/getUsersList")
	public List<String> getUsersList(){
    	List<String> list=new ArrayList<String>(); 
    	list.add("aa");
    	list.add("bb");
    	list.add("cc");
    	return list;
	}
    /**
     * 
     * @param fullName
     * @return
     */
	@PostMapping(value = "/getUserDetails")
    public Person postBody(@RequestBody Person fullName) {
		
        return accountService.getPerson(fullName);
}
}
