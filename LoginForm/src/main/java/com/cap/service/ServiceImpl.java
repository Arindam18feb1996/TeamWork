package com.cap.service;

import com.cao.Dao.ILoginDao;
import com.cao.Dao.LoginDaoImpl;
import com.cap.Model.BusPassRequestBean;
import com.cap.Model.LoginBean;

public class ServiceImpl implements IService{
	
	
	ILoginDao dao = new LoginDaoImpl();

	@Override
	public boolean isValidUser(LoginBean loginBean) {
		
		if(dao.isValidUser(loginBean)) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean addRequest(BusPassRequestBean busPassRequestBean) {
		if(dao.addRequest(busPassRequestBean)) {
			return true;
		}
		return false;
	}
	
	
}
