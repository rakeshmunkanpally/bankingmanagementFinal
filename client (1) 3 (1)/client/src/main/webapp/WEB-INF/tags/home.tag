<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title" required="true" rtexprvalue="true" %>
<%@ attribute name="heading" required="true" rtexprvalue="true"%>
<%@ attribute name="header" fragment="true" %>
<%@ attribute name="content" fragment="true"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
<jsp:invoke fragment="header"></jsp:invoke>
<link href="https://fonts.googleapis.com/css?family=Arvo&display=swap" rel="stylesheet">

<link href="${pageContext.request.contextPath}/styles/adminTag.css" rel="StyleSheet">
</head>
<body style=" background-color:#F0F8FF">
<div class="wrapper" style="background-color: #537887; height:70px; " >
  <div class="bg" style="background-color: #537887;"> ${heading} </div>
  <div class="fg" style="background-color: #537887;"> ${heading} </div>
</div>
<nav role="navigation" class="primary-navigation" style="background-color: #5F9EA0; height: 70px">
  <ul style="margin-top: 20px; padding-left: 1010px">
    <li style="height: 40px; margin-top: 20px;padding-left: 25px"><a href="/bankmanagement/client/Aboutus">About Us</a></li>
    <li style="height: 40px;padding-left: 25px;"><a href="/bankmanagement/client/Contactus">Contact Us</a></li>
    <li style="height: 40px;padding-left: 25px;"><a href="/bankmanagement/client/help">Help</a></li>
    <li style="height: 40px;"><a href="#">Login &dtrif;</a>
      <ul class="dropdown">
        <li><a href="/bankmanagement/client/admin/login">Admin</a></li>
        <li><a href="/bankmanagement/client/user/login">User</a></li>
      </ul>
    </li>
  </ul>
</nav>

<div style="position:absolute; margin-top: 1%; margin-left: 10%">
<jsp:invoke fragment="content"></jsp:invoke>
</div>
</body>
</html>