package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Student;

public interface StuDao {
	
	//查询出学生的所有信息，返回list集合
	List<Student> findAll();
}
