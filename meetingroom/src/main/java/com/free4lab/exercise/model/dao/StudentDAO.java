package com.free4lab.freemonitor.model.dao;

import com.free4lab.utils.sql.AbstractDAO;
import com.free4lab.utils.sql.IEntityManagerHelper;
import com.free4lab.utils.sql.entitymanager.NoCacheEntityManagerHelper;

public class StudentDAO extends AbstractDAO<Student>{

	@SuppressWarnings("rawtypes")
	public Class getEntityClass() {
		return Student.class;
	}

	public static final String PU_NAME = "EXERCISEPU";
	public String getPUName() {
		return PU_NAME;
	}

	public IEntityManagerHelper getEntityManagerHelper() {
		return new NoCacheEntityManagerHelper();
	}
	
}
