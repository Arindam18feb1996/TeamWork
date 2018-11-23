package com.capgemini.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.pojo.TransactionBean;
import com.capgemini.service.IPendingService;
import com.capgemini.service.PendingServiceImpl;

@WebServlet("/ApprovedServlet")
public class ApprovedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IPendingService busservice=new PendingServiceImpl();
    public ApprovedServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		Integer route_id=Integer.parseInt(request.getParameter("routeno"));
		Double total_km=Double.parseDouble(request.getParameter("totalkm"));
		Integer total_fare =Integer.parseInt(request.getParameter("totalfare"));
		String empid=request.getParameter("empid");
		LocalDate date=LocalDate.now();
		TransactionBean transaction = new TransactionBean(route_id,empid,date,total_km,total_fare);
		System.out.println(transaction);
		Integer transaction_id = busservice.transaction(transaction);
	
		
		if(transaction_id!= 0) {
			pw.println("Transaction_Id"+transaction_id);
			
			RequestDispatcher rd=request.getRequestDispatcher("pages/TransactionSuccessPage.html");
			rd.include(request, response);
			
		}else {


		
			pw.println("<h1>Transaction Incomplete</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("ListAllPendingRequestsServlet");
			rd.include(request, response);
		}
	}

}
