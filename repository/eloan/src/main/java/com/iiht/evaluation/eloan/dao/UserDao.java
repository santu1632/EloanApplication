package com.iiht.evaluation.eloan.dao;

import java.text.*;
import java.util.*;

import com.iiht.evaluation.eloan.model.User;

import java.sql.*;

public class UserDao {

	static Connection currentCon = null;
	static ResultSet rs = null;

	public static String validateUser(User userBean, ConnectionDao connectionDao) {

		// preparing some objects for connection
		Statement stmt = null;
		String response = null;

		String searchQuery = "select * from user where username='" + userBean.getUsername() + "' AND password='"
				+ userBean.getPassword() + "'";

		// "System.out.println" prints in the console; Normally used to trace the
		// process
		System.out.println("Your user name is " + userBean.getUsername());
		System.out.println("Your password is " + userBean.getPassword());
		System.out.println("Query: " + searchQuery);

		try {
			// connect to DB

			currentCon = connectionDao.connect();
			System.out.println("currentConection params : " + currentCon);
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			
			// if user does not exist set the isValid variable to false
			 if (!more) {
				System.out.println("Sorry, you are not a registered user! Please sign up first");
				// bean.setValid(false);
				
				response = "invaliduser";
			} else {
				
				System.out.println("you are valid user...!!!!");
				response = "validuser";
				
			}

		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		finally {
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

		return response;
	}

	public static String registerUser(User userBean, ConnectionDao connectionDao) {

		// preparing some objects for connection
		Statement stmt = null;
		String viewName = null;
		String  response= null;
		int result = 0;

		String insertQuery = "INSERT INTO `usersdb`.`user` (`username`, `password`,`email_ID`,`Mobile_No`,`Address`) VALUES " + "('"
				+ userBean.getUsername() + "','" + userBean.getPassword() +"','"
				+ userBean.getEmail_ID() + "','" + userBean.getMobileNo() +"','"
				+ userBean.getAddress() + "');";
	
		// "System.out.println" prints in the console; Normally used to trace the
		// process
		System.out.println("Your user name is " + userBean.getUsername());
		System.out.println("Your password is " + userBean.getPassword());
		System.out.println("Your email is " + userBean.getEmail_ID());
		System.out.println("Your password is " + userBean.getMobileNo());
		System.out.println("Your password is " + userBean.getAddress());
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
				System.out.println("Congrats, New user Created Sucessfully");
				
				response = "UserCreated";
//				viewName = "index.jsp";
			} else {

				System.out.println("User name already exists...!");
//				viewName = "index.jsp";
				response = "ErrorOccured";
			}
			
			

		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		finally {
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

		return response;
	}
}
