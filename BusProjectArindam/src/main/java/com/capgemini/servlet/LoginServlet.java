package com.capgemini.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.pojo.LoginPOJO;
import com.capgemini.service.ILoginService;
import com.capgemini.service.LoginServiceImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		LoginPOJO loginPOJO=new LoginPOJO(username,userpassword);
		ILoginService loginService = new LoginServiceImpl();
		if(loginService.checkUser(loginPOJO)) {
			response.sendRedirect("pages/AdminHome.html");
		}
		else {
			
			pw.println("You have entered wrong username or password");
            RequestDispatcher rd=request.getRequestDispatcher("index1.html");
            rd.include(request, response);    
		}
	}

}
