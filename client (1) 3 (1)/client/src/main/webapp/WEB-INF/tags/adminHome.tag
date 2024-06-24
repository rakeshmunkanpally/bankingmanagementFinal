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
<link href="${pageContext.request.contextPath}/styles/adminHome.css" rel="StyleSheet">
<link href="${pageContext.request.contextPath}/styles/adminTag.css" rel="StyleSheet">
</head>
<body style="background-color:#F0F8FF">
<div class="wrapper" style="margin-top: 0px; background-color:#537887; height: 70px; align-content: center;">
  <div class="bg"> ${heading} </div>
  <div class="fg"> ${heading} </div>
</div>
<nav role="navigation" class="primary-navigation" style="background-image: linear-gradient (0deg, rgba(34,193,195,1) 0%, rgba(45,122,253,1) 100%); height: 70px">
  <ul style="margin: 0; padding-left: 1150px">
    <li style="height: 70px; margin-top: 0px"><a href="#"><img src="${pageContent.request.contextPath}/images/adminProfile.png"  alt="profileImg" height="70px" ></a>
      <ul class="dropdown">
        <li><a href="#">Profile</a></li>
        <li><a href="/bankmanagement/client/admin/logout">Logout</a></li>
      </ul>
    </li>
  </ul>
</nav>
<div style="position:absolute; margin-top: 8%; margin-left: 10%">
<jsp:invoke fragment="content"></jsp:invoke>
</div>
</body>
</html>