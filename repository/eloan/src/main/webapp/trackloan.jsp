<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	function validateForm() {
		var x = document.forms["myForm"]["applno"].value;
		if (x == "" || x == null) {
			alert("Application Number should not be Empty or Null");
			return false;
		}
	}
	
function submit(){
	
	document.getElementById("action").value ="logout";
	
}
</script>
<style type="text/css">
input {
  width: 10%;
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

}

</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"  />
		<div align="right">
			<a href="userhome.jsp" class="btn btn-info" role="button">Back to
				home page</a>
		</div>
	<hr />
	<div align=Center>
	<h2 >Track Your Loan Application </h2><br>
	</div>
	<div align=center>
		<font size=4 face="Verdana" color=#112244> <!-- write html code to read the application number and send to usercontrollers'
             displaystatus method for displaying the information
	-->
	
	<%
			String loandetails = (String) request.getAttribute("loannotfound");
		
			if (loandetails != null && !loandetails.isEmpty()) { %>

				<div align="left" style="Color: grey" class="marginTable" data-count="5">
				<label for="amtSac"><%=request.getAttribute("loannotfound")%> </label>
					
				</div>
	<% }	%>
			<form name="myForm" method="post" action="user" onsubmit="return validateForm()">

				<label>Enter your Application Number:</label>
				<input type="text" name="applno" maxlength="10"
					onkeypress="return event.charCode === 0 || /\d/.test(String.fromCharCode(event.charCode));" required/>
					<input type="submit" value="Apply">
						</div>
					
					
				<br /> </legend>
				<div>
					
					<div>
						<input type="hidden" id="action" name="action" value="trackloan">
					</div>

				</div> 
	</div>
	</form>
	<hr />
	<jsp:include page="footer.jsp" />
</body>
</html>