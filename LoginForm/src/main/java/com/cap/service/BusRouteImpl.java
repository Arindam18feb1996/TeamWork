package com.cap.service;

import java.util.List;

import com.cao.Dao.BusRouteDaoImpl;
import com.cao.Dao.IBusRouteDao;
import com.cap.Model.RouteBean;

public class BusRouteImpl implements IBusRouteService{

	IBusRouteDao dao= new BusRouteDaoImpl();
	
	@Override
	public List<RouteBean> ViewRouteDetails(RouteBean routeBean) {
		List<RouteBean> routebean = dao.ViewRouteDetails(routeBean);
		return routebean;
	}

	@Override
	public boolean AddBusDetails(RouteBean routeBean) {
		if(dao.AddBusDetails(routeBean)) {
			return true;
		}
		return false;
	}


}
