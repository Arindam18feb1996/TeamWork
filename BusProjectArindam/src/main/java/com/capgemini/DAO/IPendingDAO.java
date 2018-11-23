package com.capgemini.DAO;

import java.time.LocalDate;
import java.util.List;


import com.capgemini.pojo.PassRequestFormPOJO;
import com.capgemini.pojo.TransactionBean;

public interface IPendingDAO {
	public abstract List<String> PendingReqServlet();
	public abstract List<PassRequestFormPOJO> pendingDetails();
	public abstract List<PassRequestFormPOJO> pendingDetailsOfEmp(String empid);
	public abstract Integer transaction(TransactionBean transaction);
	public List<TransactionBean> monthlyReport(LocalDate fdate, LocalDate tdate);
}
