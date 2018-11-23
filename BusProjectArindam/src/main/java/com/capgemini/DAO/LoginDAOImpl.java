package com.capgemini.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.pojo.LoginPOJO;

public class LoginDAOImpl implements ILoginDAO  {

	@Override
	public boolean checkUser(LoginPOJO loginPOJO) {
		String sql="select * from adminlogin where username=? and userpassword=?";

		try(PreparedStatement ps =getSQLConnection().prepareStatement(sql);){

			ps.setString(1, loginPOJO.getUsername());
			ps.setString(2, loginPOJO.getPassword());
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				return true;
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;

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
