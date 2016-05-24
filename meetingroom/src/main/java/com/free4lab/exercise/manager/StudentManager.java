package com.free4lab.freemonitor.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.free4lab.freemonitor.model.dao.Student;
import com.free4lab.freemonitor.model.dao.StudentDAO;

public class StudentManager {
	
	private static final Logger logger = Logger.getLogger(StudentManager.class);
	
	public static List<Student> getAllStudent(){
		List<Student> student = new ArrayList<Student>();
		logger.info("findding all students!");
		student = new StudentDAO().findAll();
		return student;
	}
	

}
