<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tags:adminHome heading="Applications" title="Admin Home Page">
<jsp:attribute name="header">
<style type="text/css">
td{
 padding: 0px 0px 0px 0px;
}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</jsp:attribute>
	<jsp:attribute name="content">

<div class="table-responsive" style="width: 1300px">
<h1>No  Applications To Found AT this Time</h1>
 <table class="table"  style="font-size:medium; align-content: center; padding: 0%;" >
 
  </table>
</div>
</jsp:attribute>

</tags:adminHome>