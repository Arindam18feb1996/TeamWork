package com.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cap.Model.RouteBean;
import com.cap.service.BusRouteImpl;
import com.cap.service.IBusRouteService;


@WebServlet("/BusRouteServlet")
public class BusRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IBusRouteService service = new BusRouteImpl();
    public BusRouteServlet() {
        super();

    }

RouteBean routeBean = new RouteBean();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RouteBean routeBean = new RouteBean();
	    PrintWriter out = response.getWriter(); 
		response.setContentType("text/html");
		
		List<RouteBean> route = service.ViewRouteDetails(routeBean);
		
		System.out.println(route);
		
		out.println("<h3>All Route Details</h3>"
						+"<html>"
						+"<body>"
						+"<table>"
						+"<tr>"
						+"<th>RouteId</th>"
						+"<th>RoutePath</th>"
						+"<th>No.Of Seats Occupied</th>"
						+"<th>Total Seats</th"
						+"<th>BusNo.</th>"
						+"<th>Driver Name</th>"
						+"<th>Total Km</th>"
						+"</tr>");
				for(RouteBean route1:route) {
					out.println("<tr>"
							+"<td>"+route1.getRouteId()+"</td>"
							+"<td>"+route1.getRoutePath()+"</td>"
							+"<td>"+route1.getRouteName()+"</td>"
							+"<td>"+route1.getTotalSeats()+"</td>"
							+"<td>"+route1.getBusNo()+"</td>"
							+"<td>"+route1.getDiverName()+"</td>"
							+"<td>"+route1.getTotalKm()+"</td>"
							+"</tr>"
							+"</body>"+"</html>");
		
		
				}
	}

}
