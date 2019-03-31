package com.itheima.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.itheima.dao.StuDao;
import com.itheima.dao.UserDao;
import com.itheima.dao.impl.StuDaoImpl;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.Student;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //提交的数据有可能有中文，
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1.获取客户端提交的信息
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		
		//2.去访问dao，看看是否满足登录
		
		UserDao dao = new UserDaoImpl();
		boolean isSuccess = dao.login(userName, passWord);
		
		//3.针对dao返回的数据进行回应
		if(isSuccess) {
			
			//1.查询出来所有的学生信息
			StuDao studao = new StuDaoImpl();
			List<Student> list= studao.findAll();
			
			//3.先把集合存到作用域中
			request.getSession().setAttribute("list",list);
			
			//2.重定向
			response.sendRedirect("stu_list.jsp");
		}else {
			response.getWriter().write("用户名或者密码错误");
		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
