package com.spring.training.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Student {
	String SchoolName;
	int rollNumber;
	Student(){
		logger.info("default constructor");
	}
	Student(String schlName, int roll){
		SchoolName = schlName;
		rollNumber = roll;
	}
	static Logger logger = LoggerFactory.getLogger(Student.class); 

	public static void main(String[] args) {
		logger.info("School Name: "+schoolName()+" Roll no: "+rollNo()+ " Phone no: "+phoneNo()
		+" Id Card: "+idCard());
		Student s1 = new Student();
		s1.playSports();
		Student s2 = new Student("XYZ School",2);
		s2.playSports();
		logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
	}
	
	public static String schoolName() {
		return "ABC School";
	}
	
	private static int rollNo() {
		return 1;
	}
	protected static float phoneNo() {
		return 1234567890;
	}
	static boolean idCard() {
		return true;
	}
	public void playSports() {
		logger.info("Sports Method - School Name: "+SchoolName +"Roll No: "+rollNumber);
	}

}
