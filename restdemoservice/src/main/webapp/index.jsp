<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<html>
<body>
    <h2>Jersey RESTful Web Application!</h2>
 <!-- author x75l -->
</body>

	<center>
	 	<h1><b><u>WELCOME</u></b></h1>
	
	<form action="http://localhost:8080/restdemoservice/customerdatas/mdm/form" method="post">
	<table >
		<tr><td>Enter First Name</td><td><input type="text" name="firstName"></input></td></tr>
		<tr><td>Enter Last Name</td><td><input type="text" name="lastName"></input></td></tr>
		<tr><td>Source System</td><td><input type="text" name="dataSource"></input></td></tr>
		<tr><td>Select Action</td><td><select name="selection" >
  <option value="fetch"  >Fetch</option>
  <option value="put" >Insert</option></select></td></tr>
	
	</table>
	
	<input type="submit" />
</form>
	</center>
</html>
