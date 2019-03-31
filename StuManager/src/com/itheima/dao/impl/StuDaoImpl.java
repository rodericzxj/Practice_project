package com.itheima.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itheima.dao.StuDao;
import com.itheima.domain.Student;
import com.itheima.uitl.JDBCUtil;

public class StuDaoImpl implements StuDao {

	@Override
	public List<Student> findAll() {

		List<Student> list=new ArrayList<Student>();
		Connection conn = null;
		java.sql.PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			//1.得到链接对象
			conn = JDBCUtil.getConn();
			String sql="select*from t_stu";
			
			//2.创建ps对象
			ps = conn.prepareStatement(sql);
				
			//3.开始执行
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setAge(rs.getInt("age"));
				stu.setName(rs.getString("name"));
				stu.setGender(rs.getString("gender"));
				stu.setAddress(rs.getString("address"));
				list.add(stu);
			}

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn,ps, rs);
		}
		

		return list;
	}

}
