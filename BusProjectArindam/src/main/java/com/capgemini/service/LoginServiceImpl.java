package com.capgemini.service;

import com.capgemini.DAO.ILoginDAO;
import com.capgemini.DAO.LoginDAOImpl;
import com.capgemini.pojo.LoginPOJO;

public class LoginServiceImpl implements ILoginService {
	ILoginDAO loginDAO=new LoginDAOImpl();
	@Override
	public boolean checkUser(LoginPOJO loginPOJO) {
		if(loginDAO.checkUser(loginPOJO)) {
			return true;
		}else {
			return false;
	}

}
}
