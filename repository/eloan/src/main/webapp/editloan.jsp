<%@page import="com.iiht.evaluation.eloan.model.LoanInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Loan Application</title>
<style> 
input {
  width: 25%;
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
</head>
<body>
	<!-- read the application number to edit from user and send to 
	     user controller to edit info
	-->
	<jsp:include page="header.jsp" />
	<div align="right">
		<a href="editloanui.jsp" class="btn btn-info" role="button" >Back to home page</a>
	</div>
	
	<form method="post" action="user">
	<%
		ArrayList<LoanInfo> loanlst = (ArrayList<LoanInfo>) request.getAttribute("loanlst");
	for (LoanInfo loanInfo : loanlst) {
	%>
	
	<fieldset>
	
	
    <legend>Loan Details</legend>
    
    <label for="Application No">Application No</label>
    <input type="text" name="applno" value ="<%=loanInfo.getApplno()%>" readonly/>
     <br/>
     <label for="loan Type">Loan Type</label>
    <input name="loan" list="type-of-loan" value ="<%=loanInfo.getTypeOfLoan()%>" readonly/>
      <datalist id="type-of-loan" > 
        <option value="Commercial">
        <option value="Real Estate">
        <option value="Personal">
        <option value="Mortgage">
      </datalist>
     <br/>
    <label for="loan amount">Loan Amount</label>
    <input type="text" name="amtrequest" value="<%=loanInfo.getAmtrequest()%>" onkeypress="return event.charCode === 0 || /\d/.test(String.fromCharCode(event.charCode))"/>
   <br/>
    <legend>Business struture</legend>
    <input type="radio" name="bstructure" value="<%=loanInfo.getBstructure()%> readonly">Individual
    <input type="radio" name="bstructure" value="<%=loanInfo.getBstructure()%> readonly">Organisation

    <br/>
      
       <legend>Loan Tenure in years</legend>
    <input type="text" name="loanTenure" value="<%=loanInfo.getLoanTenure()%>" onkeypress="return event.charCode === 0 || /\d/.test(String.fromCharCode(event.charCode))"/>
     <br/>
    <legend>Billing Indicator</legend>
    <input type="checkbox" name="bindicator" value="<%=loanInfo.getBindicator()%> readonly">Salaried   
  

     <br/>
    <legend>Tax Indicator</legend>
    <input type="checkbox" name="Taxindicator" value="<%=loanInfo.isTaxindicator()%> readonly">Tax indicator</input>
  
   <br/>
   
    <legend>Basic Information</legend>
    
    <label for="email address">Email</label>
    <input type="text" name="email" value="<%=loanInfo.getEmail()%>" />
    <br/>
    <label for="telephone">Contact Number</label>
    <input type="text" name="mobile" value="<%=loanInfo.getMobile()%>"/>
    <br/>
    <label for="home address">Address</label>
    <input type="text" name="address" value="<%=loanInfo.getAddress()%>"/>
  </fieldset>
  	<div>
			<div><input type="submit" value="Apply" class="btn btn-info" role="button" > </div>
				<div><input type="hidden" id="action" name="action" value="editloan"> </div>
		</div>
</form>
			<%
		}
	%>
	<jsp:include page="footer.jsp" />
</body>
</html>