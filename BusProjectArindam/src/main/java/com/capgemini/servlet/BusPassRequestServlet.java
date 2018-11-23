package com.capgemini.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.pojo.PassRequestFormPOJO;
import com.capgemini.service.BusPassRequestServiceImpl;
import com.capgemini.service.IBusPassRequestService;


@WebServlet("/BusPassRequestServlet")
public class BusPassRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IBusPassRequestService busPassRequestService=new BusPassRequestServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empid=request.getParameter("empid");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String emailid=request.getParameter("emailid");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String doj=request.getParameter("doj");
		String location=request.getParameter("location");
		String pickuplocation=request.getParameter("pickuplocation");
		String ptime=request.getParameter("pickuptime");
		String designation=request.getParameter("designation");
		
		
		PassRequestFormPOJO busPassFormPOJO=new PassRequestFormPOJO();
		busPassFormPOJO.setEmployeeid(empid);
		busPassFormPOJO.setFirstname(fname);
		busPassFormPOJO.setLastname(lname);
		busPassFormPOJO.setEmail(emailid);
		busPassFormPOJO.setGender(gender);
		busPassFormPOJO.setAddress(address);
		busPassFormPOJO.setLocation(location);
		busPassFormPOJO.setPickUpLoc(pickuplocation);
		busPassFormPOJO.setDesignation(designation);
		
		String[] dpart=doj.split("-");
		
		LocalDate dateofjoininig=LocalDate.of(Integer.parseInt(dpart[0]),Integer.parseInt(dpart[1]), Integer.parseInt(dpart[2]));
		String[] tpart=ptime.split(":");
		LocalTime pickuptime=LocalTime.of(Integer.parseInt(tpart[0]),Integer.parseInt(tpart[1]) );
		busPassFormPOJO.setDoj(dateofjoininig);
		busPassFormPOJO.setPickUpTime(pickuptime);
		System.out.println(busPassFormPOJO);
		if(busPassRequestService.createRequest(busPassFormPOJO) != null) {
			response.sendRedirect("pages/BusRequestAcknowledge.html");
		}else {			
			PrintWriter pw=response.getWriter();
			pw.println("<h1>Enter valid username and password</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}

	}

}
