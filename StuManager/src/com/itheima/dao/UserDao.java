package com.itheima.dao;

//该dao定义了对用户表的访问规则

public interface UserDao {
	
	
	//这里简单返回boolean类型，成功或者失败即可
	//但是开发的时候，登录方法一旦成功，这里应该返回用户个人信息
	boolean login(String userName, String passWord);
}
