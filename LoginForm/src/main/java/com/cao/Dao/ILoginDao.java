package com.cao.Dao;

import com.cap.Model.BusPassRequestBean;
import com.cap.Model.LoginBean;

public interface ILoginDao {
	
	public boolean isValidUser(LoginBean loginBean);
	public boolean addRequest(BusPassRequestBean busPassRequestBean);


}
