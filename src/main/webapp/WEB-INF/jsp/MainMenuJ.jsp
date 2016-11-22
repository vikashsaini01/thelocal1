<%@page import="java.util.Map"%>

<%@page import="com.locals.social.FBConnection"%>
<%@page import="com.locals.social.FBGraph"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String code = request.getParameter("code");
	if (code == null || code.equals("")) {
		throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
	}
	FBConnection fbConnection = new FBConnection();
	String accessToken = fbConnection.getAccessToken(code);

	FBGraph fbGraph = new FBGraph(accessToken);
	String graph = fbGraph.getFBGraph();
	Map<String, String> fbProfileData = fbGraph.getGraphData(graph);
	//ServletOutputStream out = response.getOutputStream();
	out.println("<h1>Facebook Login using Java</h1>");
	out.println("<h2>Application Main Menu</h2>");
	out.println("<div>Welcome " + fbProfileData.get("name"));
	out.println("<div>Your Email: " + fbProfileData.get("email"));
	out.println("<div>You are " + fbProfileData.get("gender"));
%>