package com.cao.Dao;

import java.util.List;

import com.cap.Model.RouteBean;

public interface IBusRouteDao {
	 public List<RouteBean> ViewRouteDetails(RouteBean routeBean);
	 public boolean AddBusDetails(RouteBean routeBean);

}
