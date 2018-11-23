package com.cap.service;

import com.cap.Model.BusPassRequestBean;
import com.cap.Model.LoginBean;

public interface IService {
	
	public boolean isValidUser(LoginBean loginBean);
	public boolean addRequest(BusPassRequestBean busPassRequestBean);

}
