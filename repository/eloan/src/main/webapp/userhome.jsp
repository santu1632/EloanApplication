<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp"/>
<hr />
<div align="Center" colour = "blue">
<h2>User Dash Board</h2> 
</div>
<div class="container">
<div align="right"><a href="index.jsp"class="btn btn-info" role="button">Logout</a></div> </div>
<font size=4 face="Verdana" color=#112244 >
				<%
					if ("Loan Updated Succesfully..!".equals(request.getAttribute("result"))) {
				%>
				<h4 align="center" style="Color: blue"><%=request.getAttribute("result")%></h4>
				<%
					} else {
				%>

				<%
					}
				%>
				
				<%
					if ("Error Occured while updating loan application..! Please Resubmit the form".equals(request.getAttribute("result"))) {
				%>
				<h4 align="center" style="Color: blue"><%=request.getAttribute("result")%></h4>
				<%
					} else {
				%>

				<%
					}
				%>
				<%
					if ("Loan Applied Sucessfully..!".equals(request.getAttribute("result"))) {
				%>
				<h4 align="center" style="Color: blue"><%=request.getAttribute("result")%></h4>
				<%
					} else {
				%>

				<%
					}
				%>
				
				<%
					if ("Error Occured while Applying loan application..! Please Resubmit the form".equals(request.getAttribute("result"))) {
				%>
				<h4 align="center" style="Color: blue"><%=request.getAttribute("result")%></h4>
				<%
					} else {
				%>

				<%
					}
				%>

<div class="container">
<a href="application.jsp"class="btn btn-info" role="button">Apply for Loan</a>
<a href="trackloan.jsp" class="btn btn-info" role="button">Track Loan Application</a>
<a href="editloanui.jsp" class="btn btn-info" role="button">Edit Loan Application</a> <br>
	
</font>
</div>
<hr />
<jsp:include page="footer.jsp"/>
</body>
</html>