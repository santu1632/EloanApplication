<%@page import="com.iiht.evaluation.eloan.model.LoanInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Approve Loan Request</title>
<SCRIPT language=Javascript>
       function isNumberKey(txt, evt) {
    	      var charCode = (evt.which) ? evt.which : evt.keyCode;
    	      if (charCode == 46) {
    	        //Check if the text already contains the . character
    	        if (txt.value.indexOf('.') === -1) {
    	          return true;
    	        } else {
    	          return false;
    	        }
    	      } else {
    	        if (charCode > 31 &&
    	          (charCode < 48 || charCode > 57))
    	          return false;
    	      }
    	      return true;
    	    }
       
       function validateForm() {
		var x = document.forms["myForm"]["rateofInterest"].value;
		if (x == "" || x == null) {
			alert("Rate of Interest Should not be null or Empty");
			return false;
		}
	}
  </SCRIPT>
<style> 
input {
  width: 20%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
}

  input[type=submit] {
  background-color: #4CAF50;
  color: white;
}
.container {
  background-color: #f1f1f1;
  padding: 20px;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
 <!--
     Read the values from the admin servlet and cal emi and other details and send to
     to the same admin servlet to update the values in the database 
  -->  
<jsp:include page="header.jsp" />
	<div align="right">
		<a href="adminhome1.jsp" class="btn btn-info" role="button">Back to home page</a>
	</div>
	
	<form name="myForm" method="post" action="admin" onsubmit="return validateForm()">
	<%
		ArrayList<LoanInfo> loanlst = (ArrayList<LoanInfo>) request.getAttribute("loanlst");
	for (LoanInfo loanInfo : loanlst) {
	%>
	
	<fieldset>
	
	
    <legend>Loan Details</legend>
    
    <label for="Application No">Application No :</label>
    <input type="text" name="applno" value ="<%=loanInfo.getApplno()%>" readonly/>
     <br/>  <br/>
     <label for="loan Type">Loan Type :</label>
    <input name="loan" list="type-of-loan" value ="<%=loanInfo.getTypeOfLoan()%>" readonly/>
      <datalist id="type-of-loan" > 
        <option value="Commercial">
        <option value="Real Estate">
        <option value="Personal">
        <option value="Mortgage">
      </datalist>
     <br/> <br/>
    <label for="loan amount">Requested Loan Amount :</label>
    <input type="text" name="amtrequest" value="<%=loanInfo.getAmtrequest()%>" readonly />
   
    <br/><br/>
      
       <label>Requested Loan Tenure in years :</label><br/>
    <input type="text" name="loanTenure" value="<%=loanInfo.getLoanTenure()%>" readonly/>
     <br/><br/>
    <label>Billing Indicator :</label> <br/>
    <input  type="checkbox" name="bindicator" value="<%=loanInfo.getBindicator()%>" readonly>Salaried   
 
     <br/>
    <label>Tax Indicator :</label> <br/>
    <input type="checkbox" name="Taxindicator" value="<%=loanInfo.isTaxindicator()%>" readonly>Tax indicator</input>
  
   <br/>
   	
    <legend>Basic Information :</legend>
    
    <label for="email address">Email :</label>
    <input type="text" name="email" value="<%=loanInfo.getEmail()%>" readonly />
    <br/><br/>
    <label for="telephone">Contact Number :</label>
    <input type="text" name="mobile" value="<%=loanInfo.getMobile()%>" readonly/>
    <br/><br/>
    <label for="home address">Address :</label>
    <input type="text" name="address" value="<%=loanInfo.getAddress()%>" readonly/>

  </fieldset>
  
  <legend>Calculate EMI</legend>
  
  	<fieldset>
  	<br/>
    <label for="loan amount">Eligible Loan Amount</label>
    <input type="text" name="amotsanctioned" value="<%=loanInfo.getAmtrequest()%>" onkeypress="return event.charCode === 0 || /\d/.test(String.fromCharCode(event.charCode))"/>
    <br/>
        
    <br/>
    <label for="Rate of Interest">Rate of Interest</label>
    <input type="text" name="rateofInterest" maxlength="10" onkeypress="return isNumberKey(this, event);"/>
    <br/>
    
    <br/>
    <label for="Approved Loan Term">Approved Loan Term</label>
    <input type="text" name="loanterm" value="<%=loanInfo.getLoanTenure()%>" onkeypress="return event.charCode === 0 || /\d/.test(String.fromCharCode(event.charCode))">
    <br/>
    
    </fieldset>
  	<div>	
  	<br/>
  	<label for="Admin_Action">Select a Action:</label>
	<select id="Admin_Action" name="Admin_Action">
  	<option value="CalculateEMIAndApprove">Calculate EMI and Approve</option>
  	<option value="Reject">Reject</option>
	</select>
     <br/>
     
			<div><input type="submit" value="Submit"> </div>
			<div><input type="hidden" id="action" name="action" value="callemi"> </div>
		</div>
</form>
			<%
		}
	%>
	
	
</body>
</html>