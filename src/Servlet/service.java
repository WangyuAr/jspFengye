package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import DB.dbconnection;
import Dao.UserDao;
import Bean.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession; 

public class service extends HttpServlet {

	public service() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		HttpSession session = request.getSession(); 
		UserDao userdao = new UserDao();
		String username = request.getParameter("username");
		List Userlist;
		Userlist = userdao.getalluser(username);
		session.setAttribute("userlist", Userlist);
		for(int i=0;i<Userlist.size();i++)
		   {
			   System.out.println(Userlist.get(i));
			   }
		response.sendRedirect("/Fenyedemo/xianshi.jsp");
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
