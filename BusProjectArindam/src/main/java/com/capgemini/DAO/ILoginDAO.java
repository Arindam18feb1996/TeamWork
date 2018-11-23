package com.capgemini.DAO;

import com.capgemini.pojo.LoginPOJO;

public interface ILoginDAO {
	public abstract boolean checkUser(LoginPOJO loginBean);
}
