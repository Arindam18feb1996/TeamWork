package com.capgemini.service;

import com.capgemini.DAO.BusPassRequestDAOImpl;
import com.capgemini.DAO.IBusPassRequestDAO;
import com.capgemini.pojo.PassRequestFormPOJO;

public class BusPassRequestServiceImpl implements IBusPassRequestService {

	IBusPassRequestDAO busPassRequestDAO=new BusPassRequestDAOImpl();
	@Override
	public PassRequestFormPOJO createRequest(PassRequestFormPOJO busPassPOJO) {
		if(busPassRequestDAO.createRequest(busPassPOJO) != null)
			return busPassPOJO;
      return null;
	}

}
