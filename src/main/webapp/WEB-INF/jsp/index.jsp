<%@page import="com.locals.social.FBConnection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Local's</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
</head>
<body>
	<div>
		<form:form method="post" modelAttribute="Task" action="/addtask">
			<form:input type="text" path="summary" />
			<form:input type="text" path="description" />
			<form:button type="submit" > Submit </form:button>
		</form:form>
	</div>
</body>
</html>