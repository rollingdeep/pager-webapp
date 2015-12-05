package com.xch.page.service;

import com.xch.page.dao.JdbcSqlStudentDaoImpl;
import com.xch.page.dao.StudentDao;
import com.xch.page.dao.SublistStudentDaoImpl;
import com.xch.page.model.Pager;
import com.xch.page.model.Student;

public class JdbcSqlStudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	
	public JdbcSqlStudentServiceImpl() {
		studentDao = new JdbcSqlStudentDaoImpl();
	}
	
	public Pager<Student> findStudent(Student searchModel, int pageNum,
			int pageSize) {
		Pager<Student> result= studentDao.findStudent(searchModel, pageNum, pageSize);
		return result;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	
}
