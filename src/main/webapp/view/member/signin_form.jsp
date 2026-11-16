<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<H2>SIGN-IN FORM</H2>
	
	<a href="/firstpjt/">home</a>
	&nbsp;&nbsp; | &nbsp;&nbsp;
	<a href="/firstpjt/signup.mem">sign-up</a>
	&nbsp;&nbsp; | &nbsp;&nbsp;
	<a href="/firstpjt/signin.mem">sign-in</a>

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