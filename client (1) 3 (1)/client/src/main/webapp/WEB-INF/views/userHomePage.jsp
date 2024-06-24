<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tags:Master2  heading="USER HOME PAGE" title="User Home Page">
<jsp:attribute name="header">
<style type="text/css">
/* td{
 padding: 0px 0px 0px 0px;
} */
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>


</jsp:attribute>
	<jsp:attribute name="content">

<h1 style="text-align:center;margin-top:20%;font-size:80px;">
Welcome ${sessionScope.firstName}  ${sessionScope.accountNo}
</h1>

</jsp:attribute>

</tags:Master2>