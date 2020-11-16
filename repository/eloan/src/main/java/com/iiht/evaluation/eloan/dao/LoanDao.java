package com.iiht.evaluation.eloan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;
import com.iiht.utility.Utility;

public class LoanDao {

	static Connection currentCon = null;
	static ResultSet rs = null;
	ArrayList<LoanInfo> LoanInfoLst = null;

	public static String placeLoan(LoanInfo loanInfo, ConnectionDao connectionDao, String username) {

		// preparing some objects for connection
		Statement stmt = null;
		String viewName = null;
		String response = null;
		int result = 0;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime dateofapply = LocalDateTime.now();

		System.out.println("date of apply" + format.format(dateofapply));

		String insertQuery = "INSERT INTO `usersdb`.`loanapplication` (`addres`, `email`,`mobile`,`bindicator`, `bstructure`,`amtrequest`,"
				+ "`dateofapply`, `status`,`loanTenure`,`typeOfLoan`,`taxindicator`,`username`) VALUES " + "('"
				+ loanInfo.getAddress() + "','" + loanInfo.getEmail() + "','" + loanInfo.getMobile() + "','"
				+ loanInfo.getBindicator() + "','" + loanInfo.getBstructure() + "','" + loanInfo.getAmtrequest() + "','"
				+ format.format(dateofapply) + "','" + "InProgress" + "','" + loanInfo.getLoanTenure() + "','"
				+ loanInfo.getTypeOfLoan() + "','" + loanInfo.isTaxindicator() + "','" + username + "');";

		// "System.out.println" prints in the console; Normally used to trace the
		// process

		System.out.println("Query: " + insertQuery);

		try {
			// connect to DB

			currentCon = connectionDao.connect();
			System.out.println("currentConection params : " + currentCon);
			stmt = currentCon.createStatement();
			result = stmt.executeUpdate(insertQuery);
			System.out.println("currentConection params : " + result);

			// if user does not exist set the isValid variable to false
//			if (result > 0) {
//				System.out.println("Loan Applied Sucessfully");
//				// bean.setValid(false);
//				viewName = "userhome.jsp";
//			} else {
//
//				System.out.println("Loan not Applied Sucessfully");
//				viewName = "index.jsp";
//			}
			
			if (result > 0) {
				System.out.println("Loan Applied Sucessfully");
				response = "LoanApplied";
			} else {

				System.out.println("Error occured while applying Loan..! Please resubmit again");
				response = "LaonNotApplied";
			}

		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		finally {
			closeConnection(rs, stmt, currentCon);
		}

		return response;
	}

	public static ArrayList<LoanInfo> trackLoan(String applno, ConnectionDao connectionDao, String username) {

		// preparing some objects for connection
		Statement stmt = null;
		LoanInfo loanInfo = new LoanInfo();
		String viewName = null;
		int result = 0;
		int intapplno = Integer.valueOf(applno);
		ArrayList<LoanInfo> LoanInfoLst = null;

		String selectQuery = "Select * from loanapplication where applno=" + intapplno + " AND username='" + username
				+ "';";

		// "System.out.println" prints in the console; Normally used to trace the
		// process

		System.out.println("Query: " + selectQuery);

		try {
			// connect to DB

			currentCon = connectionDao.connect();
			System.out.println("currentConection params : " + currentCon);
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(selectQuery);
			System.out.println("currentConection params : " + result);

			// STEP 5: Extract data from result set
			LoanInfoLst = new ArrayList<LoanInfo>();
			// STEP 5: Extract data from result set
			if (rs != null) {
				while (rs.next()) {
					// Retrieve by column name
					int appNo = rs.getInt("applno");

					String email = rs.getString("email");
					String addres = rs.getString("addres");
					String mobile = rs.getString("mobile");
					String bindicator = rs.getString("bindicator");
					String bstructure = rs.getString("bstructure");
					String amtrequest = rs.getString("amtrequest");
					String dateofapply = rs.getString("dateofapply");
					String status = rs.getString("status");
					String loanTenure = rs.getString("loanTenure");
					String typeOfLoan = rs.getString("typeOfLoan");
					String taxindicator = rs.getString("taxindicator");
					String amtEligible = rs.getString("amtEligible");
					String Rate_of_Interest = rs.getString("Rate_of_Interest");
					String monthlyPayment = rs.getString("monthlyPayment");
					String termPaymentAmount = rs.getString("termPaymentAmount");
					
					System.out.println("currentConection params : " + result);

					// if user does not exist set the isValid variable to false
					// extract othr variabls
					loanInfo = new LoanInfo();

					loanInfo.setApplno(String.valueOf(appNo));
					loanInfo.setEmail(email);
					loanInfo.setAddress(addres);
					loanInfo.setMobile(mobile);
					loanInfo.setBindicator(bindicator);
					loanInfo.setBstructure(bstructure);
					loanInfo.setAmtrequest(Double.valueOf(amtrequest));
					loanInfo.setDoa(dateofapply);
					loanInfo.setStatus(status);
					loanInfo.setLoanTenure(Integer.valueOf(loanTenure));
					loanInfo.setTypeOfLoan(typeOfLoan);
					loanInfo.setTaxindicator(Boolean.valueOf(taxindicator));
					if(null != amtEligible) {
						loanInfo.setAmtEligible(Double.valueOf(amtEligible));
						} else {
						loanInfo.setAmtEligible(0);
						}
					
					if(null != Rate_of_Interest) {
					loanInfo.setRate_of_Interest(Double.valueOf(Rate_of_Interest));
						} else {
							loanInfo.setRate_of_Interest(0);
							}
					
					if(null != monthlyPayment) {
					loanInfo.setMonthlyPayment(Double.valueOf(monthlyPayment));
						} else {
							loanInfo.setMonthlyPayment(0);
							}
					
					if(null != termPaymentAmount) {
					loanInfo.setTermPaymentAmount(Double.valueOf(termPaymentAmount));
						} else {
							loanInfo.setTermPaymentAmount(0);
							}
					
					
					LoanInfoLst.add(loanInfo);
					System.out.println("currentConection params : " + LoanInfoLst);

					// if user does not exist set the isValid variable to false

				}
			}
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		finally {
			closeConnection(rs, stmt, currentCon);
		}

		return LoanInfoLst;
	}

	/*To Update the Loan Details  */
	
	public static ArrayList<LoanInfo> editLoan(String applno, ConnectionDao connectionDao, String username) {

		// preparing some objects for connection
		Statement stmt = null;
		LoanInfo loanInfo = new LoanInfo();
		String viewName = null;
		int result = 0;
		int intapplno = Integer.valueOf(applno);
		ArrayList<LoanInfo> LoanInfoLst = null;

		String selectQuery = "Select * from loanapplication where applno=" 
		+ intapplno 
		+ " AND username='" + username
		+ "' AND status='InProgress" 
		+ "';";

		// "System.out.println" prints in the console; Normally used to trace the
		// process

		System.out.println("Query: " + selectQuery);

		try {
			// connect to DB

			currentCon = connectionDao.connect();
			System.out.println("currentConection params : " + currentCon);
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(selectQuery);
			System.out.println("currentConection params : " + result);

			// STEP 5: Extract data from result set
 			LoanInfoLst = new ArrayList<LoanInfo>();
			// STEP 5: Extract data from result set
			if (rs != null) {
				while (rs.next()) {
					// Retrieve by column name
					int appNo = rs.getInt("applno");

					String email = rs.getString("email");
					String addres = rs.getString("addres");
					String mobile = rs.getString("mobile");
					String bindicator = rs.getString("bindicator");
					String bstructure = rs.getString("bstructure");
					String amtrequest = rs.getString("amtrequest");
					String dateofapply = rs.getString("dateofapply");
					String status = rs.getString("status");
					String loanTenure = rs.getString("loanTenure");
					String typeOfLoan = rs.getString("typeOfLoan");
					boolean taxindicator = rs.getBoolean("taxindicator");

					System.out.println("currentConection params : " + result);

					// if user does not exist set the isValid variable to false
					// extract othr variabls
					loanInfo = new LoanInfo();

					loanInfo.setApplno(String.valueOf(appNo));
					loanInfo.setEmail(email);
					loanInfo.setAddress(addres);
					loanInfo.setMobile(mobile);
					loanInfo.setBindicator(bindicator);
					loanInfo.setBstructure(bstructure);
					if(null != amtrequest) {
					loanInfo.setAmtrequest(Double.valueOf(amtrequest));
					}
					loanInfo.setDoa(dateofapply);
					loanInfo.setStatus(status);
					loanInfo.setLoanTenure(Integer.valueOf(loanTenure));
					loanInfo.setTypeOfLoan(typeOfLoan);
					loanInfo.setTaxindicator(taxindicator);
					System.out.println("taxindicator params : " + taxindicator);
					System.out.println("isTaxindicator  : " + loanInfo.isTaxindicator());
					LoanInfoLst.add(loanInfo);
					System.out.println("currentConection params : " + LoanInfoLst);

					// if user does not exist set the isValid variable to false

				}
			} 
			
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		finally {
			closeConnection(rs, stmt, currentCon);
		}

		return LoanInfoLst;
	}
	
	/* */
	
	public static String updateLoan(String applno, LoanInfo loanInfo, ConnectionDao connectionDao) {

		// preparing some objects for connection
		Statement stmt = null;
		String viewName = null;
		String  response= null;
		int result = 0;
		System.out.println(applno);

		String insertQuery = "UPDATE usersdb.loanapplication SET addres = '" + loanInfo.getAddress()
				+ "', email ='" + loanInfo.getEmail()
				+ "', mobile ='" + loanInfo.getMobile()
				+ "', amtrequest ='" + loanInfo.getAmtrequest()
				+ "', loanTenure =" + loanInfo.getLoanTenure()
				+ " where applno =" + applno
				+ " AND status='InProgress'"
				+ ";";
		// "System.out.println" prints in the console; Normally used to trace the
		// process

		System.out.println("Query: " + insertQuery);

		try {
			// connect to DB

			currentCon = connectionDao.connect();
			System.out.println("currentConection params : " + currentCon);
			stmt = currentCon.createStatement();
			result = stmt.executeUpdate(insertQuery);
			System.out.println("currentConection params : " + result);

			// if user does not exist set the isValid variable to false
			if (result > 0) {
				System.out.println("Loan Updated Sucessfully");
				// bean.setValid(false);
//				viewName = "userhome.jsp";
				response = "LoanUpdated";
			} else {

				System.out.println("Unable to Update loan Sucessfully");
//				viewName = "userhome.jsp";
				response = "ErrorLoanUpdate";
			}

		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		finally {
			closeConnection(rs, stmt, currentCon);
		}

		return response;
	}

	
	public static void closeConnection(ResultSet rs, Statement stmt, Connection currentCon) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
			}
			rs = null;
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
			}
			stmt = null;
		}

		if (currentCon != null) {
			try {
				currentCon.close();
			} catch (Exception e) {
			}

			currentCon = null;
		}

	}

}
