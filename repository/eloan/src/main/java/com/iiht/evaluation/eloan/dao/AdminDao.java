package com.iiht.evaluation.eloan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;
import com.iiht.utility.Utility;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminDao {
	

    static Connection currentCon = null;
    static ResultSet rs = null; 
    int rs1 = 0;
	
	 public   ArrayList<LoanInfo>  listAllLoan(ConnectionDao connectionDao) {
	  		
         //preparing some objects for connection 
         Statement stmt = null; 
         String viewName=null;
         int result =0;
         ArrayList<LoanInfo> LoanInfoLst=null;
         LoanInfo  loanInfo= null;
         String selectQuery =
               "Select * from `usersdb`.`loanapplication`";
	    
      // "System.out.println" prints in the console; Normally used to trace the process
    
      System.out.println("Query: "+selectQuery);
	    
      try 
      {
         //connect to DB 
    	 	        
         System.out.println("currentConection params : "+result);
	       
         // if user does not exist set the isValid variable to false
         currentCon = connectionDao.connect();
         System.out.println("currentConection params : "+currentCon);
         stmt=currentCon.createStatement();
         rs = stmt.executeQuery(selectQuery);	     
         System.out.println("currentConection params : "+result);
         
       LoanInfoLst = new ArrayList<LoanInfo>(); 
         //STEP 5: Extract data from result set
         if(rs != null) {
         while(rs.next()){
            //Retrieve by column name
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

            
           //extract othr variabls
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
            
            
            //Display values
            LoanInfoLst.add(loanInfo);
         System.out.println("currentConection params : "+LoanInfoLst);
	       
         // if user does not exist set the isValid variable to false
         }
         
      }
	 }
	       
      catch (Exception ex) 
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
         
      } 
	    
      //some exception handling
      finally 
      {
    	  closeConnection(rs, stmt, currentCon);
      }
      
      return LoanInfoLst;
      }  
	 
	 
	 
      /* Code to fetch the loan details and process */
      
      public   ArrayList<LoanInfo>  processLoan(String applno, ConnectionDao connectionDao) {
	  		
          //preparing some objects for connection 
          Statement stmt = null; 
          String viewName=null;
          int result =0;
          ArrayList<LoanInfo> LoanInfoLst=null;
          LoanInfo  loanInfo= null;
          
          int intapplno = Integer.valueOf(applno);
          String selectQuery =
        		  "Select * from loanapplication where applno=" 
        					+ intapplno 
        					+ " AND status='InProgress" 
        					+ "';";
 	    
       // "System.out.println" prints in the console; Normally used to trace the process
     
       System.out.println("Query: "+selectQuery);
 	    
       try 
       {
          //connect to DB 
     	 	        
          System.out.println("currentConection params : "+result);
 	       
          // if user does not exist set the isValid variable to false
          currentCon = connectionDao.connect();
          System.out.println("currentConection params : "+currentCon);
          stmt=currentCon.createStatement();
          rs = stmt.executeQuery(selectQuery);	     
          System.out.println("currentConection params : "+result);
          
          
          
        LoanInfoLst = new ArrayList<LoanInfo>(); 
          //STEP 5: Extract data from result set
          if(rs != null) {
          while(rs.next()){
             //Retrieve by column name
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

             
            //extract othr variabls
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
             
             
             //Display values
             LoanInfoLst.add(loanInfo);
          System.out.println("currentConection params : "+LoanInfoLst);
 	       
          // if user does not exist set the isValid variable to false
         
 	     
         
          }
          } else {
        	  
          }
       }
       
         

      catch (Exception ex) 
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
         
      } 
	    
      //some exception handling
      finally 
      {
    	  closeConnection(rs, stmt, currentCon);
      }
      
      return LoanInfoLst;
      }

      /* Code to calulate emi an change the status */
      
      public   ArrayList<ApprovedLoan>  calLoanEMI(String applno, String amtEligible,String loanTenure,String roi, String actionStatus, ConnectionDao connectionDao) {
	  		
          //preparing some objects for connection 
          Statement stmt = null; 
          String viewName=null;
          int result =0;
          ArrayList<ApprovedLoan> ApprovedLoanList=null;
          ApprovedLoanList = new ArrayList<ApprovedLoan>();
          ApprovedLoan approvedLoan = null;
          String SactionStatus = actionStatus;
          DecimalFormat two = new DecimalFormat("0.00");
          if (SactionStatus.contains("CalculateEMIAndApprove")) {
        	  int intapplno = Integer.valueOf(applno);
              double intamtEligible = Double.valueOf(amtEligible);
              double intloanTenure  = Double.valueOf(loanTenure);
              double doublelroi = Double.valueOf(roi);
              double roipm = doublelroi/(12*100);
              double TenureMonths = intloanTenure*12;
              DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
       		  LocalDateTime dateofapply = LocalDateTime.now();
      		 
              
              /*Monthly payment amount Calculation */
              double  monthlyPayment = Math.round(((intamtEligible*roipm*Math.pow(1+roipm,TenureMonths))/(Math.pow(1+roipm,TenureMonths)-1))*100)/100;
              
              /*Term payment amount Calculation */
              double  termPaymentAmount  =Math.round((monthlyPayment*TenureMonths)*100)/100;
              System.out.print(" EMI is= "+monthlyPayment+"\n" +"total amt = " + termPaymentAmount);
              
              /*Loan End date Calculation */
             
              
      		 String loanClosureDate = (dateofapply.plusMonths((long) TenureMonths)).format(format); 
              
              
              String insertQuery = "UPDATE usersdb.loanapplication SET amtEligible = " + intamtEligible
    			+ ", Rate_of_Interest =" + doublelroi
    			+ ", loanTenure =" + intloanTenure
    			+ ", monthlyPayment =" + monthlyPayment
    			+ ", termPaymentAmount =" + termPaymentAmount
    			+ ", Loan_closure_Date ='" + loanClosureDate
    			+ "', status='Approved'"
    			+ " where applno =" + applno
    			+ " AND status='InProgress'"
    			+ ";";
           
              System.out.println(insertQuery);
              
      		String selectQuery = "Select * from loanapplication where applno=" 
      				+ applno 
      				+ " AND status='Approved" 
      				+ "';";
   	    
      		
      		System.out.println(selectQuery);
           try 
           {
              //connect to DB 
         	 	        
              System.out.println("currentConection params : "+result);
     	       
              // if user does not exist set the isValid variable to false
              currentCon = connectionDao.connect();
              System.out.println("currentConection params : "+currentCon);
              stmt=currentCon.createStatement();
              System.out.println(insertQuery);
              rs1 = stmt.executeUpdate(insertQuery);	
              System.out.println(selectQuery);
              
              rs = stmt.executeQuery(selectQuery);
             System.out.println("currentConection params : "+rs);
            
              //STEP 5: Extract data from result set
              if(rs != null) {
              while(rs.next()){
                 //Retrieve by column name
            	  int appNo = rs.getInt("applno");
                  
                  String apprAmount = rs.getString("amtEligible");
                  String Rate_of_Interest = rs.getString("Rate_of_Interest");
                  String monthlyEMI = rs.getString("monthlyPayment");
                  String totalPayAmount = rs.getString("termPaymentAmount");
                  String loanStatus = rs.getString("status");
                  String Loan_closure_Date = rs.getString("Loan_closure_Date");
                  
                  
                //extract othr variabls
                  approvedLoan = new ApprovedLoan();
                  approvedLoan.setApplno(String.valueOf(appNo));
                  approvedLoan.setAmotsanctioned(Integer.valueOf(apprAmount));
                  approvedLoan.setEmi(Double.valueOf(monthlyEMI));
                  approvedLoan.setTotalPayableAmount(Double.valueOf(totalPayAmount));
                  approvedLoan.setRateofInterest(Double.valueOf(Rate_of_Interest));
                  approvedLoan.setStatus(loanStatus);
                  approvedLoan.setLcd(Loan_closure_Date);
                  
                  //Display values
                  ApprovedLoanList.add(approvedLoan);
              System.out.println("currentConection params : "+ApprovedLoanList);
     	       
              // if user does not exist set the isValid variable to false
             
     	     
             
              }
              }
           }
           
             

          catch (Exception ex) 
          {
             System.out.println("Log In failed: An Exception has occurred! " + ex);
             
          } 
    	    
          //some exception handling
          finally 
          {
        	  closeConnection(rs, stmt, currentCon);
          }
          
          }  
         else {
        	             
             String insertQuery = "UPDATE usersdb.loanapplication SET status='Rejected'"
   			+ " where applno =" + applno
   			+ " AND status='InProgress'"
   			+ ";";
             
             String selectQuery = "Select * from loanapplication where applno=" 
       				+ applno 
       				+ "' AND status='Rejected" 
       				+ "';";
    
          try 
          {
             //connect to DB 
        	 	        
             System.out.println("currentConection params : "+result);
    	       
             // if user does not exist set the isValid variable to false
             currentCon = connectionDao.connect();
             System.out.println("currentConection params : "+currentCon);
             stmt=currentCon.createStatement();
             stmt.executeUpdate(insertQuery);	     
             rs = stmt.executeQuery(selectQuery);
             System.out.println("currentConection params : "+rs);
             
            //STEP 5: Extract data from result set
             if(rs != null) {
            	 int appNo = rs.getInt("applno"); 
            	 String loanStatus = rs.getString("status");
            	 
            	 approvedLoan = new ApprovedLoan();
                 approvedLoan.setApplno(String.valueOf(appNo));
                 approvedLoan.setStatus(loanStatus);
                 
                 ApprovedLoanList.add(approvedLoan);
                 System.out.println("currentConection params : "+ApprovedLoanList);
             }
          }
          
            

         catch (Exception ex) 
         {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
            
         } 
   	    
         //some exception handling
         finally 
         {
       	  closeConnection(rs, stmt, currentCon);
         } 	
        	 
      }
          return ApprovedLoanList;
      }
	 	 
	 public static void closeConnection(ResultSet rs, Statement stmt, Connection currentCon)
	 {
		 if (rs != null)	{
	            try {
	               rs.close();
	            } catch (Exception e) {}
	               rs = null;
	            }
		
	         if (stmt != null) {
	            try {
	               stmt.close();
	            } catch (Exception e) {}
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
