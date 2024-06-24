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
<body >
<div class="wrapper" style="margin-top: 1px; background-color:#537887; height: 70px; ">
  <div class="bg" style="color: white; font-size:48px;padding-left:700px"> ${heading} </div>
</div>
<nav role="navigation" class="primary-navigation" style=" height: 100px;z-index: 3;margin-top:20px; ">
  <ul style="padding-left: 500px; font-size:30px;">
  <li style="padding-left: 100px"><a href="./deposit">Deposit</a></li>
			<li style="padding-left: 25px"><a href="./withdraw">Withdraw</a></li>
			<li style="padding-left: 25px"><a href="/bankmanagement/client/user/transfer">Transfer</a></li>
			<li style="padding-left: 25px"><a href="./transactiondetails">Transaction Details</a></li>
			<li style="padding-left: 25px"><a href="./check balance">Check Balance</a></li>	
    <li style="height: 20px; margin-top: 0px"><a href="#"><img src="${pageContent.request.contextPath}/images/adminProfile.png"  alt="profileImg"  style="height:60px; width:50%;margin-top:-5%;"></a>
      <ul class="dropdown">
        <li><a href="#">Profile</a></li>
        <li><a href="/bankmanagement/client/">Logout</a></li>
      </ul>
    </li>
  </ul>
</nav>
<div class="wrapper">
  <div class="bg"> ${heading} </div>
  <div class="fg"> ${heading} </div>
</div>
<div style="position:absolute; margin-top: 3%; margin-left: 10%">
<jsp:invoke fragment="content"></jsp:invoke>
</div>
</body>
</html>