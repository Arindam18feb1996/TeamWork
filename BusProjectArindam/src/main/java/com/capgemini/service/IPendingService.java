package com.capgemini.service;

import java.time.LocalDate;
import java.util.List;


import com.capgemini.pojo.PassRequestFormPOJO;
import com.capgemini.pojo.TransactionBean;

public interface IPendingService {
	public abstract List<String> PendingReqServlet();
	public List<PassRequestFormPOJO> pendingDetails();
	public abstract List<PassRequestFormPOJO> pendingDetailsOfEmp(String empid);
	public abstract Integer transaction(TransactionBean transaction);
	public List<TransactionBean> monthlyReport(LocalDate fdate, LocalDate tdate);
}
