package com.capgemini.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.capgemini.pojo.Routetable;

public class RouteAddDAOImpl implements IRouteAddDAO {
	
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
	public Routetable addRoute(Routetable newroute) {
		String sql="insert into route_table(route_path,no_of_seats,total_seats,bus_no,driver_name,total_km) values(?,?,?,?,?,?)";
		try(PreparedStatement pst = getSQLConnection().prepareStatement(sql);){
			pst.setString(1, newroute.getRoute_path());
			pst.setInt(2, newroute.getNo_of_seats_occupied());
			pst.setInt(3, newroute.getTotal_seats());
			pst.setString(4, newroute.getBus_no());
			pst.setString(5, newroute.getDriver_name());
			pst.setDouble(6, newroute.getTotal_km());

			int n=pst.executeUpdate();
			System.out.println(n);
			if(n>0) {
				System.out.println(n);
				return newroute;
			}
			else {
				return null;
			}



		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
