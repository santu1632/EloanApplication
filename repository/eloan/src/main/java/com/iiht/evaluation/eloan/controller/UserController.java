package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.iiht.evaluation.eloan.dao.UserDao;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;
import com.iiht.utility.Constants;
import com.iiht.utility.Utility;
import com.mysql.cj.xdevapi.Statement;

@WebServlet(urlPatterns = { "/user", "/validate" })
public class UserController extends HttpServlet {
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

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		// String action = "validate";
		System.out.println("Action is -->" + action);
		String viewName = "";
		try {
			switch (action) {
			case "registernewuser":
				viewName = registernewuser(request, response);
				break;
			case "validate":
				viewName = validate(request, response);
				break;
			case "placeloan":
				viewName = placeloan(request, response);
				break;
			case "application1":
				viewName = application1(request, response);
				break;
			case "editLoanProcess":
				viewName = editLoanProcess(request, response);
				break;
			case "registeruser":
				viewName = registerUser(request, response);
				break;
			case "register":
				viewName = register(request, response);
				break;
			case "application":
				viewName = application(request, response);
				break;
			case "trackloan":
				viewName = trackloan(request, response);
				break;
			case "editloan":
				viewName = editloan(request, response);
				break;
			case "displaystatus":
				viewName = displaystatus(request, response);
				break;
			default:
				viewName = "notfound.jsp";
				break;
			}
		} catch (Exception ex) {
			System.out.println("Exception occured: " + ex.getMessage());
			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);
	}

	private String validate(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		/* write the code to validate the user */
		System.out.println("INside validat method");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("UserName :  --" + username);
		System.out.println("password :  --" + password);
		String finalView = "notfound.jsp";
		String result = null;
		if (Utility.isNullOrEmpty(username) || Utility.isNullOrEmpty(password)) {
			System.out.println("Username or password is empty");
			request.setAttribute("empty", "Username and/or Password cannot be empty");
			finalView = "index.jsp";

		} else {
			User objUser = new User();
			objUser.setUsername(username);
			objUser.setPassword(password);
			result = UserDao.validateUser(objUser, connDao);
			HttpSession httpsession = request.getSession();
			httpsession.setAttribute("username", username);

			if (null != result && result.equalsIgnoreCase("validuser")) {
				if (username.equals("Admin") && password.equals("Admin")) {
					System.out.println("You are an Admin User....");
					finalView = "adminhome1.jsp";
				} else {
					System.out.println("you are valid user...!!!!");
					finalView = "userhome.jsp";

				}
			} else {
				if (null != result && result.equalsIgnoreCase("invaliduser")) {
					System.out.println("Sorry, you are not a registered user! Please sign up first");
					request.setAttribute("result", "User not found, please enter valid credentials..!");

					finalView = "index.jsp";
				} else {
				}
			}

		}
		return finalView;
	}

	private String placeloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write the code to place the loan information */
		String finalView = null;
		String result = null;
		System.out.println("INside validat method");
		LoanInfo loanInfo = new LoanInfo();
		String typeofloan = request.getParameter("loan");
		String amtrequest = request.getParameter("amtrequest");
		String bstructure = request.getParameter("bstructure");
		String loanTenure = request.getParameter("loanTenure");
		String bindicator = request.getParameter("bindicator");
		String taxindicator = request.getParameter("Taxindicator");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		// set all the loan fields to loanInfo object
		loanInfo.setTypeOfLoan(typeofloan);
		loanInfo.setAmtrequest(Double.valueOf(amtrequest));
		loanInfo.setEmail(email);
		;
		loanInfo.setMobile(mobile);
		loanInfo.setAddress(address);
		loanInfo.setTaxindicator(Boolean.valueOf(taxindicator));
		loanInfo.setBindicator(bindicator);
		loanInfo.setBstructure(bstructure);
		loanInfo.setTypeOfLoan(typeofloan);
		loanInfo.setLoanTenure(Integer.valueOf(loanTenure));
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		result = LoanDao.placeLoan(loanInfo, connDao, username);
		
		if (null != result && result.equalsIgnoreCase("LoanApplied")) {
			System.out.println("Loan Applied Sucessfully");
			request.setAttribute("result", Constants.LOAN_APPLIED_SUCCESS_TEXT);

			finalView = "userhome.jsp";
			
		} else	{
			if (null != result && result.equalsIgnoreCase("invaliduser")) {
				System.out.println("Error Occured while Applying loan application..! Please Resubmit the form");
				request.setAttribute("result", Constants.LOAN_APPLIED_FAILURE_TEXT);

				finalView = "userhome.jsp";
			} else {
				
				finalView = "notfound.jsp";
			}
			
		}
		
		
		
		return finalView;
	}

	private String application1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write the code to display the loan application page */

		return null;
	}

	private String editLoanProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to edit the loan info */
		String applno = request.getParameter("applno");
		System.out.println("Appl no is =" + applno);
		String finalView = null;
		String result = null;
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (!applno.isEmpty()) {

			LoanDao editLoan = new LoanDao();
			ArrayList<LoanInfo> LoanInfoLst = LoanDao.editLoan(applno, connDao, username);
			
			if(!LoanInfoLst.isEmpty()) {
				request.setAttribute("loanlst", LoanInfoLst);
				finalView = "editloan.jsp";
			}
			else {
				System.out.println("Entered Application is Already Approved or Rejected");
				
				request.setAttribute("result", "Entered Application is either Invalid or Approved or Rejected. Kindly Enter valid Application Number....!");
				finalView = "editloanui.jsp";
			}

		}
		return finalView;
		
	}

	private String registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to redirect page to read the user details */

		return "newuserui.jsp";
	}

	private String registernewuser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/*
		 * write the code to create the new user account read from user and return to
		 * index page
		 */
		/* write the code to validate the user */
		String result = null;
		System.out.println("INside validat method");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email_ID = request.getParameter("email_ID");
		String Mobile_No = request.getParameter("Mobile_No");
		String Address = request.getParameter("Address");
		
		System.out.println("UserName :  --" + username);
		System.out.println("password :  --" + password);
		String finalView = null;
		if (!username.isEmpty() || !password.isEmpty()) {
			User objUser = new User();
			objUser.setUsername(username);
			objUser.setPassword(password);
			objUser.setEmail_ID(email_ID);
			objUser.setMobileNo(Mobile_No);
			objUser.setAddress(Address);
			result = UserDao.registerUser(objUser, connDao);

		}
		
		if (null != result && result.equalsIgnoreCase("UserCreated")) {
			System.out.println("New User Created Sucessfully");
			request.setAttribute("result", Constants.NEW_USER_SUCCESS_TEXT);

			finalView = "index.jsp";
			
		} else	{
			if (null != result && result.equalsIgnoreCase("invaliduser")) {
				System.out.println("New User not Created Sucessfully");
				request.setAttribute("result", Constants.NEW_USER_ERROR_TEXT);

				finalView = "register.jsp";
			} else {
				
				finalView = "notfound.jsp";
			}
			
		}
		return finalView;

	}

	private String register(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write the code to redirect to register page */

		return null;
	}

	private String displaystatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/*
		 * write the code the display the loan status based on the given application
		 * number
		 */

		return null;
	}

	private String editloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write a code to return to editloan page */
		String result = null;
		String applno = request.getParameter("applno");
		System.out.println("Appl no is =" + applno);
		String finalView = null;
		System.out.println("INside validat method");
		LoanInfo loanInfo = new LoanInfo();
		String amtrequest = request.getParameter("amtrequest");
		String bstructure = request.getParameter("bstructure");
		String loanTenure = request.getParameter("loanTenure");
		String bindicator = request.getParameter("bindicator");
		String taxindicator = request.getParameter("Taxindicator");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		// set all the loan fields to loanInfo obje
		loanInfo.setAmtrequest(Double.valueOf(amtrequest));
		loanInfo.setEmail(email);
		loanInfo.setMobile(mobile);
		loanInfo.setAddress(address);
		loanInfo.setTaxindicator(Boolean.valueOf(taxindicator));
		loanInfo.setBindicator(bindicator);
		loanInfo.setBstructure(bstructure);
		loanInfo.setLoanTenure(Integer.valueOf(loanTenure));
		HttpSession session = request.getSession();
		result = LoanDao.updateLoan(applno, loanInfo, connDao);
		
		if (null != result && result.equalsIgnoreCase("LoanUpdated")) {
			System.out.println("Loan Updated Succesfully");
			request.setAttribute("result", Constants.LOAN_UPDATED_SUCCESS_TEXT);

			finalView = "userhome.jsp";
			
		} else	{
			if (null != result && result.equalsIgnoreCase("ErrorLoanUpdate")) {
				System.out.println("Error While Updating Loan Details");
				request.setAttribute("result", Constants.LOAN_UPDATE_ERROR_TEXT);

				finalView = "userhome.jsp";
			} else {
				
				finalView = "notfound.jsp";
			}
			
		}
		return finalView;
		
	}

	private String trackloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write a code to return to trackloan page */
		System.out.println("INside trackloan method");
		String applno = request.getParameter("applno");
		String finalView = "loanDetails.jsp";
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		if (!applno.isEmpty()) {

			LoanDao loanDao = new LoanDao();
			ArrayList<LoanInfo> LoanInfoLst = LoanDao.trackLoan(applno, connDao, username);
			if(null != LoanInfoLst && !LoanInfoLst.isEmpty())
			{
				request.setAttribute("loanlst", LoanInfoLst);

			}else {
				request.setAttribute("loannotfound", Constants.LOAN_NOT_FOUND_TEXT);
				finalView ="trackloan.jsp";

			}
			
		}
		return finalView;

	}

	private String application(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write a code to return to trackloan page */
		return null;
	}
}