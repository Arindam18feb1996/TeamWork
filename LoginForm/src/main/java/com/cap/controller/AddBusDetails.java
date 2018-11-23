package com.cap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cap.Model.RouteBean;
import com.cap.service.BusRouteImpl;
import com.cap.service.IBusRouteService;


@WebServlet("/AddBusDetails")
public class AddBusDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddBusDetails() {
        super();
       
    }
    IBusRouteService service = new BusRouteImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String busPath= request.getParameter("route_path");
		String routeName = request.getParameter("routename");
		String Occupiedseats= request.getParameter("occupiedseats");
		String total_seats = request.getParameter("total_seats");
		String bus_no = request.getParameter("bus_no");
		String driver_name = request.getParameter("driver_name");
		String total_km = request.getParameter("total_km");
		
		 RouteBean routeBean = new RouteBean();
		 routeBean.setRoutePath(busPath);
		 routeBean.setRouteName(routeName);
		 routeBean.setOccupied(Integer.parseInt(Occupiedseats));
		 routeBean.setTotalSeats(Integer.parseInt(total_seats));
		 routeBean.setBusNo(bus_no);
		 routeBean.setDiverName(driver_name);
		 routeBean.setTotalKm(Integer.parseInt(total_km));
		 if(service.AddBusDetails(routeBean)) {
			 response.sendRedirect("succuss.html");
		 }else response.sendRedirect("failed.html");
		 
		
		
		
	}

}
