package com.spring.training.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.training.models.UserHeaders;
/**
 * 
 * @author banda
 *
 */
@RestController
@RequestMapping(value="/Get")
public class MyController {
	

	/**
	 * 
	 * @return
	 */
    @RequestMapping(value = "/getName",method = RequestMethod.GET)
    public String getName() {
    	String name = "yash";
    	return name;
        
    }
    
   // @RequestMapping(value = "/getFirstName", method = RequestMethod.GET)
    @GetMapping(value = "/getFirstName")
    public String getFirstName() {
    	return "firstName";
    }
    /**
     * 
     * @param personName
     * @return
     */
    @RequestMapping(value = "/getNameWithParameters",method = RequestMethod.GET)
    public String getNameWithParameters(@RequestParam(defaultValue = "orange") String personName) {
    	System.out.println(personName);
    	return personName;
        
    }
    
    @RequestMapping(produces = "application/json",value = "/getHttpHeaders",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UserHeaders> getHttpHeaders(@RequestHeader String userAgent,
    		@RequestHeader String accept,
    		@RequestHeader( name = "accept-encoding") String acceptEncoding,
    		@RequestHeader( name = "content-type") String contentType ,
    		@RequestParam(defaultValue = "banana") String data) {
    	UserHeaders uHeader = new UserHeaders();
    	uHeader.setAccept(accept);
    	uHeader.setAcceptEncoding(acceptEncoding);
    	uHeader.setContentType(contentType);
    	
    	System.out.println(userAgent);
    	System.out.println(data);
    	return new ResponseEntity<UserHeaders>(uHeader,HttpStatus.OK);
        
    }
    
}