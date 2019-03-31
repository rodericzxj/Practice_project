package com.itheima.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itheima.dao.UserDao;
import com.itheima.uitl.JDBCUtil;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetRow;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean login(String userName, String passWord) {
		
		Connection conn = null;
		java.sql.PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			//1.�õ����Ӷ���
			conn = JDBCUtil.getConn();
			String sql="select * from t_user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			
			//2.����ps����
			ps.setString(1, userName);
			ps.setString(2, passWord);
			
			//3.��ʼִ��
			rs = ps.executeQuery();
			
			//4.������Գɹ��Ƶ���һ����¼����ô����������û���
			return rs.next();

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn,ps, rs);
		}
		
		return false;
	}

}
