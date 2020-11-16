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
<script>
function submit(){
	var val=document.admin.logaction.value;

	document.admin.logaction.value=val;

	document.admin.submit();
	
}
</script>
<meta charset="ISO-8859-1">
<title>Display All Loans</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr />
<div class="container">
<div align="right">
<a href="#" onclick="submit()" class="btn btn-info" role="button">Logout</a>
<a href="adminhome1.jsp" class="btn btn-info" role="button">Admin Home Page</a>
</div></div>
	<!-- write code to display all the loan details 
             which are received from the admin controllers' listall method
	-->
	<form action="admin" method="post" name="admin">
	<div align="center">
		<caption>
			<h2>List of Applications</h2>
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
			</tr>



			<%ArrayList<LoanInfo> loanlst =  
            (ArrayList<LoanInfo>)request.getAttribute("loanlst"); 
        for(LoanInfo loanInfo : loanlst){%>
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


			</tr>
			<%}%>
		</table>
		<%
					if ("No records available for viewing !!".equals(request.getAttribute("result"))) {
				%>
				<%=request.getAttribute("result")%>   
				<%
					} else {
				%>

				<%
					}
				%>
			<div><input type="hidden" id="logaction" name="logaction" value="logout"></div>
	</div>
	</form>
	<hr />
<jsp:include page="footer.jsp"/>
</body>
</html>