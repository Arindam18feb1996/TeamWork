package com.capgemini.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import com.capgemini.pojo.PassRequestFormPOJO;

public class BusPassRequestDAOImpl implements IBusPassRequestDAO {

	@Override
	public PassRequestFormPOJO createRequest(PassRequestFormPOJO passRequestPOJO) {
		String sql="insert into buspassrequest(EmployeeId,firstname,lastname,gender,address,email,dateofjoin,location,pickuploc,pickuptime,status,designation)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try(PreparedStatement pst = getSQLConnection().prepareStatement(sql);){
			pst.setString(1, passRequestPOJO.getEmployeeid());
			pst.setString(2, passRequestPOJO.getFirstname());
			pst.setString(3, passRequestPOJO.getLastname());
			pst.setString(4, passRequestPOJO.getGender());
			pst.setString(5, passRequestPOJO.getAddress());
			pst.setString(6, passRequestPOJO.getEmail());
			pst.setDate(7, Date.valueOf(passRequestPOJO.getDoj()));
			pst.setString(8, passRequestPOJO.getLocation());
			pst.setString(9, passRequestPOJO.getPickUpLoc());
			pst.setTime(10, Time.valueOf(passRequestPOJO.getPickUpTime()));

			pst.setString(11, passRequestPOJO.getStatus());
			pst.setString(12, passRequestPOJO.getDesignation());

			int count=pst.executeUpdate();
			if(count>0) {
				return passRequestPOJO;
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
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

}
