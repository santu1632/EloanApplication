package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iiht.evaluation.eloan.dao.AdminDao;
import com.iiht.evaluation.eloan.dao.ConnectionDao;
import com.iiht.evaluation.eloan.dao.LoanDao;
import com.iiht.evaluation.eloan.dto.LoanDto;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.utility.Constants;


@WebServlet({"/admin","/listall","/process","/callemi","/updatestatus","/logout"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnectionDao connDao;
	
	public void setConnDao(ConnectionDao connDao) {
		this.connDao = connDao;
	}
	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		System.out.println(jdbcURL + jdbcUsername + jdbcPassword);
		this.connDao = new ConnectionDao(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action =  request.getParameter("logaction");
		System.out.println("Action is -->"+action);	
		if(null == action) {
			 action =  request.getParameter("action");
				System.out.println("insid if "+action);	
		}else {
			System.out.println("insid else "+action);	
		}
		
		
		System.out.println(action);
//		String action = "listall";
		System.out.println("Action is -->"+action);	
		String viewName = "";
		try {
			switch (action) {
			case "listall" : 
				viewName = listall(request, response);
				break;
			case "process":
				viewName=process(request,response);
				break;
			case "callemi":
				viewName=calemi(request,response);
				break;
			case "updatestatus":
				viewName=updatestatus(request,response);
				break;
			case "logout":
				viewName = adminLogout(request, response);
				break;	
			default : viewName = "notfound.jsp"; break;		
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);
		
		
	}

	private String updatestatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code for updatestatus of loan and return to admin home page */
		
		return null;
	}
	private String calemi(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
	/* write the code to calculate emi for given applno and display the details */
		String finalView=null;
		System.out.println("INside validat method")	;
		String applno = request.getParameter("applno");
		String amotsanctioned= request.getParameter("amotsanctioned");
		String loanterm = request.getParameter("loanterm");
		String roi = request.getParameter("rateofInterest");
		String actionStatus = request.getParameter("Admin_Action");
		System.out.println("Appl no is =" + applno);
		System.out.println("Action status is =" + actionStatus);
		AdminDao adminDao = new AdminDao();
		
		ArrayList<ApprovedLoan> ApprovedLoanList =adminDao.calLoanEMI(applno, amotsanctioned, loanterm, roi, actionStatus, connDao);
		
				
			request.setAttribute("approvelst", ApprovedLoanList);
			if(null != ApprovedLoanList && !ApprovedLoanList.isEmpty())
			{

			request.setAttribute("loanstatus", Constants.LOAN_STATUS_APPROVED_TEXT);
			}else {
				request.setAttribute("loanstatus", Constants.LOAN_FAILURE_TEXT);
			}
			finalView = "process.jsp";
				
		
		
		return finalView;
	}
	private String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
	/* return to process page */
		String finalView=null;
		System.out.println("INside validat method")	;
		String applno = request.getParameter("applno");
		System.out.println("Appl no is =" + applno);
		System.out.println("Appl no is =" + applno);
		AdminDao adminDao = new AdminDao();
		
		ArrayList<LoanInfo> LoanInfoLst =adminDao.processLoan(applno, connDao);
		request.setAttribute("loanlst", LoanInfoLst);
		
		
		if(!LoanInfoLst.isEmpty()) {
			request.setAttribute("loanlst", LoanInfoLst);
			finalView = "calemi.jsp";
		}
		else {
			System.out.println("No records available for viewing");
			
			request.setAttribute("result", Constants.NO_RECORDS_TOPROCESS);
			finalView = "process.jsp";
		}
		
		return finalView;
	}
	private String adminLogout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write code to return index page */
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		request.setAttribute("logoutmsg", "You are successfullly logout..!!!");
		return "index.jsp";
	}

	private String listall(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	/* write the code to display all the loans */

		String finalView=null;
		System.out.println("INside validat method")	;
		AdminDao adminDao = new AdminDao();
		ArrayList<LoanInfo> LoanInfoLst =adminDao.listAllLoan(connDao);
		request.setAttribute("loanlst", LoanInfoLst);
		

		if(!LoanInfoLst.isEmpty()) {
			request.setAttribute("loanlst", LoanInfoLst);
			finalView = "listall.jsp";
		}
		else {
			System.out.println("No records available for viewing");
			
			request.setAttribute("result", "No records available for viewing !!");
			finalView = "listall.jsp";
		}
		
		return finalView;
	}

	
}