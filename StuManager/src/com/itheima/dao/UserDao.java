package com.itheima.dao;

//��dao�����˶��û���ķ��ʹ���

public interface UserDao {
	
	
	//����򵥷���boolean���ͣ��ɹ�����ʧ�ܼ���
	//���ǿ�����ʱ�򣬵�¼����һ���ɹ�������Ӧ�÷����û�������Ϣ
	boolean login(String userName, String passWord);
}
