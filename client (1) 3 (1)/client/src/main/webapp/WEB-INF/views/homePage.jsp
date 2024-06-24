<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tags:master heading="Bank Home" title="Bank Home">
<jsp:attribute name="header">
</jsp:attribute>
<jsp:attribute name="content">
<style>
    body {
      background-color: #cedeee;
    }
  </style>
</head>
<body >
		<div style="width:100%; margin-top: 0%; z-index: 2">
		<c:if test="${sessionScope.Username!=null}">
     <h3 style="text-align:center;margin-top:20%;">Welcome<c:out value="${sessionScope.Username }"></c:out></h3>		
</c:if>
<img alt="No Img" src="${pageContext.request.contextPath}/images/home7.jpg" style="float:left; margin-right:10px;margin-left:10px;width:1100px;height:718px; opacity: 0.8">
<div style="float: right;margin-top: 10%;font-family:Arial, sans-serif;font-size: 50px;margin-right:50px;font-weight: light; padding-left:50px;color:black;">Bank are there to support
<br>the businesses that have
<br>justifiable needs!</div>
</div>
<div style="margin-top: 10%">
</div>
</jsp:attribute>
</tags:master>
