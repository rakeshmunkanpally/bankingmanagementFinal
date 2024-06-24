<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<m:Master2 title="Deposit" heading="Deposit">
<jsp:attribute name="header">
</jsp:attribute>
<jsp:attribute name="content">
<style>
#popup {
        display: none;
        position: fixed;
        top: 20%;
        width:500px;
        height:150px;
        left: 45%;
        transform: translate(-50%, -50%);
        background-color: black;
        padding: 20px;
        border-radius: 10px;
       
        z-index: 1000; /* ensure it appears above other content */
    }
 
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#popupbutton").click(function(){
		$("#popup").hide();	
	})

});
</script>
<div style="position: absolute; width:30%;background-color:#3c5e6a; padding: 20px; z-index: 2; margin-left: 30%; margin-top: 0%;padding-bottom: 25px" >
 
<h2 >WithDraw Into Account</h2>
<h3 >Please enter the below details.</h3> 
<c:if test="${msg!=null}">
<div
				style="display: flex; justify-content: center; background-color: #f0f0f0; align-items: center;"
				id="popup">
      
        <div style="text-align: center;">
            <h2 style="color: #008B8B; font-size:20px;">${msg}</h2>
            <button id="popupbutton" 
						 onclick="closePopup();"
						style="margin: 5px;padding">ok</button>
        </div>
  </div>  
</c:if>
 
 
<f:form  style="background-color: #f2f2f2;" action="validatewithdraw" modelAttribute="withdraw" >
<table style="position: absolute;left:0%;top:120%; width:100%; height: 130%;background-color:#f2f2f2; padding-top: 5px" cellspacing="20px" >
  <tr >
    <td>Amount </td>
    <td><f:input path="amount"/></td>
    <td><f:errors path="amount" cssClass="error"></f:errors></td>
  </tr>
  <tr>
    <td>Remarks </td>
    <td><f:input path="remarks" /></td>
    <td><f:errors path="remarks" cssClass="error"></f:errors></td>
  </tr>
<tr >
  <td colspan="10"><button type="submit" id="submit">Submit</button></td>
</tr>
</table>
</f:form>
</div>
</jsp:attribute>
</m:Master2>