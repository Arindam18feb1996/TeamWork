package com.capgemini.service;

import com.capgemini.pojo.PassRequestFormPOJO;

public interface IBusPassRequestService {
	public abstract PassRequestFormPOJO createRequest(PassRequestFormPOJO busPassPOJO);
}
