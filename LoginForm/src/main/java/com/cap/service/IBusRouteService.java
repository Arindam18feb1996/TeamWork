package com.cap.service;

import java.util.List;

import com.cap.Model.RouteBean;

public interface IBusRouteService {
	
	

	 public List<RouteBean> ViewRouteDetails(RouteBean routeBean);
	 public boolean AddBusDetails(RouteBean routeBean);

}
