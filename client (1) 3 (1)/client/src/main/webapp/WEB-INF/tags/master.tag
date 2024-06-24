<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="heading" required="true" rtexprvalue="true"%>
<%@ attribute name="header" fragment="true"%>
<%@ attribute name="content" fragment="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Arvo&display=swap" rel="stylesheet">

<link href="${pageContext.request.contextPath}/styles/adminTag.css" rel="StyleSheet">
<link rel="icon" type="image/x-icon" href="/images/phoenixlogo.png">
<style>
footer {
            background-color:#5F9EA0 ;
            padding: 10px;
            text-align: center;
            color: #fff;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
          p {
            line-height: 1.6;
        }
        #logo{
        
        
        }
        .color-burn {
    mix-blend-mode: color-burn;
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
}

/* Adjust the opacity of the color-burn layer to control the intensity of the effect */
.color-burn {
    opacity: 2; /* Adjust the opacity value as needed */
}
</style>
<jsp:invoke fragment="header"></jsp:invoke>
<title>${title}</title>
</head>
<body style="background-color:#F0F8FF">
<div class="wrapper" style="margin-top: 0px; background-color:#537887; height: 70px; align-content: center; width: 100%">
  <div class="bg"> ${heading} </div>
  <div class="fg"> ${heading} </div>
</div>
<div style="position:absolute;left:0px;width:100%;height:1%; top:-1%;background-color:white;  ">
<nav role="navigation" class="primary-navigation" style="background-color: #5F9EA0; height: 70px ;">
  <ul style="margin-top: 100px;">
  <li style="height: 40px; margin-top: 0px;"><img src="${pageContext.request.contextPath}/images/phoenixlogo.png" alt="profileImg" style="height:70px; width:70px ;" id="logo" class="color-burn"></li>
  <li style="height: 40px; margin-top: 20px;padding-left: 1010px"><a href="/bankmanagement/client/home">Home Page</a></li>
    <li style="height: 40px; margin-top: 20px;padding-left: 25px"><a href="/bankmanagement/client/Aboutus">About Us</a></li>
    <li style="height: 40px; margin-top: 20px;padding-left: 25px;"><a href="/bankmanagement/client/Contactus">Contact Us</a></li>
    <li style="height: 40px;margin-top: 20px;padding-left: 25px;"><a href="/bankmanagement/client/help">Help</a></li>
    <li style="height: 40px;margin-top: 20px;padding-left: 25px;"><a href="#">Login &dtrif;</a>
    <%-- <a href="#"></a> --%>
      <ul class="dropdown" style="z-index: 1; max-width: 10px">
        <li style="padding-left: 25px;max-width: 10px"><a href="/bankmanagement/client/admin/login">Admin</a></li>
        <li style="padding-left: 25px;"><a href="/bankmanagement/client/user/login">User</a></li>
      </ul>
    </li>
  </ul>
</nav>
		</div>
<div style="position:absolute; margin-top:5%;">
<jsp:invoke fragment="content"></jsp:invoke>
</div>
<footer >
        <p>&copy; 2024 Bank Management System. All rights reserved.</p>
    </footer>
</body>
</html>
