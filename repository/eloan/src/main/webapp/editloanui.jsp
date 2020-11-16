<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
function validateForm() {
  var x = document.forms["myForm"]["applno"].value;
  if (x == "" || x == null) {
    alert("Application Number should not be Empty or Null");
    return false;
  }
}
</script>
</head>
<body>
<jsp:include page="header.jsp"/>

		<div align="right">
			<a href="userhome.jsp" class="btn btn-info" role="button">Back to
				home page</a>
		</div>

	<form name = "myForm" method="post" action="user" onsubmit="return validateForm()">
	<font size=4 face="Verdana" color=#112244> 
	<div class="container">
		<div align=center>
		<h2>Edit your Loan Application</h2> <br>
		<hr />
		<label> Enter your Application Number:</label>
		<input type="text" name="applno" maxlength="10" onkeypress="return event.charCode === 0 || /\d/.test(String.fromCharCode(event.charCode));" />
		
			
				<input  class="btn btn-info" role="button" type="submit" value="Apply">
			</div>
			
				<%
					if ("Entered Application is either Invalid or Approved or Rejected. Kindly Enter valid Application Number....!".equals(request.getAttribute("result"))) {
				%>
				<%=request.getAttribute("result")%>   
				<%
					} else {
				%>

				<%
					}
				%>
		
		<div><input type="hidden" id="action" name="action" value="editLoanProcess"> </div>
		</div>
		</div>
		</font>
		</form>
<hr />
<jsp:include page="footer.jsp"/>
</body>
</html>