package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Student;

public interface StuDao {
	
	//��ѯ��ѧ����������Ϣ������list����
	List<Student> findAll();
}
