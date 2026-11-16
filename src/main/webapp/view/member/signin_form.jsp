<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/title.jsp"/>
</head>
<body>

	<h2>SIGN-IN FORM</h2>
	
	<jsp:include page="../include/nav.jsp" />

	<br></br>
	
	<form action="/firstpjt/signin_confirm.mem" method="post">
		<input type="text" name="memId" placeholder="Input member ID!">
		<br>
		<input type="password" name="memPw" placeholder="Input member PW!">
		<br>
		<input type="submit" value="SINGIN">
		<input type="reset" value="RESET">
	</form>
	
	
</body>
</html>