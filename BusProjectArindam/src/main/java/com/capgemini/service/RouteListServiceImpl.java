package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.DAO.IRouteListDAO;
import com.capgemini.DAO.RouteListDAOImpl;
import com.capgemini.pojo.Routetable;



public class RouteListServiceImpl implements IRouteListService {
 IRouteListDAO routeListDAO=new RouteListDAOImpl();
	@Override
	public List<Routetable> listAllRoutes() {
		List<Routetable> routeList=new ArrayList<>();
		routeList = routeListDAO.listAllRoutes();
		return routeList;
	}

}
