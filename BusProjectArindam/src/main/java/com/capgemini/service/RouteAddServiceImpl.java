package com.capgemini.service;

import com.capgemini.DAO.IRouteAddDAO;
import com.capgemini.DAO.RouteAddDAOImpl;
import com.capgemini.pojo.Routetable;

public class RouteAddServiceImpl implements IRouteAddService {
	IRouteAddDAO routeAddDao=new RouteAddDAOImpl();

	@Override
	public Routetable addRoute(Routetable newroute) {
		if(routeAddDao.addRoute(newroute)!=null) {
			return newroute;
		}
		return null;
	}
	
}
