<%@page import="com.locals.social.GoogleConnection"%>
<%@page import="com.locals.social.FBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java Facebook Login</title>
</head>
<body style="text-align: center; margin: 0 auto;">
	<div
		style="margin: 0 auto; background-image: url(./img/fbloginbckgrnd.jpg); height: 360px; width: 610px;">
		<a href="<%=FBConnection.getFBAuthUrl() %>"> <img
			style="margin-top: 138px;" src="./img/facebookloginbutton.png" />
		</a>
	</div>

	<div style="margin: 0 auto;  height: 360px; width: 610px;">
		<a href="<%=GoogleConnection.getGoogleAuthUrl() %>"> <img
			style="margin-top: 138px;" src="./img/googlelogin.png" />
		</a>
	</div>
</body>
</html>
