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
			//1.得到链接对象
			conn = JDBCUtil.getConn();
			String sql="select * from t_user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			
			//2.创建ps对象
			ps.setString(1, userName);
			ps.setString(2, passWord);
			
			//3.开始执行
			rs = ps.executeQuery();
			
			//4.如果可以成功移到下一条记录，那么表明有这个用户。
			return rs.next();

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn,ps, rs);
		}
		
		return false;
	}

}
