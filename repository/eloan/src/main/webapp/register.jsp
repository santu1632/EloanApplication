<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register New User</title>
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
<jsp:include page="header.jsp"/>
<hr/>
<div align=center>
	<h2>Please Register here to apply Loan</h2>
	<form action="user" method="post">
			<font size=4 face="Verdana" color=#112244>
			
			<%
					if ("Error Occured while creating New User. Please Resubmit the form".equals(request.getAttribute("result"))) {
				%>
				<%=request.getAttribute("result")%>
				<%
					} else {
				%>

				<%
					}
				%>
				<div>
						<label for="username">Enter UserName</label>
						<input type="text" id="username" name="username" maxlength="25" required><br><br>

						<label for="password">Enter password</label>
						<input type="password" id="password" name="password" maxlength="15" required><br><br>
						
						<label for="email_ID">Enter Email ID</label>
						<input type="text" id="email_ID" name="email_ID" maxlength="25"  required><br><br>
						
						<label for="Mobile_No">Enter Mobile No</label>
						<input type="text" id="Mobile_No" name="Mobile_No" maxlength="10" onkeypress="return event.charCode === 0 || /\d/.test(String.fromCharCode(event.charCode))" required ><br><br>
						
						<label for="Address">Enter Address</label>
						<input type="text" id="Address" name="Address" maxlength="100" required><br><br>
				</div>
				<div>
					<div class="container">
						<input type="submit" value="Register" class="btn btn-info" role="button">
					</div>
					<div><input type="hidden" id="action" name="action" value="registernewuser"> </div>
			</div>
			</font>
	 </form>
	</div>	 
<hr/>
<jsp:include page="footer.jsp"/>
</body>
</html>