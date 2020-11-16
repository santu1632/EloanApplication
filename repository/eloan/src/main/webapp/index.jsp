<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>eLoan system</title>
<script type="text/javascript">
 
function validateform(){  
var name=document.myform.name.value;  
var password=document.myform.password.value;  
  
if (name==null || name==""){  
  alert("Name can't be blank");  
  return false;  
}else if(password.length<6){  
  alert("Password must be at least 6 characters long.");  
  return false;  
  }  
}  
</script>  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
	<jsp:include page="header.jsp" />
	<hr />
	<div align=center>
		<h2>eLoan Login application</h2><br>
		
		<%
			String loandetails = (String) request.getAttribute("logoutmsg");
		
			if (loandetails != null && !loandetails.isEmpty()) { %>

				<div align="center" style="Color: red" class="marginTable" data-count="5">
				<label for="amtSac"><%=request.getAttribute("logoutmsg")%> </label>
					
				</div>
	<% }	%>
		<font size=4 face="Verdana" color=#112244 >
			<form method="post" action="validate">

				<%
					if ("User not found, please enter valid credentials..!".equals(request.getAttribute("result"))) {
				%>
				<%=request.getAttribute("result")%>
				<%
					} else {
				%>

				<%
					}
				%>

				<%
					if ("Username and/or Password cannot be empty".equals(request.getAttribute("empty"))) {
				%>
				<%=request.getAttribute("empty")%>
				<%
					} else {
				%>

				<%
					}
				%>
				
				<%
					if ("New User Created Sucessfully".equals(request.getAttribute("result"))) {
				%>
				<%=request.getAttribute("result")%>
				<%
					} else {
				%>

				<%
					}
				%>
				<br>
				<div>
						<label for="username">Enter UserName</label>
						<input type="text" id="username" name="username" maxlength="15"><br><br>

						<label for="password">Enter password</label>
						<input type="password" id="password" name="password" maxlength="15"><br><br>
				</div>
				<div>
					<div class="container">
						<input type="submit" value="Login" class="btn btn-info" role="button">
					</div>
					<div>
						<input type="hidden" id="action" name="action" value="validate"><br>
					</div>
				</div>
				<a href="register.jsp">New User? register here</a>
			</form>
			</font>
	</div>
	<hr />
	<jsp:include page="footer.jsp" />
</body>
</html>