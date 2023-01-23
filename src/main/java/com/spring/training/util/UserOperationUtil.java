package com.spring.training.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.spring.training.models.User;

public class UserOperationUtil {
	public static List<User> userList() {
		
		List<User> l = new ArrayList<User>();
		for(int i =0; i<1000; i++) {
			String uid = getUid();
			String[] uArray = uid.split("-");
			User u = new User(uArray[0],uArray[1],uArray[2]);
			l.add(u);
		}
		return l;
		
	}
	
	public static String getUid() {
		return UUID.randomUUID().toString();
	}
}
