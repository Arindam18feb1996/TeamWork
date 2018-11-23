package com.cap.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cap.Model.BusPassRequestBean;
import com.cap.service.IService;
import com.cap.service.ServiceImpl;



@WebServlet("/PassRequestServlet")
public class PassRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PassRequestServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		IService service = new ServiceImpl();
		String employeeid=request.getParameter("EmployeeId");
		String firstname=request.getParameter("firstName");
		String lastname=request.getParameter("lastName");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String location=request.getParameter("location");
		String doj=request.getParameter("dateOfJoining");
		String pickUpLoc=request.getParameter("pickuplocation");
		String pickUpTime=request.getParameter("pickUpTime");
		String designation=request.getParameter("Designation");
		BusPassRequestBean reqBean=new BusPassRequestBean();
		reqBean.setEmployeeId(employeeid);
		
		reqBean.setFirstName(firstname);
		reqBean.setLastName(lastname);
		reqBean.setGender(gender);
		reqBean.setAddress(address);
		reqBean.setEmail(email);
		reqBean.setPickUpLoc(pickUpLoc);
		reqBean.setLocation(location);
		String[] dpart=doj.split("-");
		
		LocalDate dateofjoininig=LocalDate.of(Integer.parseInt(dpart[0]),Integer.parseInt(dpart[1]), Integer.parseInt(dpart[2]));
		reqBean.setDateOfJoining(dateofjoininig);
		/*
		String[] datepart = doj.split("-");
		LocalDate dateOfJoin=LocalDate.of(Integer.parseInt(datepart[2]),Integer.parseInt(datepart[0]), Integer.parseInt(datepart[1]));*/
		reqBean.setDateOfJoining(dateofjoininig);

		
		String[] tpart=pickUpTime.split(":");
		LocalTime pickuptime=LocalTime.of(Integer.parseInt(tpart[0]),Integer.parseInt(tpart[1]) );
		
		reqBean.setPickUpTime(pickuptime);
		reqBean.setDesignation(designation);
		
		if(service.addRequest(reqBean));{
			System.out.println("Im fine");
		}


}

		
	}

