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
		 //�ύ�������п��������ģ�
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1.��ȡ�ͻ����ύ����Ϣ
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		
		//2.ȥ����dao�������Ƿ������¼
		
		UserDao dao = new UserDaoImpl();
		boolean isSuccess = dao.login(userName, passWord);
		
		//3.���dao���ص����ݽ��л�Ӧ
		if(isSuccess) {
			
			//1.��ѯ�������е�ѧ����Ϣ
			StuDao studao = new StuDaoImpl();
			List<Student> list= studao.findAll();
			
			//3.�ȰѼ��ϴ浽��������
			request.getSession().setAttribute("list",list);
			
			//2.�ض���
			response.sendRedirect("stu_list.jsp");
		}else {
			response.getWriter().write("�û��������������");
		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
