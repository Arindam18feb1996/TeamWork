package com.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cap.Model.LoginBean;
import com.cap.service.IService;
import com.cap.service.ServiceImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
       
    }
    	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html"); 
		
		
		
		
		response.setContentType("text/html");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		
		LoginBean loginBean = new  LoginBean(userName,userPwd);
		IService service = new ServiceImpl();
		
		if(service.isValidUser(loginBean)) {
			response.sendRedirect("pages/Response.html");
			
		}else {
			PrintWriter out = response.getWriter();
			out.println("Invalid User name and password");
			 RequestDispatcher rd=request.getRequestDispatcher("index.html");  
		        rd.include(request, response);
		        
			
			
		}
		
	}

}
