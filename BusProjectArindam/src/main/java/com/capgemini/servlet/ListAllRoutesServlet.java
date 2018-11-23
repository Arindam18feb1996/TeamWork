package com.capgemini.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.pojo.Routetable;
import com.capgemini.service.IRouteListService;
import com.capgemini.service.RouteListServiceImpl;

@WebServlet("/ListAllRoutesServlet")
public class ListAllRoutesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRouteListService routeListService=new RouteListServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		List<Routetable>routes = routeListService.listAllRoutes();
		PrintWriter out = response.getWriter();
		out.println("<h3>All Route Details</h3>"
				+"<table border=2>"
				+"<tr>"
				+"<th>RouteId</th>"
				+"<th>RoutePath</th>"
				+"<th>Total Seats</th>"
				+"<th>BusNo.</th>"
				+"<th>Driver Name</th>"
				+"<th>Total Km</th>"
				+"</tr>");
		for(Routetable route:routes) {
			out.println("<tr>"
					+"<td>"+route.getRoute_id()+"</td>"
					+"<td>"+route.getRoute_path()+"</td>"					
					+"<td>"+route.getTotal_seats()+"</td>"
					+"<td>"+route.getBus_no()+"</td>"
					+"<td>"+route.getDriver_name()+"</td>"
					+"<td>"+route.getTotal_km()+"</td>"
					+"</tr>");	
		}
	}

}
