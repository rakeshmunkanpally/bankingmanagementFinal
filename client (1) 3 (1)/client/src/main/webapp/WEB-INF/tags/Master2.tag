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
   <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/MyStyles.css"> 
    <link href="https://fonts.googleapis.com/css?family=Arvo&display=swap" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="/images/phoenixlogo.png">
    <style>
        .dropdown {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            /* min-width: 160px;  
            /* box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            z-index: 1 */;
        }
        .dropdown a {
            color: black;
            /* padding: 12px 16px; */
            /* text-decoration: none; */
           font-size:20px;
            display: block;
        }
        .dropdown a:hover {
            background-color: #f1f1f1;
        }
        .dropdown-wrapper:hover .dropdown {
            display: block;
        }
         .dropdown li {
             display: block; 
             clear: both;    
        }
                .color-burn {
    mix-blend-mode: color-burn;
    width: 100%;
    height: 100%;
    position: absolute;
    top: 20;
    left: 10;
}

/* Adjust the opacity of the color-burn layer to control the intensity of the effect */
.color-burn {
    opacity: 2; /* Adjust the opacity value as needed */
}
    </style> 
    <jsp:invoke fragment="header"></jsp:invoke>
    <title>${title}</title>
</head>
<body style="Background-color:#F0F8FF">
    <div class="wrapper" style="margin-top: 1px; background-color:#537887; height: 70px;">
        <div class="bg" style="color: white; font-size:48px;text-align: center;"> ${heading} </div>
    </div>

    <nav role="navigation" class="primary-navigation" style=" height: 70px;z-index: 3;margin-top:20px;background-color: #5F9EA0; ">
        <ul style=" font-size:30px;">
        <li style="height: 40px; margin-top: 0px; padding-left: 50px"><img src="${pageContext.request.contextPath}/images/phoenixlogo.png" alt="profileImg" style="height:90px; width:90px ;" id="logo" class="color-burn"><a></a></li>
             <li style="padding-left: 500px"><a href="./userhome">HomePage</a></li>
         <li style="padding-left: 25px"><a href="./deposit">Deposit</a></li>
			<li style="padding-left: 25px"><a href="./withdraw">Withdraw</a></li>
			<li style="padding-left: 25px"><a href="/bankmanagement/client/user/transfer">Transfer</a></li>
			<li style="padding-left: 25px"><a href="./transactions">Transaction Details</a></li>
			<li style="padding-left: 25px"><a href="./checkBalance">Check Balance</a></li>
            <li class="dropdown-wrapper">
                <a href="#" onclick="toggleDropdown()"><img src="${pageContext.request.contextPath}/images/adminProfile.png" alt="profileImg" style="height:50px; width:100%; "></a>
                <ul class="dropdown" id="profileDropdown">
                    <li><a href="/bankmanagement/client/user/userprofile">Profile</a></li>
                    <li><a href="/bankmanagement/client/user/logout">Logout</a></li>
                </ul>
            </li>
        </ul>
    </nav>
    <div style="width:100%; margin-top: -3%; z-index: 2">
        <c:if test="${sessionScope.Username!=null}">
            <h3>Welcome<c:out value="${sessionScope.Username }"></c:out></h3>
        </c:if>
        <div style="position: absolute;border-color:#96aeba; margin-top:4%; margin-left:0%; z-index: -1" >
            <img alt="No Img" src="${pageContext.request.contextPath}/images/bank4.jpg" style="float:left; margin-right:5px;width:111%;height:780px;opacity: 0.7;" id="background"> 
        </div>
    </div>
    <div style="margin-top: 10%">
        <jsp:invoke fragment="content"></jsp:invoke>
    </div>
    <script>
        function toggleDropdown() {
            var dropdown = document.getElementById("profileDropdown");
            dropdown.style.display = (dropdown.style.display === "block") ? "none" : "block";
        }
    </script>
</body>
</html>
