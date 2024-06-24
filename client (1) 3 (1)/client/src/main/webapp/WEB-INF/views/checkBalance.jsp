<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<m:Master2 title="Check Balance" heading="Check Balance">
<jsp:attribute name="header">
 
<style>
 
  h2 {
    color: white;
   font-size:30px;
   text-align:center;
   
  }
  h3
  {
  color: white;
     font-size:14px;
     text-align:center;
  }
  
</style>

<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</jsp:attribute>
 
<jsp:attribute name="content">
 

<h1 style="text-align:center;margin-top:20%;font-size:80px;">${balance}</h1>


</jsp:attribute>
</m:Master2>