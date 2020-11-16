<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Application Form</title>
<script type="text/javascript">
function isNumberKey(txt, evt) {
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode == 46) {
      //Check if the text already contains the . character
      if (txt.value.indexOf('.') === -1) {
        return true;
      } else {
        return false;
      }
    } else {
      if (charCode > 31 &&
        (charCode < 48 || charCode > 57))
        return false;
    }
    return true;
  }

function validateForm() {
var amtrequest = document.forms["myForm"]["amtrequest"].value;
var loanTenure = document.forms["myForm"]["loanTenure"].value;
var mobile = document.forms["myForm"]["mobile"].value;
if ((amtrequest == "" || amtrequest == null) && (loanTenure == "" || loanTenure == null) && (mobile == "" || mobile == null)) {
	alert("Kindly fill the Mandatory fields..!!!!");
	return false;
}
}
p.groove {border-style: groove;}
</script>
<style>
input {
	width: 20%;
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


input:required {
	background-color: #f1f1f1;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<jsp:include page="header.jsp" />
<body onload="myFunction()">
	<p class="groove">
	<form name="myForm" method="post" action="user"
		onsubmit="return validateForm()">

		<div align="right">
			<a href="userhome.jsp" class="btn btn-info" role="button">Back to
				home page</a>
		</div>

		<hr />
		<div align="Center" colour="blue">
			<h1>Apply for the New Loan</h1>
		</div>
		<!--
	write the html code to accept laon info from user and send to placeloan servlet
-->
		<fieldset>
			<legend>Loan Details</legend>

			<label for="loan Type">Loan Type :</label> <input name="loan"
				list="type-of-loan" required />
			<datalist id="type-of-loan">
				<option value="Commercial">
				<option value="Real Estate">
				<option value="Personal">
				<option value="Mortgage">
			</datalist>
			<br />
			<br /> <label for="loan amount">Loan Amount :</label> <input
				type="text" name="amtrequest"
				onkeypress="return event.charCode === 0 || /\d/.test(String.fromCharCode(event.charCode))"
				required /> <br /><br />
			<div align="left">

				<label>Business struture : </label> <br /> <input type="radio"
					name="bstructure" value="Individual">Individual <br /> <input
					type="radio" name="bstructure" value="Organisation">Organisation
			</div>

			<br />
			<br /> <label>Loan Tenure in years :</label> <input type="text"
				name="loanTenure"
				onkeypress="return event.charCode === 0 || /\d/.test(String.fromCharCode(event.charCode))"
				required /> <br />
			<br /> <label>Billing Indicator :</label><br /> <input
				type="checkbox" name="bindicator" value="Salariedperson">Salaried
			<br /> <br /> <label>Tax Indicator :</label><br /> <input
				type="checkbox" name="Taxindicator" value="Taxindicator">Tax
			indicator <br />

			<legend>Basic Information</legend>

			<label for="email address">Email :</label> <input type="text"
				name="email" /> <br /> <br /> <label for="telephone">Contact
				Number :</label> <input type="text" name="mobile" required /> <br /> <br /> <label
				for="home address">Address :</label> <input type="text" name="address" /><br /><br />
		</fieldset>
		<div>
			<div>
				<input type="submit" value="Apply">
			</div>
			<div>
				<input type="hidden" id="action" name="action" value="placeloan">
			</div>
		</div>
	</form>

	<hr />

	<jsp:include page="footer.jsp" />
</body>
</html>