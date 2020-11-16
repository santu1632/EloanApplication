
<%@page import="com.iiht.evaluation.eloan.model.LoanInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
<meta charset="ISO-8859-1">
<title>Loan Detail Page</title>
h2 {
  border: 5px solid red;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div align="right" class="container">
<a href="userhome.jsp"class="btn btn-info" role="button">Back to home page</a></div>
	<!-- write the code to display the loan status information 
	     received from usercontrollers' displaystatus method 
	-->
	<div align="center">
		<caption>
			<h2>Applied Loan Details</h2>
			<hr />
			<form action="user" method="post">
		</caption>
		<table border="1" cellpadding="5">


			<tr>
				<th>Application No</th>
				<th>Requested Amount</th>
				<th>Status</th>
				<th>Loan Tenure</th>
				<th>Type of Loan</th>
				<th>Date of Application</th>
				<th>Email ID</th>
				<th>Mobile No</th>
				<th>Address</th>
				<th>Tax Indicator</th>
				<th>Billing Indicator</th>
				<th>Business Indicator</th>
				<th>Eligible Amount</th>
				<th>Monthly EMI</th>
				<th>Rate of Interest</th>
				<th>Total Amount Payable</th>
				
			</tr>



			<%
				ArrayList<LoanInfo> loanlst = (ArrayList<LoanInfo>) request.getAttribute("loanlst");
			for (LoanInfo loanInfo : loanlst) {
			%>
			<%-- Arranging data in tabular form 
        --%>

			<tr>

				<td><%=loanInfo.getApplno()%></td>
				<td><%=loanInfo.getAmtrequest()%></td>
				<td><%=loanInfo.getStatus()%></td>
				<td><%=loanInfo.getLoanTenure()%></td>
				<td><%=loanInfo.getTypeOfLoan()%></td>
				<td><%=loanInfo.getDoa()%></td>
				<td><%=loanInfo.getEmail()%></td>
				<td><%=loanInfo.getMobile()%></td>
				<td><%=loanInfo.getAddress()%></td>
				<td><%=loanInfo.isTaxindicator()%></td>
				<td><%=loanInfo.getBindicator()%></td>
				<td><%=loanInfo.getBstructure()%></td>
				<td><%=loanInfo.getAmtEligible()%></td>
				<td><%=loanInfo.getMonthlyPayment()%></td>
				<td><%=loanInfo.getRate_of_Interest()%></td>
				<td><%=loanInfo.getTermPaymentAmount()%></td>

			</tr>
			<%
				}
			%>
		</table>
		<div><input type="hidden" id="action" name="action" value="editLoanProcess"> </div>
	</div>
<hr />	
<jsp:include page="footer.jsp"/>	
</body>
</html>