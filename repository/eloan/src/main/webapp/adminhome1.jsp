<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta charset="ISO-8859-1">
<title>admin home</title>
<script>

function submit(){
	var val=document.admin.logaction.value;
	document.admin.logaction.value=val;

	document.admin.submit();
	
	
}
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr />

<div class="container">
<div align="right"><a href="#" onclick="submit()" class="btn btn-info" role="button">Logout</a></div> </div> 


<div align="Center" colour = "blue">
<h2>Admin Dash Board</h2> </div> 

<form action="admin" method="post" name="admin">
<div class="container">
<a href="process.jsp" class="btn btn-info" role="button">Process Loan Application</a>
<a href="admin?action=listall" class="btn btn-info" role="button">List All Application</a>
<div><input type="hidden" id="action" name="action" value="listall"></div>
<div><input type="hidden" id="logaction" name="logaction" value="logout"></div>
</div>
</form>



<hr />
<jsp:include page="footer.jsp"/>
</body>
</html>