package com.capgemini.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.pojo.Routetable;

public class RouteListDAOImpl implements IRouteListDAO {
	
	private Connection getSQLConnection()
	{
		Connection con=null;
		try{


			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/capdb","root","India@123");
			return con;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}catch(Exception e1) {
			e1.printStackTrace();
		}

		return con;
	}


	@Override
	public List<Routetable> listAllRoutes() {
		String sql="select * from route_table";
		int routeCount=0;
		try(

				Statement statement=getSQLConnection().createStatement();

				){
			ResultSet resultSet=statement.executeQuery(sql);
			List<Routetable> routeList=new ArrayList<>();
			while(resultSet.next()){
				routeCount++;
				Routetable route=new Routetable();
				route.setRoute_id(resultSet.getInt(1));
				route.setRoute_path(resultSet.getString(2));
				route.setNo_of_seats_occupied(resultSet.getInt(3));
				route.setTotal_seats(resultSet.getInt(4));
				route.setBus_no(resultSet.getString(5));
				route.setDriver_name(resultSet.getString(6));
				route.setTotal_km(resultSet.getDouble(7));
				routeList.add(route);
			}
			if(routeCount>0){
				return routeList;
			}else{
				return null;
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
