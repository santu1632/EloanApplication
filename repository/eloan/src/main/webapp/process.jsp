<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.iiht.evaluation.eloan.model.ApprovedLoan"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Process Loan Request</title>
<script>
	function validateForm() {
		var x = document.forms["admin"]["applno"].value;
		if (x == "" || x == null) {
			alert("Application Number should not be Empty or Null");
			return false;
		}
	}
function submit(){
	alert("tst");
	var val=document.admin.logaction.value;
	alert(val);
	document.admin.logaction.value=val;

	document.admin.submit();
	
}
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<!-- write the code to read application number, and send it to admincontrollers
	     callemi method to calculate the emi and other details also provide links
	     to logout and admin home page
	-->
	<jsp:include page="header.jsp" />
	<div align="right">
		<a href="adminhome1.jsp" class="btn btn-info" role="button">Back to home page</a>
	</div>
	<div align="Center" colour = "blue">
<h2>Process Loan Application</h2> </div> 
	<hr />

				
		<div align=center>
			
				<form name="admin" method="post" action="admin" onsubmit="return validateForm()">
					<font size=4 face="Verdana" color=#112244> 
					<div  class="container">
					<label for="appNumber">Enter Application Number to process:</label>

					<input type="text" name="applno" onkeypress="return event.charCode === 0 || /\d/.test(String.fromCharCode(event.charCode));" />
					
					<input  class="btn btn-info" role="button" type="submit" value="Apply">
					<input type="hidden" id="action" name="action" value="process">
			
					</div>
					</font>
				</form>
				
			</div>
			
		<%
			ArrayList<ApprovedLoan> approvelst = (ArrayList<ApprovedLoan>) request.getAttribute("approvelst");
		%>

		<%
			if (approvelst != null && !approvelst.isEmpty()) {

			for (ApprovedLoan approvedLoan : approvelst) {
		%>
		<%-- Arranging data in tabular form 
--%>
		<h4 align="center" style="Color: blue"><%=request.getAttribute("loanstatus")%></h4>

		<div align="center" style="Color: blue" class="marginTable" data-count="5" >
		<label for="amtSac">Application No : </label>
			<%=approvedLoan.getApplno()%>
		</div>
		
				<div align="center" style="Color: blue" class="marginTable" data-count="5" >
		<label for="amtSac">Amount Sanctioned : </label>
			<%=approvedLoan.getAmotsanctioned()%>
		</div>
		
				<div align="center" style="Color: blue" class="marginTable" data-count="5" >
		<label for="emiAmt">EMI Amount : </label>
			<%=approvedLoan.getEmi()%>
		</div>
		
				<div align="center" style="Color: blue" class="marginTable" data-count="5" >
		<label for="amtPay">Total Amount Payable : </label>
			<%=approvedLoan.getTotalPayableAmount()%>
		</div>
		
				<div align="center" style="Color: blue" class="marginTable" data-count="5" >
		<label for="amtPay">Loan Closure Date : </label>
			<%=approvedLoan.getLcd()%>
		</div>
		
				<div align="center" style="Color: blue" class="marginTable" data-count="5" >
		<label for="status">Loan Status : </label>
			<%=approvedLoan.getStatus()%>
		</div>

		<%
			}

		} else {
		%>

		<%
			}
		%>


		<%
			if ("Loan application has been rejected..!".equals(request.getAttribute("loanstatus"))) {
		%>
			<h4 align="center" style="Color: blue"><%=request.getAttribute("loanstatus")%></h4>%>
		<%
			} else {
		%>

		<%
			}
		%>
		
		<%
			if ("Application Number entered has already processed or Invalid..!! Kindly enter Another Application Number".equals(request.getAttribute("result"))) {
		%>
			<h4 align="center" style="Color: blue"><%=request.getAttribute("result")%></h4>%>
		<%
			} else {
		%>

		<%
			}
		%>
		
		<hr />
		<jsp:include page="footer.jsp" />
</body>
</html>