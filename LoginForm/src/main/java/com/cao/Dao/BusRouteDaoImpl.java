package com.cao.Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cap.Model.RouteBean;

public class BusRouteDaoImpl implements IBusRouteDao{

	@Override
	public List<RouteBean> ViewRouteDetails(RouteBean routeBean) {
		List<RouteBean> routeBean1 =new ArrayList();
		String sql ="Select * from route";
		try(
				PreparedStatement pmt = getSqlConnection().prepareStatement(sql);
				){
			ResultSet rs = pmt.executeQuery();
			if(rs.next()) {
				//populate(rs,routeBean);
				routeBean.setRoutePath(rs.getString("route_path"));
				routeBean.setRouteName(rs.getString("routename"));
				routeBean.setOccupied(rs.getInt("occupiedseats"));
				routeBean.setTotalSeats(rs.getInt("total_seats"));
				routeBean.setBusNo(rs.getString("bus_no"));
				routeBean.setDiverName(rs.getString("driver_name"));
				routeBean.setTotalKm(rs.getInt("total_km"));
				
				routeBean1.add(routeBean);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return routeBean1;
	}
	
private void populate(ResultSet rs, RouteBean routeBean) throws SQLException {
	routeBean.getRouteId();
	routeBean.setRoutePath(rs.getString("route_path"));
	routeBean.setRouteName(rs.getString("routename"));
	routeBean.setOccupied(rs.getInt("occupiedseats"));
	routeBean.setTotalSeats(rs.getInt("total_seats"));
	routeBean.setBusNo(rs.getString("bus_no"));
	routeBean.setDiverName(rs.getString("driver_name"));
	routeBean.setTotalKm(rs.getInt("total_km"));
	
		
	}

public Connection getSqlConnection() throws SQLException {
		
		Connection con=null;
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/ravi","root","India123"); 
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}  

		return con;
		
	}

@Override
public boolean AddBusDetails(RouteBean newroute) {
		String sql="insert into route(route_path ,  routename ,occupiedseats,total_seats,bus_no,driver_name,total_km)\r\n" + 
				"values(?,?,?,?,?,?,?)" ; 
				
				try(PreparedStatement pst = getSqlConnection().prepareStatement(sql);){
					pst.setString(1, newroute.getRoutePath());
					pst.setString(2, newroute.getRouteName());
					pst.setInt(3, newroute.getOccupied());
					pst.setInt(4, newroute.getTotalSeats());
					pst.setString(5, newroute.getBusNo());
					pst.setString(6, newroute.getDiverName());
					pst.setDouble(7, newroute.getTotalKm());
					
					int n=pst.executeUpdate();
					System.out.println(n);
					if(n>0) {
						System.out.println(n);
						return true;
					}
		
					
					
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return false;

			} 
		 
}
