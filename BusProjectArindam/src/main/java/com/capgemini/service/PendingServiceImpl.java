package com.capgemini.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.DAO.IPendingDAO;
import com.capgemini.DAO.PendingDAOImpl;
import com.capgemini.pojo.PassRequestFormPOJO;
import com.capgemini.pojo.TransactionBean;

public class PendingServiceImpl implements IPendingService {

	IPendingDAO pendingDAO=new PendingDAOImpl();
	@Override
	public List<String> PendingReqServlet() {
		List<String> list=new ArrayList<>();
		list=pendingDAO.PendingReqServlet();
		return list;
	}
	@Override
	public List<PassRequestFormPOJO> pendingDetails() {
		List<PassRequestFormPOJO> pendingList=pendingDAO.pendingDetails();
		if(pendingList!=null)
			return pendingList;
		
		return null;

	}
	@Override
	public List<PassRequestFormPOJO> pendingDetailsOfEmp(String empid) {
		List<PassRequestFormPOJO> pendingList=pendingDAO.pendingDetailsOfEmp(empid);
		if(pendingList!=null)
			return pendingList;
		return null;
	}
	@Override
	public Integer transaction(TransactionBean transaction) {
		Integer transaction_id=pendingDAO.transaction(transaction);
		return transaction_id;
	}
	@Override
	public List<TransactionBean> monthlyReport(LocalDate fdate, LocalDate tdate) {
		List<TransactionBean> tBean=pendingDAO.monthlyReport(fdate, tdate);
		if(tBean!=null)
			return tBean;
		return null;
	}

}
