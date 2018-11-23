package com.cao.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import com.cap.Model.BusPassRequestBean;
import com.cap.Model.LoginBean;

public class LoginDaoImpl implements ILoginDao{

	@Override
	public boolean isValidUser(LoginBean loginBean) {
		
		
		String sql = "select * from user where name =? and password=?";
		
		try(
				PreparedStatement pmt =getSqlConnection().prepareStatement(sql)
				){
			pmt.setString(1, loginBean.getUserName());
			pmt.setString(2, loginBean.getUserPwd());
			
			ResultSet rs = pmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
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
	public boolean addRequest(BusPassRequestBean busPassRequestBean) {
		
		String sql="insert into BusPassRequest(EmployeeId,firstname,lastname,gender,address,dateofjoin,location,pickuploc,pickuptime,status,email,designation)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try(
				PreparedStatement pmt =getSqlConnection().prepareStatement(sql)
				){
			
			pmt.setString(1, busPassRequestBean.getEmployeeId());
			pmt.setString(2, busPassRequestBean.getFirstName());
			pmt.setString(3, busPassRequestBean.getLastName());
			pmt.setString(4, busPassRequestBean.getGender());
			pmt.setString(5, busPassRequestBean.getAddress());
			pmt.setDate(6, Date.valueOf(busPassRequestBean.getDateOfJoining()));
			pmt.setString(7, busPassRequestBean.getLocation());
			pmt.setString(8, busPassRequestBean.getPickUpLoc());
			pmt.setTime(9, Time.valueOf(busPassRequestBean.getPickUpTime()));
			pmt.setString(10, busPassRequestBean.getStatus());
			pmt.setString(11, busPassRequestBean.getEmail());
			pmt.setString(12, busPassRequestBean.getDesignation());
			
			int n = pmt.executeUpdate();
			if(n>0) {
				return true;
			}
			
			
			
		}catch(SQLException e) {
					e.printStackTrace();
				}
		return false;
	}

}
